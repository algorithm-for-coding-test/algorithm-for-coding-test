import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N, M = map(int, input().split())
    a = list(map(int, input().split()))
    a.sort()

    answer = 0
    right = N - 1
    for left in range(N):
        if left >= right:
            break
        if a[left] + a[right] >= M:
            right -= 1
            answer += 1

    print(answer)


if __name__ == "__main__":
    main()
