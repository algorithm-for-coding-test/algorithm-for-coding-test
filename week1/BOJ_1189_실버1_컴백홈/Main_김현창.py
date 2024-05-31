import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

R = -1
C = -1
graph = None
visited = None


def getNumberOfCase(k, x, y, curr=0):
    if x == 0 and y == C - 1:
        if curr == k - 1:
            return 1
        return 0

    visited[x][y] = True
    count = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or ny < 0 or nx >= R or ny >= C:
            continue
        if visited[nx][ny]:
            continue
        if graph[nx][ny] == "T":
            continue
        count += getNumberOfCase(k, nx, ny, curr + 1)
    visited[x][y] = False
    return count


def main():
    global R, C, graph, visited
    R, C, K = map(int, input().split())
    graph = [list(input()) for _ in range(R)]
    visited = [[False] * C for _ in range(R)]
    print(getNumberOfCase(K, R - 1, 0))


if __name__ == "__main__":
    main()
