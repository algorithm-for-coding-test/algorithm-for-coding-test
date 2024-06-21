import sys
from itertools import combinations
from copy import deepcopy
from collections import deque

input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())

maps = []
emptys = []
viruses = []
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
answer = 0


def bfs(x, y, copy_maps):
	queue = deque([])
	queue.append((x, y))
	while queue:
		x, y = queue.popleft()
		for i in range(4):
			nx = x + dx[i]
			ny = y + dy[i]
			if nx < 0 or nx >= N or ny < 0 or ny >= M:
				continue
			
			if copy_maps[nx][ny] == 0:
				copy_maps[nx][ny] = 2
				queue.append((nx, ny))


for _ in range(N):
	lists = list(map(int, input().split()))
	maps.append(lists)

for i in range(N):
	for j in range(M):
		if maps[i][j] == 0:
			emptys.append((i, j))
		elif maps[i][j] == 2:
			viruses.append((i, j))

for barriers in combinations(emptys, 3):
	count = 0
	copy_maps = deepcopy(maps)
	for x, y in barriers:
		copy_maps[x][y] = 1
	for x, y in viruses:
		bfs(x, y, copy_maps)
	
	for i in range(N):
		for j in range(M):
			if copy_maps[i][j] == 0:
				count += 1
	answer = max(answer, count)

print(answer)