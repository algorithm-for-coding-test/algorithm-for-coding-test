import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def main():
    N, M = map(int, input().split())
    graph = [list(map(int, list(input()))) for _ in range(N)]

    q = deque()
    q.append((0, 0))
    visited = [[0] * M for _ in range(N)]
    visited[0][0] = 1
    while len(q) > 0:
        x, y = q.popleft()
        if x == N - 1 and y == M - 1:
            break

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue
            if visited[nx][ny] > 0:
                continue
            if graph[nx][ny] == 0:
                continue
            q.append((nx, ny))
            visited[nx][ny] = visited[x][y] + 1
    print(visited[N - 1][M - 1])


if __name__ == "__main__":
    main()
