import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()


def main():
    n, w, L = map(int, input().split())
    a = list(map(int, input().split()))
    bridge = deque([0] * w)
    weight = 0
    answer = 0
    for i in range(n):
        while True:
            weight -= bridge.popleft()
            bridge.append(0)
            answer += 1
            if weight + a[i] <= L:
                break

        bridge[-1] = a[i]
        weight += a[i]

    while weight > 0:
        weight -= bridge.popleft()
        answer += 1

    print(answer)


if __name__ == "__main__":
    main()
