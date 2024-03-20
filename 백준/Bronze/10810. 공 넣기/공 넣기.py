n, m = map(int, input().split())
b = [0] * n

for _ in range(m):
    i, j, k = map(int, input().split())
    for x in range(i, j+1):
        b[x-1] = k

for y in range(n):
    print(b[y], end=" ")
