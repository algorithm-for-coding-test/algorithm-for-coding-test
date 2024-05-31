import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()


def main():
    N, K = map(int, input().split())

    visited = [0] * 200010
    q = deque([N])
    visited[N] = 1
    while len(q) > 0:
        x = q.popleft()
        if x == K:
            break

        for next in [x - 1, x + 1, x << 1]:
            if next < 0 or next >= 200000:
                continue
            if visited[next] > 0:
                continue
            visited[next] = visited[x] + 1
            q.append(next)

    print(visited[K] - 1)


if __name__ == "__main__":
    main()
