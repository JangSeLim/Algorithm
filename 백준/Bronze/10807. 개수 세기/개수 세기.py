N = int(input())
num = list(map(int, input().split()))
anw = int(input())
cnt = 0

for i in num:
    if anw == i:
        cnt += 1
print(cnt)
