total = 0
cnt = 0

for i in range(20):
    subject, score, grade = input().split()

    if grade == "A+":
        grade_point = 4.5
    elif grade == "A0":
        grade_point = 4.0
    elif grade == "B+":
        grade_point = 3.5
    elif grade == "B0":
        grade_point = 3.0
    elif grade == "C+":
        grade_point = 2.5
    elif grade == "C0":
        grade_point = 2.0
    elif grade == "D+":
        grade_point = 1.5
    elif grade == "D0":
        grade_point = 1.0
    elif grade == "F":
        grade_point = 0.0

    if grade != "P":
        total += float(score) * grade_point
        cnt += float(score)

print(total / cnt)

