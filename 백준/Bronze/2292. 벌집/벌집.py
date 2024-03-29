n = int(input())

i = 0; total = 1
t = True
while t:
    total += (6 * i)
    i += 1
    if total >= n:
        t = False

print(i)