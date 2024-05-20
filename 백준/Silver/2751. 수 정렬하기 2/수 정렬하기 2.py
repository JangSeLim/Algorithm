n = int(input())

l = []
for _ in range(n):
    i = int(input())
    l.append(i)

s_l = sorted(l)

for num in s_l:
    print(num)
