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

courses = dict()
for line in handle:
    line = line.rstrip()
    if line.startswith('Course: '):
        tmp = line.split(' ')
        courses[tmp[1]] = courses.get(tmp[1], 0) + 1

print('Course Summary:')
print("{:<10}{:<10}".format('Course', 'Count'))
for key in sorted(courses):
    print("{:<10}{:<10}".format(key, courses[key]))