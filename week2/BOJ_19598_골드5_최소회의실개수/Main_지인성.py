import sys
from collections import defaultdict
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
events = defaultdict(int)

for _ in range(N):
    x, y = map(int, input().split())
    events[x] += 1
    events[y] -= 1

current = 0
max_rooms = 0

for time in sorted(events):
    current += events[time]
    max_rooms = max(max_rooms, current)

print(max_rooms)