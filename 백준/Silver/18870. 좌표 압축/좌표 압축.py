import bisect

n = int(input())

l = list(map(int, input().split()))

l2 = sorted(set(l))

res = []
for i in l:
    res.append(bisect.bisect_left(l2, i))

print(*res)
