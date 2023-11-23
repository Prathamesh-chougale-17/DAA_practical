def multiply(x, y):
    if x < 10:
        return x * y
    else:
        n = len(str(x)) // 2
        p = 10**n
        k = 100**n
        a = x // p
        b = x % p
        c = y // p
        d = y % p
        ac = multiply(a, c)
        bd = multiply(b, d)
        plus = multiply(a + b, c + d) - (ac + bd)
        return ac * k + plus * p + bd


x = input("Enter the Number: ")
res = multiply(int(x), int(x))
print(res)
