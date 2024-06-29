import sys
sys.setrecursionlimit(10**5)
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
maps = [list(map(int, input().split())) for _ in range(n)]
DP = [[-1] * n for _ in range(n)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def dfs(x, y):
    if DP[x][y] != -1:
        return DP[x][y]

    DP[x][y] = 1  # 자기 자신만 있을 경우 최소 길이는 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n and maps[nx][ny] > maps[x][y]:
            DP[x][y] = max(DP[x][y], dfs(nx, ny) + 1)

    return DP[x][y]

answer = 0
for i in range(n):
    for j in range(n):
        answer = max(answer, dfs(i, j))

print(answer)