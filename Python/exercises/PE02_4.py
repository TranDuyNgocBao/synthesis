import re
while True:
    filename = input('Enter file name: ')
    try:
        handle = open(filename)
        break
    except:
        if len(filename) < 1:
            handle = open('mbox-short.txt')
            break
        else:
            print('Wrong file name to open')

fileStr = handle.read()
listNum = re.findall('X-DSPAM-Confidence: (\S+)', fileStr)
average = 0
length = len(listNum)
for num in listNum:
    average = (average + float(num))

print(average/length)