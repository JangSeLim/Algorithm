l = []
for i in range(3):
    l.append(int(input()))

if l[0]==60 and l[1]==60 and l[2]==60:
    print("Equilateral")
elif sum(l)==180 and len(set(l))==2:
    print("Isosceles")
elif sum(l)==180 and len(set(l))==3:
    print("Scalene")
elif sum(l) != 180:
    print("Error")