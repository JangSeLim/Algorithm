n = int(input())

s = 0
for x in list(map(int,input().split())):
    i = 1
    l = []

    while i <= x:
        if x % i == 0:
            l.append(i)
        i += 1
    if len(l) == 2:
        s += 1

print(s)

