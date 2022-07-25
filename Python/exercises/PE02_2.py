import re

while(True):
    filename = input('Enter file name: ')
    try:
        handle = open(filename)
        break
    except:
        if len(filename) < 1:
            handle = open('DNSList.txt')
            break
        else:
            print('Wrong name of file to open')

countries = dict()
for line in handle:
    line = line.rstrip()
    if line.startswith('Location:'):
        tmp = re.findall('Location: (.+$)', line)
        countries[tmp[0]] = countries.get(tmp[0], 0) + 1;

print('DNS server list:')
print("{:<20}{:<1}".format('Country', 'Count'))
for key in sorted(countries):
    print("{:<20}{:<1}".format(key, countries[key]))
