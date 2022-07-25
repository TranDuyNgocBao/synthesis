import numpy as np
from sklearn.model_selection import train_test_split

data = np.loadtxt('kc_house_price.txt', delimiter=',', usecols=(2,3,5), skiprows=1)
data = data.astype(float)

def data_standardization(arr):
    u = np.mean(arr)
    sd = np.std(arr)
    with np.nditer(arr, op_flags=['readwrite']) as it:
        for x in it:
            x[...] = (x - u)/sd
    return arr

data = data_standardization(data)

train, test = train_test_split(data, train_size=0.7, random_state=2)

np.savetxt("train.csv", train)
np.savetxt("test.csv", test)