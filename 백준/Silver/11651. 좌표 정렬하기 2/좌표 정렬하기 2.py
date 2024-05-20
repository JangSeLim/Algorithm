n = int(input())

l = []
for _ in range(n):
    l.append(list(map(int, input().split())))

s_l = sorted(l, key=lambda x: (x[1], x[0]))

for i in s_l:
    print(i[0], i[1])