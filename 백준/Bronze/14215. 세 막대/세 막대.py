a, b, c = map(int, input().split())

m = max(a, b, c)

if (a+b+c-m) > m:
    print(a+b+c)
else:
    print(2*(a+b+c) -2*m -1)