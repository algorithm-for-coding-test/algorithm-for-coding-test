import sys

input = lambda: sys.stdin.readline().rstrip()


def test(beer, n, k):
    res = 0
    count = 0
    for v, c in beer:
        if c <= k:
            res += v
            count += 1
            if count == n:
                return res
    return -1


def main():
    N, M, K = map(int, input().split())
    beer = [tuple(map(int, input().split())) for _ in range(K)]
    beer.sort(key=lambda x: -x[0])

    left = 0
    right = 2_222_222_222
    answer = -1
    while left <= right:
        mid = (left + right) >> 1
        res = test(beer, N, mid)
        if res >= M:
            right = mid - 1
            answer = mid
        else:
            left = mid + 1
    print(answer)


if __name__ == "__main__":
    main()
