import sys

n = int(sys.stdin.readline().strip())

com = set()

for _ in range(n):
    record = sys.stdin.readline().strip().split()
    name = record[0]
    action = record[1]

    if action == "enter":
        com.add(name)
    elif action == "leave":
        com.discard(name)

result = sorted(com, reverse=True)

for name in result:
    print(name)
