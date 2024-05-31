import sys

sys.setrecursionlimit(10000)

input = lambda: sys.stdin.readline().rstrip()

N = -1
graph = None
visited = None


def getFarthest(x):
    visited[x] = True
    distance = 0
    for y, dist in graph[x]:
        if visited[y]:
            continue
        distance = max(distance, dist + getFarthest(y))

    return distance


def main():
    global N, graph, visited
    N = int(input())
    graph = [[] for _ in range(N + 1)]
    visited = [False] * (N + 1)
    for _ in range(N - 1):
        A, B, C = map(int, input().split())
        graph[A].append((B, C))
        graph[B].append((A, C))

    print(getFarthest(1))


if __name__ == "__main__":
    main()
