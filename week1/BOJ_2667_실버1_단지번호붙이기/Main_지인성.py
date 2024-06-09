from collections import deque
n = int(input())
apartments = []
answer = []
for _ in range(n):
	apartments.append(list(map(int, input())))

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]


def bfs(x, y):
	queue = deque()
	queue.append((x, y))
	apartments[x][y] = 0
	count = 1

	while queue:
		x, y = queue.popleft()
		for i in range(4):
			nx = x + dx[i]
			ny = y + dy[i]
			if nx < 0 or nx >= n:
				continue
			if ny < 0 or ny >= n:
				continue
			if apartments[nx][ny] == 0:
				continue
			count += 1
			apartments[nx][ny] = 0
			queue.append((nx, ny))
	answer.append(count)


for i in range(n):
	for j in range(n):
		if apartments[i][j] == 1:
			bfs(i, j)


answer.sort()

print(len(answer))
for cnt in answer:
	print(cnt)