import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    R, C, W = map(int, input().split())
    dp = [[0] * (31) for _ in range(31)]
    for i in range(31):
        dp[i][0] = 1
        dp[i][i] = 1
    for i in range(2, 31):
        for j in range(1, 30):
            dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]

    answer = 0
    for i in range(W):
        answer += sum(dp[R + i - 1][C - 1 : C + i])
    print(answer)


if __name__ == "__main__":
    main()
