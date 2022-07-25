def Input_integer():
    while(True):
        rawStr = input('Enter a positive integer number: ')
        try:
            num = int(rawStr)
            if num < 0: print('The number must be positive')
            elif float(rawStr) != int(num): print('The number must be an integer')
            else: return num
        except:
            print('The number must be a positive')

def Fibonacci_sequence(rang):
    f0 = 0
    f1 = 1
    if rang == 1: print(f0)
    elif rang == 2: print(f0, f1)
    else:
        print(f0, f1, end=' ')
        for i in range(2,rang):
            f2 = f0 + f1
            f0 = f1
            f1 = f2
            print(f2, end=' ')

Fibonacci_sequence(Input_integer())