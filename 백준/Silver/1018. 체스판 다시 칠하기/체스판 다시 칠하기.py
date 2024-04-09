n, m = map(int, input().split())

board = []
res = []

for i in range(n):
    board.append(input())

for i in range(n-7):
    for j in range(m-7):
        wstart = 0
        bstart = 0

        for a in range(i, i+8):
            for b in range(j, j+8):

                if (a+b)%2==0:
                    if board[a][b] != 'B':
                        wstart += 1
                    if board[a][b] != 'W':
                        bstart += 1

                else:
                    if board[a][b] != 'W':
                        wstart += 1
                    if board[a][b] != 'B':
                        bstart += 1

        res.append(wstart)
        res.append(bstart)

print(min(res))
