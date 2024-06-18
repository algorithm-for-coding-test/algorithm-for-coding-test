import sys

input = lambda: sys.stdin.readline().rstrip()
N = int(input())
lists = list(map(int, input().split()))
M = int(input())

i = 0
j = max(lists)

while i <= j:
	mid = (i + j) // 2
	budget = 0
	for salary in lists:
		if salary <= mid:
			budget += salary
		else:
			budget += mid
	
	if budget <= M:
		i = mid + 1
	else:
		j = mid - 1
print(j)