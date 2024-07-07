import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())
    A = reversed(list(map(int, input().split())))
    cards = [i for i in range(N, 0, -1)]
    result = deque()
    for x in A:
        if x == 1:
            result.appendleft(cards.pop())
        elif x == 2:
            temp = result.popleft()
            result.appendleft(cards.pop())
            result.appendleft(temp)
        elif x == 3:
            result.append(cards.pop())

    print(" ".join(map(str, result)))


if __name__ == "__main__":
    main()
