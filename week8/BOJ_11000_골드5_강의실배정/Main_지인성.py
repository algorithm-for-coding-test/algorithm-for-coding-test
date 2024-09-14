import sys
import heapq

input = lambda: sys.stdin.readline().strip()

N = int(input())
time = []
for _ in range(N):
    s, e = map(int, input().split())
    time.append((s, e))

time.sort(key = lambda x: (x[0], x[1]))

meeting_room = []

for i in range(N):
    if meeting_room and meeting_room[0] <= time[i][0]:
        heapq.heappop(meeting_room)
    heapq.heappush(meeting_room, time[i][1])

print(len(meeting_room))