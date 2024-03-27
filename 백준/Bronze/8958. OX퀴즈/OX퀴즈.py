for _ in range(int(input())):
    a = list(input())

    sum = 0
    res = 0
    for i in a:
        if i == "O":
            sum += 1
            res += sum
        else:
            sum = 0

    print(res)
