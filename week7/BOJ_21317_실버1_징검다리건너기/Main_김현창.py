import sys

input = lambda: sys.stdin.readline().rstrip()

INF = 987654321
N = -1
energy = None
big_energy = -1
cache = [[-1] * 2 for _ in range(22)]


def main():
    global N, energy, big_energy

    N = int(input())
    energy = [None for _ in range(N)]
    for i in range(1, N):
        energy[i] = tuple(map(int, input().split()))
    big_energy = int(input())

    print(solve(1, 1))


def solve(now, big_jump):
    if now > N:
        return INF
    if now == N:
        return 0
    if cache[now][big_jump] != -1:
        return cache[now][big_jump]

    res1 = solve(now + 1, big_jump) + energy[now][0]
    res2 = solve(now + 2, big_jump) + energy[now][1]
    res3 = solve(now + 3, big_jump - 1) + big_energy if big_jump > 0 else INF

    cache[now][big_jump] = min(res1, res2, res3)
    return cache[now][big_jump]


if __name__ == "__main__":
    main()
