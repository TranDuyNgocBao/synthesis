import sqlite3

conn = sqlite3.connect('Trace.sqlite')
cur = conn.cursor()

cur.execute('DROP TABLE IF EXISTS Providers')

cur.execute('CREATE TABLE Providers(Pname TEXT, Pcount INTEGER, Pwarning TEXT)')

filename = input('Enter file name: ')
try:
    handle = open(filename)
except:
    if len(filename) < 1:
        handle = open('Trace.txt')
    else:
        print('Wrong file to open')

providers_count = dict()
for line in handle:
    if not line.startswith('Name: '): continue

    line = line.rstrip()
    tmp = line.split()
    tmp = tmp[1].split('-')
    pname = tmp[0]
    providers_count[pname] = providers_count.get(pname, 0) + 1

    cur.execute('SELECT Pcount, Pwarning FROM Providers WHERE Pname= ?', (pname,))
    row = cur.fetchone()

    if row is None:
        cur.execute('''INSERT INTO Providers (Pname, Pcount, Pwarning)
                    VALUES (?,1,'Normal')''', (pname,))
    else:
        cur.execute('''UPDATE Providers
                    SET Pcount = Pcount +1
                    WHERE Pname= ?''', (pname,))
        if providers_count[pname] > 1:
            cur.execute('''UPDATE Providers
                        SET Pwarning = 'High Risk'
                        WHERE Pname= ?''', (pname,))
    conn.commit()

sqlstr = 'SELECT * FROM Providers ORDER BY Pcount DESC'
print('Troubleshoot wired LAN related issues:')
print("{:<11} {:<11} {:<11}".format('provider', 'Count', 'Warning'))
for row in cur.execute(sqlstr):
    print("{:<11} {:<11} {:<11}".format(row[0], row[1], row[2]))

cur.close()