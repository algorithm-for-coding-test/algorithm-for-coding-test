import sys
from collections import deque
input = lambda: sys.stdin.readline().rstrip()

N, K = map(int, input().split())
numbers = list(input())
stack = []

for n in numbers:
    while stack and stack[-1] < n and K > 0:
        stack.pop()
        K -= 1
    stack.append(n)

if K > 0:
    print(''.join(stack[:-K]))
else:
    print(''.join(stack))