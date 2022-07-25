from sklearn.model_selection import train_test_split
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

# READ FILE
files = "kc_house_price.txt"
df = pd.read_csv(files)
print(df)

#SELECT FEATURES AND SPLIT DATA
#select features
features = df[["sqft_living", "bedrooms", "price"]]

#split data
train, test = train_test_split(features, train_size=0.7, random_state=2)
train.dropna()
test.dropna()
train = train.astype(float)
test = test.astype(float)
print(train)
train.to_csv("train.csv", index=False)
test.to_csv("test.csv", index=False)

#STATISTICAL SUMMARY
train_file = "train.csv"
train = pd.read_csv(train_file)

X = train[["sqft_living", "bedrooms"]].values
y = train[["price"]].values

print("{:<30}{:<15}{:<15}{:<10}".format('Summation Statistic:','Price', 'Sqft_Living', 'Bedrooms'))
print("{:<30}{:<15}{:<15}{:<10}".format('Max:',np.max(y), np.max(X[:,0]), np.max(X[:,1])))
print("{:<30}{:<15}{:<15}{:<10}".format('Min:',np.min(y), np.min(X[:,0]), np.min(X[:,1])))
print("{:<30}{:<15}{:<15}{:<10}".format('Median:',np.median(y), np.median(X[:,0]), np.median(X[:,1])))
print("{:<30}{:<15.2f}{:<15.2f}{:<10.2f}".format('Average:', np.average(y) , np.average(X[:,0]), np.average(X[:,1])))
print("{:<30}{:<15.2f}{:<15.2f}{:<10.2f}".format('Mean:',np.mean(y), np.mean(X[:,0]), np.mean(X[:,1])))
print("{:<30}{:<15.2f}{:<15.2f}{:<10.2f}".format('Standard Deviation:',np.std(y), np.std(X[:,0]), np.std(X[:,1])))

# plt.hist(X[:,0], bins = 400, label = "sqft_living")
# plt.show()
# plt.hist(X[:,1], bins = 170, label = "bedrooms")
# plt.show()
# plt.hist(y[:], bins = 1000, label = "price")
# plt.show()

#PLOT UNIVARIATE AND MULTIVARIATE PLOTS
def plot_univariate(x, y, xlabel, ylabel, title):
    plt.scatter(x, y)
    plt.xlabel(xlabel)
    plt.ylabel(ylabel)
    plt.title(title)
    plt.show()


def plot_multivariate(x, y, z, xlabel, ylabel, zlabel, title):
    ax = plt.axes(projection="3d")
    ax.scatter(x, y, z)
    ax.set_xlabel(xlabel)
    ax.set_ylabel(ylabel)
    ax.set_zlabel(zlabel)
    plt.title(title)
    plt.show()


train_file = "train.csv"
train = pd.read_csv(train_file)

x = train[["sqft_living", "bedrooms"]]
y = train["price"]

# 3D plot
# plot_multivariate(x["sqft_living"], x["bedrooms"], y,
#                   "sqft_living", "bedrooms", "price",
#                   "sqft, bedrooms - price")
# # 2D plot
# plot_univariate(x["sqft_living"], y,
#                 "sqft_living", "price",
#                 "sqft - price")
#
# plot_univariate(x["bedrooms"], y,
#                 "bedrooms", "price",
#                 "bedrooms - price")

#BUILD AND EVALUATE REGRESSION MODEL
train_file = "train.csv"
data = pd.read_csv(train_file)
numrow = data.shape[0]
XT = np.array([np.ones(numrow), data['sqft_living'].values, data['bedrooms'].values])
YT = np.array([data['price'].values])
print("X = \n", XT.T)
print("Y = \n", YT.T)

x = XT.T.max(axis=0)
y = YT.T.max(axis=0)
XT = (XT.T / x).T
YT = (YT.T / y).T
print("X = \n", XT.T)
print("Y = \n", YT.T)

stepcost = 0.0000635
w0 = np.array([[0], [0], [0]])

w1 = w0 + 2*stepcost*(XT @ (YT.T - XT.T @ w0))
cost0 = (YT - w0.T @ XT) @ (YT.T - XT.T @ w0)
cost1 = (YT - w1.T @ XT) @ (YT.T - XT.T @ w1)
print("cost0 = ", cost0)
print("cost1 = ", cost1)

def plot_multivariate(x, y, z, z2, xlabel, ylabel, zlabel, title):
    ax = plt.axes(projection="3d")
    ax.scatter(x, y, z, 'bo-', label = 'price')
    ax.scatter(x, y, z2, 'ro-', label = 'price_predict')
    ax.set_xlabel(xlabel)
    ax.set_ylabel(ylabel)
    ax.set_zlabel(zlabel)
    plt.title(title)

while cost0 > cost1:
    w0 = w1

    θT = w0.T
    print("θT = ", θT)

    # PREDICTION
    test_file = "test.csv"
    datatest = pd.read_csv(test_file)
    numrow2 = datatest.shape[0]
    X2T = np.array([np.ones(numrow2), datatest['sqft_living'].values, datatest['bedrooms'].values])
    Y2T = np.array([datatest['price'].values])
    X2T = (X2T.T / x).T
    Y2T = (Y2T.T / y).T

    Y_expectT = θT @ X2T
    Error = abs((Y_expectT - Y2T) / (Y2T))
    Y_expectT *= y

    dict1 = {"sqft_living": datatest['sqft_living'].values, "bedrooms": datatest['bedrooms'].values,
             "price": datatest['price'].values, "price_predict": Y_expectT[0], "error": Error[0]}
    output = pd.DataFrame(dict1)
    print(output)
    output.to_csv("price_predict.csv", index=False)

    file = "price_predict.csv"
    data = pd.read_csv(file)
    x = data[["sqft_living", "bedrooms"]]
    y = data[["price", "price_predict"]]
    plot_multivariate(x["sqft_living"], x["bedrooms"], y["price"], y["price_predict"],
                      "sqft_living", "bedrooms", "price",
                      "sqft, bedrooms - price")

    w1 = w0 + 2 * stepcost * (XT @ (YT.T - XT.T @ w0))
    cost0 = (YT - w0.T @ XT) @ (YT.T - XT.T @ w0)
    cost1 = (YT - w1.T @ XT) @ (YT.T - XT.T @ w1)



# Use Formula
#θT = YT @ XT.T @ np.linalg.inv(XT @ XT.T)
#print("θT = ",θT)
