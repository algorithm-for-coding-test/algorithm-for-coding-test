import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N, S, M = map(int, input().split())
    V = list(map(int, input().split()))
    dp = [set() for _ in range(N)]
    if S + V[0] <= M:
        dp[0].add(S + V[0])
    if S - V[0] >= 0:
        dp[0].add(S - V[0])

    for i in range(N - 1):
        for x in dp[i]:
            if x + V[i + 1] <= M:
                dp[i + 1].add(x + V[i + 1])
            if x - V[i + 1] >= 0:
                dp[i + 1].add(x - V[i + 1])

    print(max(dp[N - 1]) if len(dp[N - 1]) > 0 else -1)


if __name__ == "__main__":
    main()
