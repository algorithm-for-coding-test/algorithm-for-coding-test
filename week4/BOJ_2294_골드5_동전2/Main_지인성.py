import sys
input = lambda:sys.stdin.readline().rstrip()
sys.setrecursionlimit(10**5)
n, k = map(int, input().split())
DP = [0] * (k+1)
coins = []

for _ in range(n):
  coins.append(int(input()))


def solve(k):
  if k <= 0:
    return 0 

  if DP[k] != 0:
    return DP[k]

  DP[k] = float('inf')

  for coin in coins:
    if coin <= k:
      DP[k] = min(DP[k], solve(k-coin) + 1)
  return DP[k]

answer = solve(k)

if answer == float("INF"):
  print(-1)

else:
  print(answer)