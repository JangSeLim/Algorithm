word = [input() for _ in range(5)]

for j in range(15): #j는 열, i는 행
    for i in range(5):
        if j < len(word[i]):
            print(word[i][j], end="")
