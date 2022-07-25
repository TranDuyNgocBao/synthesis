# import numpy as np
# import idx2numpy
# import matplotlib.pyplot as plt
# import seaborn as sns
#
# X_train = idx2numpy.convert_from_file('train-images.idx3-ubyte')
# X_train = X_train.reshape(len(X_train), -1)
# y_train = idx2numpy.convert_from_file('train-labels.idx1-ubyte')
#
# X_test = idx2numpy.convert_from_file('t10k-images.idx3-ubyte')
# X_test = X_test.reshape(len(X_test), -1)
# y_test = idx2numpy.convert_from_file('t10k-labels.idx1-ubyte')
#
# from sklearn.preprocessing import StandardScaler
#
# sc = StandardScaler()
# X_train = sc.fit_transform(X_train)
# X_test = sc.transform(X_test)
#
# from sklearn.decomposition import PCA
#
# pca = PCA(n_components=3) #n_components=1
# X_train = pca.fit_transform(X_train)
# X_test = pca.transform(X_test)
#
# # mảng tập hợp các giá trị tính toán var
# explained_variance = pca.explained_variance_ratio_
# print(explained_variance)
#
# from sklearn.ensemble import RandomForestClassifier
#
# classifier = RandomForestClassifier(max_depth=2, random_state=0)
# classifier.fit(X_train, y_train)
#
# # Predicting the Test set results
# y_pred = classifier.predict(X_test)
#
# from sklearn.metrics import confusion_matrix
# from sklearn.metrics import accuracy_score
#
# cm = confusion_matrix(y_test, y_pred)
# print(cm)
# print('Accuracy:', accuracy_score(y_test, y_pred))

from numpy import array
from sklearn.decomposition import PCA
from sklearn.preprocessing import StandardScaler
# define a matrix
# print(X)
X = [[-8, -14, -6], [12,-7,4], [-11,-3,-21], [-22,-27,8]]
X_std = StandardScaler().fit_transform(X)
# create the PCA instance
pca = PCA(1)
# fit on data
pca.fit(X_std)
# access values and vectors
# print(pca.components_)
print(pca.explained_variance_)
# transform data
B = pca.transform(X_std)
print(B)

