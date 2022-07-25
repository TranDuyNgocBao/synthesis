import numpy as np

data = np.loadtxt('train.csv')

X = data[:,[1,2]]
y = data[:,0]

print("{:<30}{:<15}{:<15}{:<10}".format('Summation Statistic:','Price', 'Bedrooms', 'Sqft_Living'))
print("{:<30}{:<15}{:<15}{:<10}".format('Median:',np.median(y), np.median(X[:,0]), np.median(X[:,1])))
print("{:<30}{:<15.2f}{:<15.2f}{:<10.2f}".format('Average:', np.average(y) , np.average(X[:,0]), np.average(X[:,1])))
print("{:<30}{:<15.2f}{:<15.2f}{:<10.2f}".format('Mean:',np.mean(y), np.mean(X[:,0]), np.mean(X[:,1])))
print("{:<30}{:<15.2f}{:<15.2f}{:<10.2f}".format('Standard Deviation:',np.std(y), np.std(X[:,0]), np.std(X[:,1])))