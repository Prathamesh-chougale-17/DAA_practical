import numpy as np


def min_del_arr(m, i, j):
    m = np.delete(m, i, axis=0)
    m = np.delete(m, j, axis=1)
    s = sum(np.min(m, axis=0))
    return s


def min_cost(m):
    vis = [-1] * len(m)
    for j in range(len(m)):
        mini = float("inf")
        k = 0
        for i in range(len(m)):
            min_del = min_del_arr(m, j, i) + m[j][i]
            if min_del < mini and vis[i] == -1:
                mini = min_del
                k = i
        vis[k] = j
    for i in range(len(vis)):
        print(f"For person {i+1}" + " Job is ", vis[i] + 1)


cost_matrix = np.array([[9, 2, 7, 8], [6, 4, 3, 7], [5, 8, 1, 8], [7, 6, 9, 4]])
min_cost(cost_matrix)
