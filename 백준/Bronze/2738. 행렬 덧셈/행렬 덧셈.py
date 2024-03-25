n, m = map(int, input().split())

a = []
for i in range(n):
    a.append(list(map(int, input().split())))

b = []
for i in range(n):
    b.append(list(map(int, input().split())))

for i in range(n):
    for j in range(m):
        res = a[i][j] + b[i][j]
        print(res, end=" ")
    print()
