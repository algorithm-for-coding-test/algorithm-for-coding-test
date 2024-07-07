import sys 
from collections import deque

input = lambda: sys.stdin.readline().rstrip()

N,M,K = map(int, input().split())
maps = []
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

# 3차원 배열
visited = [[[0] * (K + 1) for _ in range(M)] for _ in range(N)]

def bfs():
  queue = deque([(0, 0, K)])
  visited[0][0][K] = 1
  
  while queue:
      x, y, broke = queue.popleft()

      if x == N - 1 and y == M - 1:
          return visited[x][y][broke]

      for i in range(4):
          nx = x + dx[i] 
          ny = y + dy[i]

          if 0 <= nx < N and 0 <= ny < M:
              if maps[nx][ny] == 0 and visited[nx][ny][broke] == 0:
                  visited[nx][ny][broke] = visited[x][y][broke]+1
                  queue.append((nx, ny, broke))
              elif maps[nx][ny] == 1 and broke > 0 and visited[nx][ny][broke-1] == 0:
                  visited[nx][ny][broke-1] = visited[x][y][broke]+1
                  queue.append((nx, ny, broke-1))
  return -1
    
for i in range(N):
  lists = list(map(int, input()))
  maps.append(lists)

answer = bfs()
print(answer)