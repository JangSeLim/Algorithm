
while True:
    i = 1
    s = 0
    l = []
    n = int(input())

    if n == -1:
        break

    while i < n:
        if n % i == 0:
            l.append(i)
            s += i
        i += 1

    if s == n:
        print(n, "=", " + ".join(map(str, l)))
    else:
        print(n, "is NOT perfect.")

