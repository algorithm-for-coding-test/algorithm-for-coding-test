from collections import deque

N, M, V = map(int, input().split())
graph = [[] for i in range(N+1)]
visited = [False for _ in range(N+1)]

# 그래프 입력
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for g in graph:
    g.sort()

# dfs
def dfs(graph, start, visited):
    visited[start] = True
    print(start, end=" ")
    for v in graph[start]:
        if not visited[v]:
            dfs(graph, v, visited)


#bfs
def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        print(v, end=" ")
        for v in graph[v]:
            if not visited[v]:
                visited[v] = True
                queue.append(v)






dfs(graph,V,visited)
print()
# 방문 배열 초기화
visited = [False for _ in range(N+1)]
bfs(graph,V,visited)