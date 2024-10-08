import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()

N = int(input())

weights = list(map(int, input().split()))
weights.sort()

q = deque(weights)
answer = []

if N % 2 == 0:
    for _ in range(N//2):
        answer.append(q.popleft() + q.pop())
else:
    answer.append(q.pop())
    for _ in range(N//2):
        answer.append(q.popleft() + q.pop())
print(max(answer))