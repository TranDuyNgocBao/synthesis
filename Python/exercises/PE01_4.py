def Input_Integer():
    while True:
        rawStr = input('Enter a positive integer number: ')
        try:
            num = int(rawStr)
            if num < 0: print('The number must be positive')
            elif float(rawStr) != num: print('The number must be an integer')
            else: return num
        except:
            print('The number must be a positive')

def perfect_cube(dest):
    i = 2
    cube = i*i*i
    while cube <= dest:
        print(cube, end=' ')
        i += 1
        cube = i * i * i

num = Input_Integer()
print('The perfect cube from 0 to ' + str(num) + ':')
perfect_cube(num)