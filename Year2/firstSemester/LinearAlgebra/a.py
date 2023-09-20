import numpy as np

A = np.array ([
     [1, 2, 1],
     [2, 1, 2],
     [1, 2, 1]
     ])

B = np.array ([
     [3, 2, 3],
     [2, 3, 2],
     [3, 2, 3]
     ])

C = A*B
print(C)
print(np.linalg.det(A))
IA = np.linalg.inv(A)
print(IA)
