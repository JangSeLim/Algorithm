a, b = map(int, input().split())
c = int(input())

total = a * 60 + b + c
h = total // 60 % 24
m = total % 60

print(h, m)
