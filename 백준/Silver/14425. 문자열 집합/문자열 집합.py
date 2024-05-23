import sys
input = sys.stdin.readline

a, b = map(int, input().split())

s = []
for _ in range(a+b):
    s.append(input().rstrip())

s1 = s[:a]
s2 = s[a:]

cnt = 0
for i in s2:
    if i in set(s1):
        cnt += 1

print(cnt)