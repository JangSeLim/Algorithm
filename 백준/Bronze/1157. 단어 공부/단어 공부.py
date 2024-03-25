a = input().lower()
a_set = list(set(a))
cnt = []

for i in a_set:
    x = a.count(i)
    cnt.append(x)

if cnt.count(max(cnt)) >= 2:
    print("?")
else:
    print(a_set[cnt.index(max(cnt))].upper())
