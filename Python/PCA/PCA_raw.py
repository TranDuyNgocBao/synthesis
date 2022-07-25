import numpy as np
import idx2numpy
import matplotlib.pyplot as plt
import seaborn as sns

X_train = idx2numpy.convert_from_file('train-images.idx3-ubyte')
X_train = X_train.reshape(len(X_train), -1)
y_train = idx2numpy.convert_from_file('train-labels.idx1-ubyte')

X_test = idx2numpy.convert_from_file('t10k-images.idx3-ubyte')
X_test = X_test.reshape(len(X_test), -1)
y_test = idx2numpy.convert_from_file('t10k-labels.idx1-ubyte')

from sklearn.preprocessing import StandardScaler
sc = StandardScaler()
X_train = sc.fit_transform(X_train)
X_test = sc.transform(X_test)

