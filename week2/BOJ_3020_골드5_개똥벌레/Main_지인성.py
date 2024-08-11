import sys 
input = lambda: sys.stdin.readline().rstrip()
from bisect import bisect_left, bisect_right

N,H = map(int, input().split())
석순 = []
종유석 = []
pSum = [0] * (H+1)

# 석순, 종유석 순
for i in range(N):
  value = int(input())
  # 석순이라면
  if i % 2 == 0:
    # 현창이가 알려준 시작 위치 +1 마지막 위치 + 1 -1 처리
    pSum[0] += 1
    pSum[value] -= 1
  # 종유석 이라면
  else:
    pSum[H-value] += 1
    pSum[H] -= 1
    
for i in range(1, H):
  pSum[i] += pSum[i-1]

min_value = min(pSum[:H])

cnt = 0
for x in pSum:
  if x == min_value:
    cnt +=1
print(min_value, cnt)