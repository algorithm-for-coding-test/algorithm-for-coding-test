import sys
input = lambda: sys.stdin.readline().rstrip()
N,M = map(int, input().split())
numbers = list(map(int, input().split()))
trials = []
pSum = [0]

pSum.append(numbers[0])

for _ in range(M):
	lists = list(map(int, input().split()))
	trials.append(lists)

for i in range(N-1):
	pSum.append(pSum[i+1] + numbers[i+1])


for i,j in trials:
	print(pSum[j] - pSum[i-1])