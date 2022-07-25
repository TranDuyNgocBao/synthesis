import matplotlib.pyplot as plt
import numpy as np
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error

data_train = np.loadtxt('train.csv')
X_train = data_train[:,[1,2]]
y_train = data_train[:,0]

data_test = np.loadtxt('test.csv')
X_test = data_test[:,[1,2]]
y_test = data_test[:,0]

def LR_sklearn(X_train, y_train, X_test, y_test, xtitle, ytitle):
    # lấy model LinearRegression từ thư viên SKlearn
    model = LinearRegression()
    # thực hiện train model trên tập train
    model.fit(X_train, y_train)

    # thực hiện train model trên tập test
    y_hat = model.predict(X_test)
    # tính sai số lỗi MSE của dự đoán so với thực tế trên tập test
    mse = mean_squared_error(y_hat, y_test)
    print(mse)

    # hiển thị đồ thị dữ liệu test (xanh) và đường dự đoán đã học được (đỏ)
    plt.scatter(X_test, y_test)
    plt.plot(X_test, y_hat, 'r')
    plt.xlabel(xtitle)
    plt.ylabel(ytitle)
    plt.show()
    # in weight w0, w1 mà model của sklearn đã học
    # print(model.coef_, model.intercept_)
    print(model.intercept_)

LR_sklearn(X_train[:,0].reshape(len(X_train[:,0]), 1), y_train,
           X_test[:,0].reshape(len(X_test[:,0]), 1), y_test,
           'Bedrooms', 'Price')

LR_sklearn(X_train[:,1].reshape(len(X_train[:,1]), 1), y_train,
           X_test[:,1].reshape(len(X_test[:,1]), 1), y_test,
           'sqft_living', 'Price')




