n = int(input())

l = []
for _ in range(n):
    a, b = input().split()
    l.append((int(a), b))

s_l = sorted(l, key=lambda x: x[0])

for a, b in s_l:
    print(a, b)
