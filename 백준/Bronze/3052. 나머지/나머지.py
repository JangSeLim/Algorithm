l = []
for _ in range(10):
    num = int(input())
    l.append(num % 42)

print(len(set(l)))