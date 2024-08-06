import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().rstrip()
N = -1
D = -1
fast = defaultdict(list)
cache = [-1] * 10010


def main():
    global N, D
    N, D = map(int, input().split())

    for _ in range(N):
        src, dest, length = map(int, input().split())
        fast[src].append((dest, length))

    print(solve(0))


def solve(now):
    if now > D:
        return 9876543210
    if now == D:
        return 0
    if cache[now] != -1:
        return cache[now]

    temp = solve(now + 1) + 1
    for next, length in fast[now]:
        temp = min(temp, solve(next) + length)

    cache[now] = temp
    return cache[now]


if __name__ == "__main__":
    main()
