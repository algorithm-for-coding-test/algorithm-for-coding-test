import sys
import heapq

input = lambda: sys.stdin.readline().rstrip()


def main():
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    heapq.heapify(a)

    while m > 0:
        x = heapq.heappop(a)
        y = heapq.heappop(a)
        heapq.heappush(a, x + y)
        heapq.heappush(a, x + y)
        m -= 1

    print(sum(a))


if __name__ == "__main__":
    main()
