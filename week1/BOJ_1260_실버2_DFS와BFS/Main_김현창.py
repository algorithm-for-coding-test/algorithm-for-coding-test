import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()

N = -1
M = -1
graph = None

def dfs(x):
    def _dfs(x, visited, result):
        visited[x] = True
        result.append(x)
        for y in graph[x]:
            if visited[y]:
                continue
            _dfs(y, visited, result)
        return result
        
    return _dfs(x, [False] * (N + 1), [])
    
def bfs(x):
    q = deque()
    visited = [False] * (N + 1)
    q.append(x)
    visited[x] = True
    result = []
    while (len(q) > 0):
        x = q.popleft()
        result.append(x)
        
        for y in graph[x]:
            if visited[y]:
                continue
            q.append(y)
            visited[y] = True
    return result    

def main():
    global N, M, graph
    N, M, V = map(int, input().split())
    graph = [[] for _ in range(N + 1)]
    for _ in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    
    for i in range(N + 1):
        graph[i].sort()
        
    print(" ".join(map(str, dfs(V))))
    print(" ".join(map(str, bfs(V))))

if __name__ == "__main__":
    main()