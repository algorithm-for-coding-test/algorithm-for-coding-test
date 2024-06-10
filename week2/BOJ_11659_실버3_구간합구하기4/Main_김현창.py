import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N, M = map(int, input().split())
    nums = list(map(int, input().split()))
    accumulated = [0]
    for i in range(N):
        accumulated.append(accumulated[-1] + nums[i])

    for _ in range(M):
        i, j = map(int, input().split())
        print(accumulated[j] - accumulated[i - 1])


if __name__ == "__main__":
    main()
