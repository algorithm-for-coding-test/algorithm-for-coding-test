import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()


def main():
    F, S, G, U, D = map(int, input().split())
    q = deque([S])
    visited = [0] * (F + 1)
    visited[S] = 1
    while len(q) > 0:
        x = q.popleft()
        if x == G:
            break

        for y in [x - D, x + U]:
            if y <= 0 or y > F:
                continue
            if visited[y]:
                continue
            visited[y] = visited[x] + 1
            q.append(y)

    if visited[G] == 0:
        print("use the stairs")
    else:
        print(visited[G] - 1)


if __name__ == "__main__":
    main()
