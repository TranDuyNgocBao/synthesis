def input_Integer():
    num = -1
    while (num < 0):
        rawStr = input('Enter a positive integer: ')

        try:
            if float(rawStr) == int(rawStr):
                num = int(rawStr)
            if num <= 0:
                print('The number must be positive.')
            else:
                return num
        except:
            print('The number must be a positive number.')
            num = -1

def perfect_num(number):
    sumN = 1

    i = 2
    while i * i <= number:
        if number % i == 0:
            if i*i != number:
                sumN = sumN + i + number/i
            else: sumN = sumN + i
        i += 1

    return (True if (sumN == number) & (sumN != 1) else False)

def find_num(dest):
    for num in range(dest+1):
        if perfect_num(num) is True:
            print(num, end=' ')

find_num(input_Integer())

