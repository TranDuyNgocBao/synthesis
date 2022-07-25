import sqlite3

conn = sqlite3.connect('Student.sqlite')
cur = conn.cursor()

cur.executescript('''DROP TABLE IF EXISTS Student;
CREATE TABLE Student(Name TEXT, Course TEXT, Grade INTEGER, Description TEXT)''')

while True:
    filename = input('Enter file: ')
    try:
        handle = open(filename)
        break
    except:
        if len(filename)<1:
            handle = open('Student.txt')
            break
        else:
            print('Wrong file name to open')

student_list = handle.read().split('\n\n')
for student in student_list:
    tmp = student.split('\n')
    name = tmp[0].split(': ')[1]
    course = tmp[1].split(': ')[1]
    grade = tmp[2].split(': ')[1]

    cur.execute('SELECT * FROM Student WHERE Name = ? AND Course = ? AND Grade = ?', (name, course, grade, ))
    row = cur.fetchone()

    if row is None:
        cur.execute('INSERT INTO Student (Name, Course, Grade) VALUES (?,?,?)', (name, course, grade, ))

    conn.commit()

cur.execute('''UPDATE Student
            SET Description = CASE
                                WHEN Grade < 50 THEN 'Fail'
                                ELSE 'Pass'
                            END
            ''')

sqlstr = 'SELECT * FROM Student ORDER BY Grade DESC'
print('Student list:')
print("{:<15}{:<15}{:<10}{:<10}".format('Name', 'Course', 'Grade', 'Description'))
for row in cur.execute(sqlstr):
    print("{:<15}{:<15}{:<10}{:<10}".format(row[0], row[1], row[2], row[3]))

cur.close()
