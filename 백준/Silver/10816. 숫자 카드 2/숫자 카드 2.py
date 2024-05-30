import sys

input = sys.stdin.readline

n = int(input())

ncard = list(map(int, input().split()))

ndic = {}
for i in ncard:
    if i in ndic:
        ndic[i] += 1
    else:
        ndic[i] = 1

m = int(input())

mcard = list(map(int, input().split()))

res = []
for i in mcard:
    if i in ndic.keys():
        res.append(ndic[i])
    else:
        res.append(0)

print(' '.join(map(str, res)))
