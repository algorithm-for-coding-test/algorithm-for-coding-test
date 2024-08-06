import sys

input = lambda: sys.stdin.readline().rstrip()
dp = [[0] * 31 for _ in range(31)]


def main():
    n, k = map(int, input().split())
    print(solve(n - 1, k - 1))


def solve(n, k):
    if n == 0 or k == 0 or n == k:
        return 1
    if dp[n][k] != 0:
        return dp[n][k]

    dp[n][k] = solve(n - 1, k - 1) + solve(n - 1, k)
    return dp[n][k]


if __name__ == "__main__":
    main()
