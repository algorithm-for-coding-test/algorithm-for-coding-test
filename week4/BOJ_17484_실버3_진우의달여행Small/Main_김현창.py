import sys

input = lambda: sys.stdin.readline().rstrip()
INF = 987654321
N = -1
M = -1
graph = None
dp = None
dy = [-1, 0, 1]
answer = INF


def dfs(x, y, dir):
    global answer

    if x == N:
        return 0
    if x > 0 and dp[x][y][dir] != INF:
        return dp[x][y][dir]

    temp = INF
    for i in range(3):
        if i == dir:
            continue
        nx = x + 1
        ny = y + dy[i]
        if ny < 0 or ny >= M:
            continue
        temp = min(temp, dfs(nx, ny, i) + graph[nx][ny])

    if x == 0:
        return temp

    dp[x][y][dir] = temp
    return dp[x][y][dir]


def main():
    global N, M, graph, dp
    N, M = map(int, input().split())
    graph = [list(map(int, input().split())) for _ in range(N)]
    graph.insert(0, None)
    dp = [[[INF] * 3 for _ in range(M)] for _ in range(N + 1)]
    answer = INF
    for j in range(M):
        answer = min(answer, dfs(0, j, -1))
    print(answer)


if __name__ == "__main__":
    main()
