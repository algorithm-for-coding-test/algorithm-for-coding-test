import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def average(*nums):
    count = len(nums)
    return sum(nums) / count


def bfs(graph, x, y, h, w, visited):
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    while len(q) > 0:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= h or ny >= w:
                continue
            if visited[nx][ny]:
                continue
            if graph[nx][ny] == 0:
                continue
            q.append((nx, ny))
            visited[nx][ny] = True


def countObject(graph, h, w):
    visited = [[False] * w for _ in range(h)]
    count = 0
    for i in range(h):
        for j in range(w):
            if visited[i][j]:
                continue
            if graph[i][j] == 0:
                continue
            bfs(graph, i, j, h, w, visited)
            count += 1
    return count


def main():
    N, M = map(int, input().split())
    R = [[] for _ in range(N)]
    G = [[] for _ in range(N)]
    B = [[] for _ in range(N)]
    for i in range(N):
        inputList = list(map(int, input().split()))
        for j in range(0, M * 3, 3):
            R[i].append(inputList[j])
            G[i].append(inputList[j + 1])
            B[i].append(inputList[j + 2])

    T = int(input())
    graph = [[0] * M for _ in range(N)]
    for i in range(N):
        for j in range(M):
            graph[i][j] = 1 if average(R[i][j], G[i][j], B[i][j]) >= T else 0

    print(countObject(graph, N, M))


if __name__ == "__main__":
    main()
