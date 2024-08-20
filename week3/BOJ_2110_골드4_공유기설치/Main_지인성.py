import sys
from collections import defaultdict 

input = lambda: sys.stdin.readline().rstrip()
houses = []

N, C = map(int, input().split())
for _ in range(N):
    houses.append(int(input()))

houses.sort()

start = 1 # 최소 거리 
end = houses[-1] - houses[0] # 최대 공유기 거리
answer = 0

while start <= end:
    mid = (start + end) // 2 # 현재 공유기 거리
    current = houses[0]
    count = 1

    for i in range(1, len(houses)):
        if houses[i] >= current + mid:
            count += 1
            current = houses[i]
    if count >= C:
        start = mid + 1
        answer = mid
    else:
        end = mid - 1




print(answer)