total = int(input())
num = int(input())

sum = 0

for i in range(num):
    price, cnt = map(int, input().split())
    sum += (price * cnt)

if total == sum:
    print("Yes")
else:
    print("No")