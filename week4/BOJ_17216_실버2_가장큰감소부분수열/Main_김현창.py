import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())
    A = list(map(int, input().split()))
    dp = A.copy()
    for i in range(N):
        for j in range(i - 1, -1, -1):
            if A[i] >= A[j]:
                continue
            dp[i] = max(dp[i], dp[j] + A[i])

    print(max(dp[N - 1]))


if __name__ == "__main__":
    main()
