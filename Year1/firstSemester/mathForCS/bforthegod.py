k = 1
n = 2 * k + 1
p = [0] * n
samplespace = n**n
event = 0

for i in range(n**n):
    p_copy = p.copy()
    p_copy.sort()
    p[0] += 1
    for j in range(n - 1):
        if p[j] == n:
            p[j] = 0
            p[j + 1] += 1
    if p_copy[k] == k:
        event += 1

prob = event / samplespace
print(f"n(E): {event}, P(E): {prob}")