import sys

input = lambda: sys.stdin.readline().rstrip()
INF = 987654321


def main():
    n = int(input())
    dp = [INF] * (100001)
    dp[2] = 1
    dp[4] = 2
    dp[5] = 1
    if n > 5:
        for i in range(6, n + 1):
            dp[i] = min(dp[i - 2] + 1, dp[i - 5] + 1)
    print(-1 if dp[n] == INF else dp[n])


if __name__ == "__main__":
    main()
