def jobsequencing(arr, t):
    n = len(arr)
    for i in range(n):
        for j in range(n - 1 - i):
            if arr[j][2] < arr[j + 1][2]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]

    bol = [False] * t
    job = ["-1"] * t
    for i in range(n):
        for j in range(min(arr[i][1] - 1, t - 1), -1, -1):
            if bol[j] is False:
                bol[j] = True
                job[j] = arr[i][0]
                break

    return job


if __name__ == "__main__":
    arr = [["J1", 1, 10], ["J2", 2, 15], ["J3", 2, 20], ["J4", 3, 5], ["J5", 3, 1]]

    print("Following is maximum profit sequence of jobs: ")

    print(jobsequencing(arr, 3))
