import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n, m = map(int, input().split())
    T = list(map(int, input().split()))
    accumulated = [0]
    for i in range(n):
        accumulated.append(accumulated[-1] + T[i])

    answer = 0
    for i in range(m, n + 1):
        answer = max(answer, accumulated[i] - accumulated[i - m])
    print(answer)


if __name__ == "__main__":
    main()
