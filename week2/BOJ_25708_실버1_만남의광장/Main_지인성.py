import sys
input = lambda:sys.stdin.readline().rstrip() 

maps = []
# answer = 0
answer = float('-inf')
rowSum = 0
colSum = 0 
N, M = map(int, input().split())
rowSums = [0] * N
colSums = [0] * M


for _ in range(N):
  maps.append(list(map(int, input().split())))

for i in range(N):
  rowSum = 0
  for j in range(M):
    rowSum +=  maps[i][j]
  rowSums[i] = rowSum

for i in range(M):
  colSum = 0 
  for j in range(N):
    colSum += maps[j][i]
  colSums[i] = colSum 


for x in range(N):
  for i in range(x+1, N):
    for y in range(M):
      for j in range(y+1, M):
        count = rowSums[x] + rowSums[i] + colSums[y] + colSums[j] - maps[x][y] - maps[x][j] - maps[i][y] - maps[i][j] 
        # 숲에 둘러싸인 영역이 있는지 구하기 
        k = (i) - (x+1)
        l = (j) - (y+1)
        if k > 0 and l > 0:
          count += k*l
        answer = max(answer, count)

print(answer)