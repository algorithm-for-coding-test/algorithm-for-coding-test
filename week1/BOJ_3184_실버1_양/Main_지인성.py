from collections import deque

R,C = map(int, input().split())
yards = []

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

final_sheep = 0
final_wolf = 0

for _ in range(R):
  lists = list(input())
  yards.append(lists)


def bfs(x,y):
  global final_sheep
  global final_wolf
  sheep = 0
  wolf = 0

  if yards[x][y] == 'o':
    sheep += 1

  elif yards[x][y] == 'v':
    wolf += 1

  yards[x][y] = '#'
  queue = deque([(x,y)])

  while queue:
    i,j = queue.popleft()
    yards[i][j] = '#'

    for k in range(4):
      nx = i + dx[k]
      ny = j + dy[k]
      if 0 <= nx < R and 0 <= ny < C:
        if yards[nx][ny] == 'o':
          sheep += 1
          yards[nx][ny] = '#'
          queue.append((nx,ny))

        elif yards[nx][ny] == 'v':
          wolf += 1
          yards[nx][ny] = '#'
          queue.append((nx,ny))

        elif yards[nx][ny] == '.':
          yards[nx][ny] = '#'
          queue.append((nx,ny))

        else:
          continue

  if sheep > wolf:
    final_sheep += sheep
  else:
    final_wolf += wolf

for i in range(R):
  for j in range(C):
    if yards[i][j] == 'v' or yards[i][j] == 'o':
      bfs(i,j)
print(final_sheep, final_wolf)