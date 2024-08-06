import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    T = int(input())

    for _ in range(T):
        N = int(input())
        ls = []
        for _ in range(N):
            ls.append(tuple(map(int, input().split())))

        ls.sort(key=lambda x: -x[0])
        checker = [True] * N

        v = 987654321
        for i in range(N - 1, -1, -1):
            if ls[i][1] > v:
                checker[i] = False
            v = min(v, ls[i][1])

        print(sum(checker))


if __name__ == "__main__":
    main()
