import sys
import heapq 
input = lambda: sys.stdin.readline().rstrip()

numbers = []
N = int(input())
for _ in range(N):
  x = int(input())
  if x == 0:
    if len(numbers) == 0:
      print(0)
    else:
      a, b = heapq.heappop(numbers)
      print(b)
  else:
    heapq.heappush(numbers, (abs(x), x))