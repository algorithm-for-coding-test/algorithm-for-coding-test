import sys
from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
input = lambda: sys.stdin.readline().rstrip()


def bfs(graph, x, y, n, visited):
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    count = 0
    while len(q) > 0:
        x, y = q.popleft()
        count += 1
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            if visited[nx][ny]:
                continue
            if graph[nx][ny] == 0:
                continue
            q.append((nx, ny))
            visited[nx][ny] = True
    return count


def getGroups(graph, n):
    visited = [[False] * n for _ in range(n)]
    groups = []
    for i in range(n):
        for j in range(n):
            if visited[i][j]:
                continue
            if graph[i][j] == 0:
                continue
            groups.append(bfs(graph, i, j, n, visited))
    return groups


def main():
    N = int(input())
    graph = [list(map(int, list(input()))) for _ in range(N)]
    result = getGroups(graph, N)
    result.sort()
    print(len(result))
    for x in result:
        print(x)


if __name__ == "__main__":
    main()
