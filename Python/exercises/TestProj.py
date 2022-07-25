from numpy.matrixlib.defmatrix import matrix
import numpy as np
from scipy.linalg import eig, inv, sqrtm
import matplotlib.pyplot as plt
from PIL import Image

MAX_RANK = 5
FNAME = 'flower.jpg'

image = Image.open(FNAME).convert("L")
img_mat = np.asarray(image)

# A^T * A = PDP^T
transpose_img_mat = img_mat.transpose()

symmetri = np.dot(img_mat, transpose_img_mat)

eVals, P = eig(symmetri)

P_inv = inv(P)

X = np.dot(P_inv, symmetri)
D = np.dot(X, P)

V = P
E = sqrtm(D)

# sigma.Ui = Avi
m_diago = np.diag(D)
k = len(m_diago)
U = np.array([0 for i in range(k)]*k)
k = 0
for i in m_diago:
    tmp = i * np.dot(symmetri, D[:, k])
    print(len(tmp), len(tmp[0]))
    k += 1

print(U)
