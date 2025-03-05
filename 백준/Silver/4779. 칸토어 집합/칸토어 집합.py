import sys
input = sys.stdin.readline

K = ["-"]
for _ in range(12):
    K.append(K[-1] + " " * len(K[-1]) + K[-1])

while True:
    try:
        print(K[int(input())])
    except:
        break

