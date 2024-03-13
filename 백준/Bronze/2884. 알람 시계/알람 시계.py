a, b = map(int, input().split())

if a > 0 and b < 45:
    h = a-1
    m = b + 60 - 45
    print(f"{h} {m}")
elif a == 0 and b < 45:
    h = 23
    m = b + 60 - 45
    print(f"{h} {m}")
else:
    print(f"{a} {b-45}")