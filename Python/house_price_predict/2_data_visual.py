import matplotlib.pyplot as plt
import numpy as np

def plot_univariate(x, y, xlabel, ylabel, title):
    plt.scatter(x,y)
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

data = np.loadtxt('train.csv')

X = data[:,[1,2]]
y = data[:,0]

# 2D Plot
plot_univariate(X[:,0],y,'bedrooms', 'price', 'bedrooms vs price')
plot_univariate(X[:,1],y,'sqft_living', 'price', 'sqft_living vs price')

# 3D Plot
plot_multivariate(X[:,0], X[:,1], y, 'bedrooms', 'sqft_living', 'price', '3D plot')