n = int(input())

if n % 5 == 0:
    print(n // 5)
else:
    v = 0
    while n > 0:
        n -= 3
        v += 1
        if n % 5 == 0:
            v += n // 5
            print(v)
            break
        elif n == 1 or n == 2:
            print(-1)
            break
        elif n == 0:
            print(v)
            break