from collections import deque
N, K = map(int, input().split())
Max = max(N,K)
visited = [False] * (Max*2+1)
count = [0] * (Max*2+1)

def bfs(start):
	if start == K:
		return
	queue = deque([start])
	visited[start] = True

	while queue:
		i = queue.popleft()
		if 0 <= (i - 1) <= Max*2 and not visited[i - 1]:
			visited[i - 1] = True
			queue.append(i - 1)
			count[i-1] = count[i] + 1

		if 0 <= (i + 1) <= Max*2 and not visited[i + 1]:
			visited[i + 1] = True
			queue.append(i + 1)
			count[i+1] = count[i] + 1

		if 0 <= (i * 2) <= Max*2 and not visited[i * 2]:
			visited[i * 2] = True
			queue.append(i * 2)
			count[i*2] = count[i] + 1

bfs(N)
print(count[K])