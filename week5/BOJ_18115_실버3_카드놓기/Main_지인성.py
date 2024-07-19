import sys 
from collections import deque 
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
orders = list(map(int, input().split()))
orders.reverse()
stack = [(i+1) for i in range(N)]
stack.reverse()

queue = deque()

for o in orders:
  if o == 1:
    queue.append(stack.pop())
  elif o == 2:
    queue.insert(-1, stack.pop())
  elif o == 3:
    queue.appendleft(stack.pop())

while queue:
  q = queue.pop()
  print(q, end=" ")
print()