from collections import deque

n = int(input())

# 비용 정보
graph = [[] for _ in range(n + 1)]

visited = [False for _ in range(n+1)]

dist = [0] * (n+1)

for _ in range(n-1):
    u, v, c = map(int, input().split())
    graph[u].append([v, c])
    graph[v].append([u, c])



# start부터 goal 까지의 거리 중 가장 높은 answer가 답
def bfs(start):
    queue = deque([start])
    visited[start] = True

    while queue:
        # 큐에서 정점을 꺼냄
        qv = queue.popleft()
        # 해당 정점과 인접한 모든 정점을 방문처리하며 비용 계산
        for iv, cost in graph[qv]:
            if not visited[iv]:
                visited[iv] = True
                queue.append(iv)
                dist[iv] = max(dist[iv], dist[qv] + cost)

bfs(1)

print(max(dist))