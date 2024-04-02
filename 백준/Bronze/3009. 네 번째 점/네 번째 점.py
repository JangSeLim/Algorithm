x = []
y = []

for i in range(3):
    p = input().split()

    if p[0] in x:
        x.remove(p[0])
    else:
        x.append(p[0])

    if p[1] in y:
        y.remove(p[1])
    else:
        y.append(p[1])

print(*x, *y)
