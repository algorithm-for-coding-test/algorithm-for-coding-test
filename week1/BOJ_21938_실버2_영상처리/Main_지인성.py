from collections import deque
N, M = map(int, input().split())

graph = []
visited = [[False] * M for _ in range(N)]
answer = -1

dx = [1,0,-1,0]
dy = [0,1,0,-1]

for _ in range(N):
	lists = list(map(int, input().split()))
	temp = []
	for j in range(M):
		temp.append(int(sum(lists[j*3:j*3+3])/3))
	graph.append(temp)
T = int(input())

def bfs(i,j):
	visited[i][j] = True
	queue = deque([(i,j)])
	global answer
	answer += 1

	while queue:
		x, y = queue.popleft()
		visited[x][y] = True
		for k in range(4):
			nx = x+dx[k]
			ny = y+dy[k]

			if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] >= T and not visited[nx][ny]:
				visited[nx][ny] = True
				queue.append((nx,ny))


for i in range(N):
	for j in range(M):
		if not visited[i][j] and graph[i][j] >= T:
			bfs(i,j)


print(answer)