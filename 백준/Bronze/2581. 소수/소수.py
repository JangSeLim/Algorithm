m = int(input())
n = int(input())

l = []
for x in range(m, n+1):
    e = 0

    if x > 1:
        for i in range(2, x):
            if x % i == 0:
                e += 1
                break
        if e == 0:
            l.append(x)

if len(l) > 0:
    print(sum(l))
    print(min(l))
else:
    print(-1)

