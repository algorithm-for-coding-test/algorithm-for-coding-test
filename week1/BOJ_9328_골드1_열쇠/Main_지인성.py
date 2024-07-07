import sys 
from collections import deque, defaultdict
import copy

input = lambda: sys.stdin.readline().rstrip()
n = int(input())

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def bfs(x, y, maps, givenkeys):
    queue = deque([(x,y)])
    visited = [[False] * (w+2) for _ in range(h+2)]
    visited[x][y] = True
    cnt = 0
    acquiredkey = [] # 새롭게 얻은 키
    
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

                
            # 유효한 범위가 아니거나
            if 0 > nx or nx >= (h+2) or 0 > ny or ny >= (w+2):
                continue
                
            # 이미 방문했거나
            elif visited[nx][ny]:
                continue
                
            # 벽이면 패스
            elif graph[nx][ny] == '*':
                continue
                
            # 진입할 수 있으면 진입
            elif graph[nx][ny] == '.':
                visited[nx][ny] = True
                queue.append((nx, ny))

            # 문이면 키가 있는지 체크 
            elif 'A' <= graph[nx][ny] <= 'Z':
                # 열쇠가 있다면 방문
                if graph[nx][ny].lower() in givenkeys:
                    visited[nx][ny] = True
                    queue.append((nx,ny))
                else:
                    continue
                

            # 열쇠면 얻음, 리스트에 key 추가 but 이번 회차에선 반영 X
            elif 'a' <= graph[nx][ny] <= 'z':
                if graph[nx][ny] not in givenkeys:
                    acquiredkey.append(graph[nx][ny])
                visited[nx][ny] = True
                queue.append((nx,ny))
                
            # 돈이면 카운트
            elif graph[nx][ny] == '$':
                cnt += 1
                visited[nx][ny] = True
                queue.append((nx, ny))
    givenkeys.extend(acquiredkey)
    return cnt, givenkeys
            
for _ in range(n): 
    h, w = map(int, input().split())
    graph = [['.'] * (w+2)]
    
    entrances = []

    for i in range(h):
        line = ['.']
        line.extend(list(input()))
        line.append('.')
        graph.append(line)
    graph.append(['.'] * (w+2))
    keys = list(set(input()))
    keys.sort()


    # bfs 돌면서 key를 갱신, key가 갱신되면 해당 key들을 가지고 다시 bfs
    # 만약 key가 갱신되지 않으면 빠져나와 누적된 $를 리턴함
    while True:
        cnt, newkeys = bfs(0, 0, graph, copy.deepcopy(keys))
        if sorted(newkeys) == sorted(keys):
            print(cnt)
            break
            
        else:
            keys = newkeys