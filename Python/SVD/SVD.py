import numpy as np


class SVD:

    def __init__(self, matrix):
        self.matrix = matrix
        self.m, self.n = matrix.shape
        self.rank = np.linalg.matrix_rank(matrix)
        self.U = np.zeros((self.m, self.m))
        self.lamda = None
        self.V = np.zeros((self.n, self.n))

    def svd(self):
        if self.m > self.n:  # A*A^T
            AAT = self.matrix @ self.matrix.T
            e, v = np.linalg.eig(AAT)
            U_aat = dict()
            e, v = e.real, v.real

            for i in range(len(e)):
                U_aat[e[i]] = v[:, i]
            e.sort()
            e = e[::-1]

            for i in range(self.m):
                self.U[:, i] = U_aat[e[i]]

            for i in range(self.n):
                self.V[:, i] = np.dot(self.matrix.T, self.U[:, i]) / np.sqrt(e[i])
        else:  # A^T*A
            ATA = self.matrix.T @ self.matrix
            e, v = np.linalg.eig(ATA)
            V_ata = dict()
            e, v = e.real, v.real

            for i in range(len(e)):
                V_ata[e[i]] = v[:, i]
            e.sort()
            e = e[::-1]

            for i in range(self.n):
                self.V[:, i] = V_ata[e[i]]

            for i in range(self.m):
                self.U[:, i] = np.dot(self.matrix, self.V[:, i]) / np.sqrt(e[i])

        leng = self.n if self.m > self.n else self.m
        self.lamda = np.zeros((leng))
        for i in range(leng):
            self.lamda[i] = np.sqrt(e[i])
        return self.U, self.lamda, self.V.T

    def rank_1(self, ith):
        u_ith = self.U[:, ith].reshape(len(self.U[:, ith]), 1)
        v_ith = self.V[:, ith].reshape(len(self.V[:, ith]), 1)
        v_ithT = v_ith.T
        return u_ith @ v_ithT

    def matrix_approximation(self, rank):
        error_mau = sum(self.lamda)
        error_tu = sum(self.lamda[rank:])
        total = np.zeros((self.m, self.n))

        for ith in range(rank):
            total += (self.lamda[ith] * self.rank_1(ith))

        error = error_tu / error_mau
        return total, error

import cv2
import matplotlib.pyplot as plt
path = "flower.jpg"
img = cv2.imread(path, 0)
matx = img.astype(np.float64)
print("Original matrix:\n", matx)
print("Shape: ", matx.shape)
print("Rank:", np.linalg.matrix_rank(matx))
svd_b = SVD(matx)
U, lamda, Vt = svd_b.svd()
print("U = \n", U[:5])
print("lamda = \n", lamda[:5])
print("V^T = \n", Vt[:5])
matx_app = dict()
for rank in [5, 20, 45, 60]:
    matx_app[rank], e = svd_b.matrix_approximation(rank)
fig, ax = plt.subplots(2, 2)
fig.set_size_inches(8, 6)
ax[0, 0].imshow(matx_app[5], cmap="gray")
ax[0, 0].set_title("Rank 5")
ax[0, 0].axis("off")
ax[0, 1].imshow(matx_app[20], cmap="gray")
ax[0, 1].set_title("Rank 20")
ax[0, 1].axis("off")
ax[1, 0].imshow(matx_app[45], cmap="gray")
ax[1, 0].set_title("Rank 45")
ax[1, 0].axis("off")
ax[1, 1].imshow(matx_app[60], cmap="gray")
ax[1, 1].set_title("Rank 60")
ax[1, 1].axis("off")
plt.show()