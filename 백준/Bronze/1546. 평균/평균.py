n = int(input())
scores = list(map(int, input().split()))
max_score = max(scores)

new = []
for i in scores:
    new.append(i / max_score * 100)

print(sum(new) / n)