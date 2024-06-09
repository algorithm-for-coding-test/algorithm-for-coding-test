from collections import deque

n = int(input())
m = int(input())
result = 0
visited = [False] * (n+1)
computers = [[] for i in range(n+1)]

for _ in range(m):
    u, v = map(int, input().split())
    computers[u].append(v)
    computers[v].append(u)



def bfs(start):
    global visited
    global result
    queue = deque([start])
    visited[start] = True
    while queue:
        s = queue.popleft()
        for vertical in computers[s]:
            if not visited[vertical]:
                visited[vertical] = True
                queue.append(vertical)
                result += 1


bfs(1)
print(result)