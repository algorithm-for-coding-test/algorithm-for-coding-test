import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N, M = map(int, input().split())
    nums = [list(map(int, input().split())) for _ in range(N)]
    accumulated = [[0] * (N + 1) for _ in range(N + 1)]

    for i in range(1, N + 1):
        for j in range(1, N + 1):
            accumulated[i][j] = accumulated[i][j - 1] + nums[i - 1][j - 1]

    for j in range(1, N + 1):
        for i in range(1, N + 1):
            accumulated[i][j] += accumulated[i - 1][j]

    for _ in range(M):
        x1, y1, x2, y2 = map(int, input().split())
        print(
            accumulated[x2][y2]
            - accumulated[x1 - 1][y2]
            - accumulated[x2][y1 - 1]
            + accumulated[x1 - 1][y1 - 1]
        )


if __name__ == "__main__":
    main()
