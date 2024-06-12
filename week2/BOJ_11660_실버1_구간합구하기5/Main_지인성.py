import sys
input = lambda : sys.stdin.readline().rstrip()

N, M = map(int, input().split())
graph = [[0] * (N+1)]
trials = []

for _ in range(N):
  lists = [0]
  lists.extend(map(int, input().split()))  
  graph.append(lists)

for _ in range(M):
  trials.append(list(map(int, input().split())))

for i in range(1,N+1):
  for j in range(1, N+1):
    graph[i][j] = graph[i][j] + graph[i-1][j] + graph[i][j-1] - graph[i-1][j-1]

for a,b,c,d in trials:
  print(graph[c][d] + graph[a-1][b-1] - graph[a-1][d] - graph[c][b-1])