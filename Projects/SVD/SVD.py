import numpy as np


class SVD:

    def __init__(self, matrix):
        self.matrix = matrix
        self.m, self.n = matrix.shape
        self.U = np.zeros((self.m, self.m))
        self.lamda = None
        self.V = np.zeros((self.n, self.n))

    def svd(self):
        if self.m > self.n:  # A*A^T => vector U
            AAT = self.matrix @ self.matrix.T
            eigvals, eigvecs = np.linalg.eig(AAT)
            eigvals, eigvecs = eigvals.real, eigvecs.real
            U_aat = dict()

            for i in range(len(eigvals)):
                U_aat[eigvals[i]] = eigvecs[:, i]
            eigvals.sort()
            eigvals = eigvals[::-1]
            
            # Vector U             
            for i in range(self.m):
                self.U[:, i] = U_aat[eigvals[i]]
            
            # Compute vector V by using vector U
            # vi = A^T * ui / oi           
            for i in range(self.n):
                self.V[:, i] = np.dot(self.matrix.T, self.U[:, i]) / np.sqrt(eigvals[i])

        else:  # A^T*A => vector V
            ATA = self.matrix.T @ self.matrix
            eigvals, eigvecs = np.linalg.eig(ATA)
            V_ata = dict()

            eigvals, eigvecs = eigvals.real, eigvecs.real

            for i in range(len(eigvals)):
                V_ata[eigvals[i]] = eigvecs[:, i]
            eigvals.sort()
            eigvals = eigvals[::-1]

            # Vector V
            for i in range(self.n):
                self.V[:, i] = V_ata[eigvals[i]]

            # Compute vector U by using vector V
            # ui = A * vi / oi  
            for i in range(self.m):
                if eigvals[i] != 0:
                    self.U[:, i] = np.dot(self.matrix, self.V[:, i]) / np.sqrt(eigvals[i])

        leng = self.n if self.m > self.n else self.m
        self.lamda = np.zeros((leng))
        for i in range(leng):
            self.lamda[i] = np.sqrt(eigvals[i])
        return self.U, self.lamda, self.V.T

    def rank_1(self, ith):
        # Ai = ui * vi^T        
        u_ith = self.U[:, ith].reshape(len(self.U[:, ith]), 1)
        v_ith = self.V[:, ith].reshape(len(self.V[:, ith]), 1)
        v_ithT = v_ith.T
        return u_ith @ v_ithT

    def matrix_approximation(self, rank):         
        error_mau = sum(self.lamda)
        error_tu = sum(self.lamda[rank:])
        total = np.zeros((self.m, self.n))
        # Error = (o_i + o_i+1 + o_i+2 + ...) / sum(o)         
        for ith in range(rank):
            total += (self.lamda[ith] * self.rank_1(ith))
        error = error_tu / error_mau
        return total, error
