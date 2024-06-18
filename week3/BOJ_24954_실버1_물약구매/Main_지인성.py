import sys
from copy import deepcopy
from itertools import permutations

input = lambda : sys.stdin.readline().rstrip()
answer = float('INF')
N = int(input())
prices = list(map(int, input().split()))
lists = []
for _ in range(N):
	i = int(input())
	info = []
	for _ in range(i):
		info.append(tuple(map(int, input().split())))
	lists.append(info)

trials = list(range(N))

for trial in permutations(trials):
	copy_prices = deepcopy(prices)
	coin = 0
	for t in trial:
		coin += copy_prices[t]
		for i, j in lists[t]:
			copy_prices[i-1] -= j
			if copy_prices[i-1] < 1:
				copy_prices[i-1] = 1
	answer = min(coin, answer)
print(answer)
	
