import sys
input = lambda: sys.stdin.readline().rstrip()

INF = float('INF')

N, M = map(int, input().split())

graph = [[INF] * N for _ in range(N)]

for i in range(N):
    graph[i][i] = 0

for _ in range(M):
    a, b = map(int, input().split())
    graph[a-1][b-1] = 1

for k in range(N):
    for i in range(N):
        for j in range(N):
            if graph[i][j] > graph[i][k] + graph[k][j]:
                graph[i][j] = graph[i][k] + graph[k][j]

answer = 0

for i in range(N):
    count = 0
    for j in range(N):
        if graph[i][j] != INF or graph[j][i] != INF:
            count += 1
    if count == N:
        answer += 1

print(answer)