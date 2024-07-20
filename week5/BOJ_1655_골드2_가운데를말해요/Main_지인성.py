import sys
import heapq

input = lambda: sys.stdin.readline().rstrip()
N = int(input())
leftHeap = []  #가운데 값을 포함한 최소 힙 
rightHeap = [] # 가운데 값 이후를 포함한 최대 힙
# 1 2 3 4 5 가 있을 때
# left Heap : [3, 2, 1]
# right Heap : [4, 5]
# left Heap[0] : 중간값으로 만들 것


for i in range(1, N+1):
    num = int(input()) # 새롭게 값을 입력 받는다
    if len(leftHeap) == len(rightHeap):
        heapq.heappush(leftHeap, -num) 
    else:
        heapq.heappush(rightHeap, num)
    if len(leftHeap) > 0 and len(rightHeap) > 0:
        if -leftHeap[0] > rightHeap[0]:
            # 만약 중간값이 될 leftHeap[0] 가 rightHeap보다 크다면
            x = heapq.heappop(leftHeap)
            y = heapq.heappop(rightHeap)
            heapq.heappush(leftHeap, -y)
            heapq.heappush(rightHeap, -x)
    print(-leftHeap[0])