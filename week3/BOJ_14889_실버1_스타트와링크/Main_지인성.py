from itertools import combinations

import sys

input = lambda: sys.stdin.readline().rstrip()

N = int(input())
powers = []

for _ in range(N):
	powers.append(list(map(int, input().split())))

lists = list(range(N))
answer = float('INF')

# 반반 쪼개기
members = list(combinations(lists, N // 2))

for start_team in members:
	start = 0
	link = 0
	link_team = [member for member in lists if member not in start_team]
	
	for i, j in list(combinations(start_team, 2)):
		start += powers[i][j] + powers[j][i]
	
	for i, j in list(combinations(link_team, 2)):
		link += powers[i][j] + powers[j][i]
	
	answer = min(answer, abs(start - link))

print(answer)