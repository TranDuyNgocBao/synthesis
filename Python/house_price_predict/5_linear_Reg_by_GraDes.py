import matplotlib.pyplot as plt
import numpy as np
from sklearn.metrics import mean_squared_error

data_train = np.loadtxt('train.csv')
X_train = data_train[:,[1,2]]
y_train = data_train[:,0]

data_test = np.loadtxt('test.csv')
X_test = data_test[:,[1,2]]
y_test = data_test[:,0]


class GDLinearRegression:
    def __init__(self, lr, step):
        '''
        Khởi tạo learning rate và số lượng step update weigh
        '''
        self.lr = lr
        self.step = step

    def fit(self, X, y):
        '''
        Train the model với đầu vào là tập train data X cùng nhãn Y
        X là ma trận MxN trong đó M là số lượng điểm dữ liệu, mỗi điểm dữ liệu có N chiều.
        Trường hợp dữ liệu 1 chiều thì X là vector cột Mx1
        '''
        # lấy ra số lượng điểm train_size và số chiều dữ liệu n_features
        self.n_features = X.shape[1] if len(X.shape) > 1 else 1
        train_size = len(X)  # số lượng sample

        # chuẩn hóa lại định dạng dữ liệu
        X = X.reshape(-1, self.n_features)
        y = y.reshape([-1, 1])

        # ta muốn thực hiện dự đoán y = X.T*W + bias, ta đưa bias vào W (W|bias) và 1 cột toàn 1 vào X (X|one),
        # lúc đó việc tính toán thuận tiện hơn y = (X|one).T*(W|bias)
        one = np.ones([train_size, 1])
        X = np.concatenate([X, one], 1)

        # tạo weight chính là parameters ta sẽ optimize trong quá trình train
        self.weight = np.zeros([self.n_features + 1, 1])
        print('x shape: ', X.shape, '- y shape: ', y.shape, '- weight shape: ', self.weight.shape, 'train_size: ',
              train_size)

        # mảng lưu lại toàn bộ giá trị loss trong quá trình train va weight
        self.train_loss = []
        self.train_weigh = []
        self.train_weigh.append(self.weight)

        #train
        for i in range(self.step):

            loss = np.sum((y-np.dot(X,self.weight))**2)
            derivative = np.dot(X.T, (np.dot(X,self.weight) - y))

            # update weight
            self.weight = self.weight - (self.lr / train_size) * derivative
            self.train_weigh.append(self.weight)

            # tính trung bình loss
            loss = loss / (2*train_size)
            # loss = loss / (train_size)
            self.train_loss.append(loss.item())

    def predict(self, X):
        '''
        Thực hiện dự đoán
        '''
        # chuẩn hóa format dữ liệu như ta đã làm trong lúc train
        X = X.reshape(-1, self.n_features)

        # thêm cột one như ta đã làm trong lúc train
        one = np.ones([len(X), 1])
        X = np.concatenate([X, one], 1)

        # thực hiện dự đoán, đơn giản là nhân ma trận
        y_hat = np.dot(X, self.weight)

        return y_hat

    def get_X_scale(self,X):
        # chuẩn hóa format dữ liệu như ta đã làm trong lúc train
        X = X.reshape(-1, self.n_features)

        # thêm cột one như ta đã làm trong lúc train
        one = np.ones([len(X), 1])
        X = np.concatenate([X, one], 1)
        return X

    def print_weight(self):
        '''
        In weigt w đã học được
        '''
        print(self.weight)

    def get_train_weight(self):
        return self.train_weigh

    def get_train_loss(self):
        '''
        Trả về train loss đã lưu trong quá trình train
        '''
        return self.train_loss

liReg = GDLinearRegression(lr = 0.1, step = 100)
liReg.fit(X_train[:,0], y_train)
train_weight = liReg.train_weigh
X = liReg.get_X_scale(X_test[:,0])
for x in train_weight:
    print(x)
    y_hat = np.dot(X, x)
    mse = mean_squared_error(y_hat, y_test)
    # print(mse)

    # hiển thị đồ thị dữ liệu test (xanh) và đường dự đoán đã học được (đỏ)
    plt.scatter(X_test[:,0], y_test, color='blue')
    plt.plot(X_test[:,0], y_hat, 'r')
    plt.xlabel('Bedrooms')
    plt.ylabel('Price')
    plt.pause(0.05)
    plt.clf()
plt.show()

# vẽ biểu đồi training loss
train_loss = liReg.get_train_loss()
plt.plot(range(len(train_loss)), train_loss)
plt.xlabel('Step')
plt.ylabel('Loss')
plt.show()