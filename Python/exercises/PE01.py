import math

def input_Integer():
    num = -1
    while (num < 0):
        rawStr = input('Input: ')

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

def prime(num):
    #numbers = math.sqrt(num)
    primeNum = list()
    for x in range(0, num+1):
        primeNum.append(-1)
    primeNum[0] = primeNum[1] = 0
    for x in range(2, num+1):
        if primeNum[x] == -1:
            primeNum[x] = 1
            tmp = x
            while tmp + x <= num:
                tmp = tmp + x
                primeNum[tmp] = 0
    return primeNum

def prime_List(dest):
    listPrime = prime(dest)
    for x in range(0,dest+1):
        if listPrime[x] == 1:
            print(x, end=' ')

def main():
    num = input_Integer()
    prime_List(num)

if __name__ == "__main__":
    main()