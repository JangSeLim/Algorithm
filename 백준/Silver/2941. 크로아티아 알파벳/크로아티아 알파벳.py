cro = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']

str = input()

for i in cro:
    str = str.replace(i, "*")
print(len(str))
