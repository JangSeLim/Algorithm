n, b = input().split()
n = n[::-1]
alpha = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'

res = 0
for i in range(len(n)):
    num = alpha.index(n[i])
    res += num*(int(b)**i)

print(res)
