import re
import sqlite3

conn = sqlite3.connect('Movie.sqlite')
cur = conn.cursor()

cur.executescript('''DROP TABLE IF EXISTS Movie;
CREATE TABLE Movie(movieID TEXT, length INTEGER, Des TEXT)''')

while True:
    filename = input('Enter file: ')
    try:
        handle = open(filename)
        break
    except:
        if len(filename)<1:
            handle = open('Movie.txt')
            break
        else:
            print('Wrong file name to open')

for line in handle:
    if line.startswith('Movie:'):
        tmp = line.split()
        tmp = tmp[1].split('-')
        movieID = tmp[0]
        length = tmp[1]
        Des = re.findall('[^0-9]+', tmp[0])[0]

        cur.execute('SELECT * FROM Movie WHERE movieID = ?', (movieID,))
        row = cur.fetchone()

        if row is None:
            if Des == 'Act':
                cur.execute('INSERT INTO Movie (movieID, length, Des) VALUES (?,?,"Action Movie")', (movieID, length, ))
            else:
                cur.execute('INSERT INTO Movie (movieID, length, Des) VALUES (?,?,"Scientific Movie")', (movieID, length,))

        conn.commit()

sqlstr = 'SELECT * FROM Movie ORDER BY length DESC'
print('Movie list:')
print("{:<10}{:<10}{:<10}".format('Movie', 'Length', 'Description'))
for row in cur.execute(sqlstr):
    print("{:<10}{:<10}{:<10}".format(row[0], row[1], row[2]))

cur.close()
