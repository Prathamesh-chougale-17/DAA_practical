def multiply(x, y):
    if x < 10:
        return x * y
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


z = multiply(15, 15)
print(z)
