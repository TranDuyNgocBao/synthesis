import numpy as np


class PCA:

    def __init__(self, n_components):
        self.variance_ratio = None
        self.mean_ = None
        self.std_ = None
        self.cov_matx = None
        self.n_components_ = n_components
        self.components = None
        self.eigvals = None
        self.eigvecs = None
        self.n_sample, self.feature = None, None

    def eig(self, X):
        self.eigvals, self.eigvecs = np.linalg.eig(X)
        self.eigvals, self.eigvecs = np.real(self.eigvals), np.real(self.eigvecs)
        idx_sort = np.argsort(self.eigvals)[::-1]
        self.eigvals, self.eigvecs = self.eigvals[idx_sort], self.eigvecs[:, idx_sort]

    def fit(self, X):
        # x_norm = (x - mean) / sigma
        self.mean_ = np.mean(X, axis=0)
        self.std_ = np.std(X, axis=0)
        self.std_[self.std_ == 0.] = 1.
        X_norm = (X - self.mean_) / self.std_

        self.n_sample, self.feature = X.shape
        # Covariance matrix         
        self.cov_matx = np.dot(X_norm.T, X_norm) / self.n_sample

        # Eigenvalues, Eigenvectors
        self.eig(self.cov_matx)

        self.components = self.eigvecs[:, :self.n_components_]

    def transform(self, X):
        X_norm = (X - self.mean_) / self.std_
        return X_norm @ self.components

    def fit_transform(self, X):
        self.fit(X)
        return self.transform(X)

    def information_percent(self):
        ratio = self.eigvals / sum(self.eigvals)
        total = ratio.cumsum()
        return total[:self.n_components_]

    def project_data(self, X):
        X_norm = (X - self.mean_) / self.std_
        project = (self.components @ self.components.T @ X_norm.T).T * self.std_ + self.mean_
        return project
