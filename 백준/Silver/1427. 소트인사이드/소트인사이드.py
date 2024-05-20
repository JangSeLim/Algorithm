n = list(input())

l = []
for i in n:
    l.append(int(i))

s_l = sorted(l, reverse=True)
print(''.join(map(str, s_l)))
