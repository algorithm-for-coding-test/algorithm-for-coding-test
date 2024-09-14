import sys
from collections import deque
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
parent = [i for i in range(N + 1)]

def find(x):
    root = x
    while root != parent[root]:
        root = parent[root]

    while x != root:
        next_node = parent[x]
        parent[x] = root
        x = next_node

    return root

def union(x, y):
    rootX = find(x)
    rootY = find(y)
    if rootX != rootY:
        parent[rootY] = rootX

for _ in range(N - 2):
    a, b = map(int, input().split())
    union(a, b)

set_1, set_2 = None, None
for i in range(1, N + 1):
    root = find(i)
    if set_1 is None:
        set_1 = root
    elif set_1 != root:
        set_2 = root
        break

print(set_1, set_2)