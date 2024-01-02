def jobsequencing(arr, t):
    n = len(arr)
    for i in range(n):
        for j in range(n - i - 1):
            if arr[j][2] < arr[j + 1][2]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    bol = [False] * t
    job = ["-1"] * t
    for i in range(n):
        for j in range(min(t - 1, arr[i][1] - 1), -1, -1):
            if bol[j] is False:
                bol[j] = True
                job[j] = arr[i][0]
                break
    return job


arr = [
    ["J1", 1, 10],
    ["J2", 2, 20],
    ["J3", 2, 15],
    ["J4", 3, 5],
    ["J5", 3, 1],
]

n = jobsequencing(arr, 3)
print(n)
