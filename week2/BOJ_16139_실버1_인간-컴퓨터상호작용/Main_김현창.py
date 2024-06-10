import sys

input = lambda: sys.stdin.readline().rstrip()

ORD_LOWERCASE_A = ord("a")


def main():
    S = input()

    sLength = len(S)
    cache = [[0] * 26]

    for i in range(sLength):
        step = cache[-1].copy()
        step[ord(S[i]) - ORD_LOWERCASE_A] += 1
        cache.append(step)

    q = int(input())
    for _ in range(q):
        a, l, r = input().split()
        l = int(l)
        r = int(r)
        print(
            cache[r + 1][ord(a) - ORD_LOWERCASE_A] - cache[l][ord(a) - ORD_LOWERCASE_A]
        )


if __name__ == "__main__":
    main()
