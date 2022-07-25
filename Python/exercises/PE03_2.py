import re
import sqlite3

conn = sqlite3.connect('DNSList.sqlite')
cur = conn.cursor()

cur.executescript('''DROP TABLE IF EXISTS DNS;
CREATE TABLE DNS(IP TEXT, Reliability INTEGER, Description TEXT)''')

while(True):
    filename = input('Enter file name: ')
    try:
        handle = open(filename)
        break
    except:
        if len(filename) < 1:
            handle = open('DNSList.txt')
            break
        else:
            print('Wrong name of file to open')

ip_address = re.findall('IP Address: (\S.+)', handle.read())
for ip in ip_address:
    ip = ip.rstrip();
    ip = ip.replace(' ', '')
    tmp = ip.split(':')

    cur.execute('SELECT IP FROM DNS WHERE IP = ?', (tmp[0],))
    row = cur.fetchone()

    if row is None:
        cur.execute('''INSERT INTO DNS (IP, Reliability) VALUES (?,?)''', (tmp[0], tmp[1],))

    conn.commit()

cur.execute('''UPDATE DNS
            SET Description = CASE
                                WHEN Reliability < 50 THEN 'Low'
                                ELSE 'Normal'
                            END
            ''')

sqlstr = 'SELECT * FROM DNS ORDER BY Reliability DESC'

print('DNS server list:')
print("{:<20}{:<20}{:<10}".format(' IP', 'Reliability', 'Description'))
for row in cur.execute(sqlstr):
    print("{:<24}{:<16}{:<10}".format(row[0], row[1], row[2]))

cur.close()