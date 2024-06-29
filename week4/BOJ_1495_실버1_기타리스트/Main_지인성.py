N, S, M = map(int, input().split())
V = list(map(int, input().split()))
dp = [[0] * (M+1) for _ in range(N+1)]
dp[0][S] = 1

for i in range(1, N+1):
  for j in range(M+1):
    if dp[i-1][j] == 1:
      min_vol = j - V[i-1]
      max_vol = j + V[i-1]
      if min_vol >= 0:
        dp[i][min_vol] = 1
      if max_vol <= M:
        dp[i][max_vol] = 1
        
result = -1

for i in range(M+1):
  if(dp[N][i] == 1):
    result = i

print(result)