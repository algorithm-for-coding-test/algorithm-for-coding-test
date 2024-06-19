from itertools import permutations
import sys
input = lambda: sys.stdin.readline().rstrip()
answer = 0

N, K = map(int, input().split())
kits = list(map(int, input().split()))
lists = list(range(N))

permus = list(permutations(lists, N))

for permu in permus:
	power = 500
	for k in permu:
		power = power - K + kits[k]
		if power < 500:
			break
	if power >= 500:
		answer += 1
	
print(answer)