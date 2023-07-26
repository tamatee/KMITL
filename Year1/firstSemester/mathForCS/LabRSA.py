n = 253031
e = 33311


def gcdExtended(a, b):
    if a == 0:
        return b, 0, 1
    gcd, x1, y1 = gcdExtended(b % a, a)
    x = y1 - (b // a) * x1
    y = x1

    return gcd, x, y


def factors(n):
    factors_num = []
    for i in range(2, n):
        if n % i == 0:
            factors_num.append(i)
    return factors_num


cypher = [192718, 44207, 92345, 198194, 209885, 145673, 158195, 162891, 209885, 197432, 251143, 174163, 92345, 209885,
          162891, 154788, 179792, 209885, 120588, 44207, 98836, 120588, 132369, 114740, 209885, 105496, 44207, 92345,
          198194, 209885, 120588, 44207, 92345, 209885, 197432, 98836, 157424, 92345, 209885, 92345, 198194, 43326,
          114740, 205085]

p, q = factors(n)
phi = (p - 1) * (q - 1)
d = gcdExtended(e, phi)[1]

d = d % phi
if d < 0:
    d += phi

for i in cypher:
    text = (i ** d) % n
    print(chr(text), end="")
