N, M, K = map(int, input().split())
graph = []
answer = 0
for _ in range(N):
  lists = list(input())
  graph.append(lists)

def dfs(x,y, cnt):
    global answer 
  
    if cnt > K:
        return 
    
    if x < 0 or x >= N:
        return
    
    if y < 0 or y >= M:
        return 

    if x == 0 and y == M-1:         
        if cnt == K:  
            answer += 1
        return
  
    
    if graph[x][y] == '.':
        graph[x][y] = 'T'
        dfs(x-1, y, cnt+1)
        dfs(x+1, y, cnt+1)
        dfs(x, y-1, cnt+1)
        dfs(x, y+1, cnt+1)
        graph[x][y] = '.'

dfs(N-1, 0, 1)

print(answer)
