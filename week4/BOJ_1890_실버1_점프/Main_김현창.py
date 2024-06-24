import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())
    graph = [list(map(int, input().split())) for _ in range(N)]
    dp = [[0] * N for _ in range(N)]
    dp[0][0] = 1
    for i in range(N):
        for j in range(N):
            if graph[i][j] == 0:
                continue
            if i + graph[i][j] < N:
                dp[i + graph[i][j]][j] += dp[i][j]
            if j + graph[i][j] < N:
                dp[i][j + graph[i][j]] += dp[i][j]

    print(dp[N - 1][N - 1])


if __name__ == "__main__":
    main()
