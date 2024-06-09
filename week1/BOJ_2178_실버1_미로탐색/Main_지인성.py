#첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
# 4 5 1
# 1 2
# 1 3
# 1 4
# 2 4
# 3 4
from collections import deque

N,M = map(int, input().split())
miro = []
dx = [1, 0, -1, 0]
dy = [0, 1, 0 ,-1]

for _ in range(N):
  lists = list(map(int, input().strip()))
  miro.append(lists)

def bfs(x,y):
  queue = deque([(x,y)])

  while queue:
    i, j = queue.popleft()
    for k in range(4):
      nx = i + dx[k]
      ny = j + dy[k]

      if 0 <= nx < N and 0 <= ny < M and miro[nx][ny] == 1:
        miro[nx][ny] = (miro[i][j] + 1)
        queue.append((nx,ny))

bfs(0,0)
print(miro[N-1][M-1])