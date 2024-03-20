n, m = map(int, input().split())
b = [a for a in range(1, n+1)]

for _ in range(m):
    i, j = map(int, input().split())
    i -= 1
    j -= 1

    b[i], b[j] = b[j], b[i]

for y in b:
    print(y, end=" ")
