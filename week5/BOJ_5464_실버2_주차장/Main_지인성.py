import sys
import heapq
from collections import deque
input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())
weightPrices = []  # 주차장 별 단위무게별 가격
weightList = []  # 차량별 무게 리스트

parkingSpaces = [None] * N  # 주차 공간 상태 (None은 빈 공간을 의미)
parkingHeap = list(range(N))  # 우선순위 큐에 사용할 리스트
waiting = deque()
heapq.heapify(parkingHeap)
answer = 0

# 주차장 별 단위무게별 가격 입력
for _ in range(N):
    weightPrices.append(int(input()))

# 차량별 무게 리스트 입력
for _ in range(M):
    weightList.append(int(input()))

# 입출차 정보 처리
for _ in range(M * 2):
    x = int(input())

    if x > 0:  # 차량이 들어올 때
        x -= 1

        if parkingHeap:  # 주차 공간이 있다면
            i = heapq.heappop(parkingHeap)  # 가장 번호가 작은 주차번호를 꺼내옴
            parkingSpaces[i] = x  # 주차 공간에 주차 후
            answer += weightPrices[i] * weightList[x]  # 해당 주차 공간의 요금 * 차의 무게
        else:  # 주차 공간이 없다면
            waiting.append(x)  # 대기 중인 차량에 추가

    else:  # 차량이 나갈 때
        x = -x - 1
        i = parkingSpaces.index(x)  # 해당 차량이 주차된 인덱스를 찾아서

        if waiting:  # 만약 대기 중인 차량이 있다면
            next_car = waiting.popleft()  # 대기 중인 차량을 꺼내서
            parkingSpaces[i] = next_car  # 해당 주차 공간에 추가
            answer += weightPrices[i] * weightList[next_car]
        else:
            parkingSpaces[i] = None  # 해당 주차 공간을 비우기
            heapq.heappush(parkingHeap, i)

print(answer)