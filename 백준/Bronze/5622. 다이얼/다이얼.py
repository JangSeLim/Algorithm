alpha = input()

dial = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']

sec = 0
for i in alpha:
    for j, d in enumerate(dial):
        if i in d:
            sec += (j+3)

print(sec)