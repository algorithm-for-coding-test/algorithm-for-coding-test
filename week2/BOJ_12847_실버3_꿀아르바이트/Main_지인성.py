n, m = map(int, input().split())
salaries = list(map(int, input().split()))
pSum = []

pSum.append(sum(salaries[0:m]))

for i in range(n-m):
	pSum.append(pSum[i] + salaries[m+i] - salaries[i])

print(max(pSum))