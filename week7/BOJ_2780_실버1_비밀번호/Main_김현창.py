import sys

input = lambda: sys.stdin.readline().rstrip()

MOD = 1_234_567
ADJACENT_NUMS = [
    [7],
    [2, 4],
    [1, 3, 5],
    [2, 6],
    [1, 5, 7],
    [2, 4, 6, 8],
    [3, 5, 9],
    [4, 8, 0],
    [5, 7, 9],
    [6, 8],
]
cache = [[-1] * 1010 for _ in range(10)]


def main():
    T = int(input())
    for _ in range(T):
        N = int(input())
        print(solve(N))


def solve(N):
    res = 0
    for i in range(10):
        res = (res + dp(i, N)) % MOD
    return res


def dp(num, depth):
    if depth == 1:
        return 1
    if cache[num][depth] != -1:
        return cache[num][depth]

    temp = 0
    for next_num in ADJACENT_NUMS[num]:
        temp = (temp + dp(next_num, depth - 1)) % MOD
    cache[num][depth] = temp
    return cache[num][depth]


if __name__ == "__main__":
    main()


# another solution
def main2():
    MAX_N = 1000
    MOD = 1_234_567
    cache = [[0] * 10 for _ in range(MAX_N + 1)]
    for i in range(10):
        cache[1][i] = 1

    for i in range(2, MAX_N + 1):
        cache[i][0] = (cache[i - 1][7]) % MOD
        cache[i][1] = (cache[i - 1][2] + cache[i - 1][4]) % MOD
        cache[i][2] = (cache[i - 1][1] + cache[i - 1][3] + cache[i - 1][5]) % MOD
        cache[i][3] = (cache[i - 1][2] + cache[i - 1][6]) % MOD
        cache[i][4] = (cache[i - 1][1] + cache[i - 1][5] + cache[i - 1][7]) % MOD
        cache[i][5] = (
            cache[i - 1][2] + cache[i - 1][4] + cache[i - 1][6] + cache[i - 1][8]
        ) % MOD
        cache[i][6] = (cache[i - 1][3] + cache[i - 1][5] + cache[i - 1][9]) % MOD
        cache[i][7] = (cache[i - 1][4] + cache[i - 1][8] + cache[i - 1][0]) % MOD
        cache[i][8] = (cache[i - 1][5] + cache[i - 1][7] + cache[i - 1][9]) % MOD
        cache[i][9] = (cache[i - 1][6] + cache[i - 1][8]) % MOD

    for _ in range(int(input())):
        n = int(input())
        print(sum(cache[n]) % MOD)
