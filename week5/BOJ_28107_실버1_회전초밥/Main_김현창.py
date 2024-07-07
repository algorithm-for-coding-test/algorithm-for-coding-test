import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()


def main():
    N, M = map(int, input().split())
    sushi = [deque() for _ in range(200020)]
    for i in range(N):
        k, *A = list(map(int, input().split()))
        for x in A:
            sushi[x].append(i)

    result = [0] * N
    B = list(map(int, input().split()))
    for x in B:
        if not sushi[x]:
            continue
        result[sushi[x].popleft()] += 1

    print(" ".join(map(str, result)))


if __name__ == "__main__":
    main()
