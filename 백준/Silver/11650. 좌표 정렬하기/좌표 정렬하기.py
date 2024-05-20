n = int(input())

l = []
for _ in range(n):
    l.append(list(map(int, input().split())))

s_l = sorted(l)

for i in s_l:
    print(i[0], i[1])