import sys

input = lambda: sys.stdin.readline().rstrip()


def lower_bound(arr, k):
    left = 0
    right = len(arr) - 1
    while left <= right:
        mid = (left + right) >> 1
        if arr[mid] >= k:
            right = mid - 1
        else:
            left = mid + 1
    return right + 1


def main():
    N = int(input())
    power = list(map(int, input().split()))
    power.reverse()
    q = []
    for x in power:
        if not q or q[-1] < x:
            q.append(x)
        else:
            index = lower_bound(q, x)
            q[index] = x

    print(N - len(q))


if __name__ == "__main__":
    main()
