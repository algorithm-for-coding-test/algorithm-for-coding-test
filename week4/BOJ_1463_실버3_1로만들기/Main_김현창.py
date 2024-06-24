import sys

input = lambda: sys.stdin.readline().rstrip()
INF = 987654321


def main():
    N = int(input())
    dp = [INF] * (N + 1)
    dp[1] = 0
    for i in range(N):
        if i * 3 <= N:
            dp[i * 3] = min(dp[i * 3], dp[i] + 1)
        if i * 2 <= N:
            dp[i * 2] = min(dp[i * 2], dp[i] + 1)
        if i + 1 <= N:
            dp[i + 1] = min(dp[i + 1], dp[i] + 1)

    print(dp[N])


if __name__ == "__main__":
    main()
