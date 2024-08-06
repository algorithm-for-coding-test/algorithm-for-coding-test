import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())
    t = list(map(int, input().split()))

    t.sort()
    M = -1

    if (N & 1) == 0:
        for i in range(N >> 1):
            M = max(M, t[i] + t[N - i - 1])
    else:
        M = t[-1]
        for i in range(N >> 1):
            M = max(M, t[i] + t[N - i - 2])

    print(M)


if __name__ == "__main__":
    main()
