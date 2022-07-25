import re

while(True):
    filename = input('Enter file name: ')
    try:
        handle = open(filename)
        break
    except:
        if len(filename) < 1:
            handle = open('Trace.txt')
            break
        else:
            print('Wrong name of file to open')

providers = dict()
for line in handle:
    line = line.rstrip()
    if line.startswith('Name: '):
        tmp = line.split()
        tmp = tmp[1].split('-')
        providers[tmp[0]] = providers.get(tmp[0], 0) + 1

print('Troubleshoot wired LAN related issues:')
for key in sorted(providers):
    print(key, providers[key])