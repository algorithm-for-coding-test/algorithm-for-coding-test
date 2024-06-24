import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N, M = map(int, input().split())
    wgh = [0]
    val = [0]
    for _ in range(M):
        d, p = map(int, input().split())
        wgh.append(d)
        val.append(p)

    dp = [[0] * (N + 1) for _ in range(M + 1)]
    for i in range(1, M + 1):
        for j in range(N + 1):
            if j - wgh[i] >= 0:
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - wgh[i]] + val[i])
            else:
                dp[i][j] = dp[i - 1][j]

    print(dp[M][N])


if __name__ == "__main__":
    main()
