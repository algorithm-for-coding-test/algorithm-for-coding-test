import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

R = -1
C = -1
graph = None


def bfs(x, y, visited):
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    sheep = 0
    wolf = 0
    while len(q) > 0:
        x, y = q.popleft()
        if graph[x][y] == "v":
            wolf += 1
        elif graph[x][y] == "o":
            sheep += 1

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= R or ny >= C:
                continue
            if graph[nx][ny] == "#":
                continue
            if visited[nx][ny]:
                continue

            q.append((nx, ny))
            visited[nx][ny] = True

    return (0, wolf) if wolf >= sheep else (sheep, 0)


def main():
    global R, C, graph
    R, C = map(int, input().split())
    graph = [list(input()) for _ in range(R)]
    visited = [[False] * C for _ in range(R)]
    sheep = 0
    wolf = 0

    for i in range(R):
        for j in range(C):
            if graph[i][j] == "#":
                continue
            if visited[i][j]:
                continue
            _sheep, _wolf = bfs(i, j, visited)
            sheep += _sheep
            wolf += _wolf

    print(sheep, wolf)


if __name__ == "__main__":
    main()
