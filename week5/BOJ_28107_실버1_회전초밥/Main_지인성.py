import sys
import heapq
N, M = map(int, input().split()) # N : 손님 수, M : 초밥의 수
orders = [[] for _ in range(200001)]

for i in range(N):
    x, *favorites = map(int, input().split())
    for favorite in favorites:
        heapq.heappush(orders[favorite], i)
    # orders : 각 리스트마다 초밥을 먹고싶어하는 사람들의 인덱스 번호가 들어가게 됨
    # ex) orders[0] = 0번 초밥을 먹고싶어하는 리스트번호 (우선순위 큐로 번호가 적은 순서)

chobabs = list(map(int, input().split())) # 준비된 초밥

answers = [0] * N

for chobab in chobabs:
    if orders[chobab]: # 만약 해당 초밥을 원하는 사람이 있다면 
        i = heapq.heappop(orders[chobab]) # 해당 사람 번호를 꺼내온 뒤
        answers[i] += 1 # 초밥을 먹임
for i in range(N):
  print(answers[i], end=" ")
print()