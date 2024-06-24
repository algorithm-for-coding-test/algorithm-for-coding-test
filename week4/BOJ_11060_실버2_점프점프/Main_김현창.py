import sys

input = lambda: sys.stdin.readline().rstrip()
INF = 987654321


def main():
    N = int(input())
    A = list(map(int, input().split()))
    dp = [INF] * N
    dp[0] = 0
    for now in range(N - 1):
        for next in range(now + 1, now + A[now] + 1):
            if next >= N:
                break
            dp[next] = min(dp[next], dp[now] + 1)

    print(-1 if dp[N - 1] == INF else dp[N - 1])


if __name__ == "__main__":
    main()
