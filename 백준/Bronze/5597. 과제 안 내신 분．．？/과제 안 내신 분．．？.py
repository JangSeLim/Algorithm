stu = [i for i in range(1, 31)]

for _ in range(28):
    n = int(input())
    stu.remove(n)

print(min(stu))
print(max(stu))