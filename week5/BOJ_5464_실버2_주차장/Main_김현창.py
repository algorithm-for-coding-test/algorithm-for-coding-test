import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()


def find_value(n, array, value):
    for i in range(n):
        if array[i] == value:
            return i
    return -1


def main():
    N, M = map(int, input().split())
    fee = [int(input()) for _ in range(N)]
    car = [int(input()) for _ in range(M)]
    car.insert(0, 0)
    space = [0] * N
    space_count = 0
    q = deque()
    answer = 0
    for _ in range(M << 1):
        i = int(input())
        if i > 0:
            if space_count < N:
                index = find_value(N, space, 0)
                space[index] = i
                space_count += 1
                answer += car[i] * fee[index]
            else:
                q.append(i)
        else:
            index = find_value(N, space, -i)
            space[index] = 0
            space_count -= 1
            if q:
                x = q.popleft()
                space[index] = x
                space_count += 1
                answer += car[x] * fee[index]

    print(answer)


if __name__ == "__main__":
    main()
