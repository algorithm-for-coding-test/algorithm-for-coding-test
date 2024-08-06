import sys

input = lambda: sys.stdin.readline().rstrip()

vip = [False] * 41
dp = [-1] * 41
N = -1


def main():
    global N
    N = int(input())
    M = int(input())
    for _ in range(M):
        vip[int(input())] = True

    print(solve(1))


def solve(x):
    if x > N:
        return 1
    if dp[x] != -1:
        return dp[x]
    if vip[x]:
        dp[x] = solve(x + 1)
        return dp[x]

    dp[x] = 0
    if x < N and not vip[x + 1]:
        dp[x] += solve(x + 2)
    dp[x] += solve(x + 1)
    return dp[x]


if __name__ == "__main__":
    main()
