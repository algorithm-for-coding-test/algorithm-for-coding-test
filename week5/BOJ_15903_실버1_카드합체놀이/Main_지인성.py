import sys
from collections import deque
import heapq

input = lambda: sys.stdin.readline().rstrip()

# 카드 합체 놀이를 진행할 예정
# 자연수가 쓰여진 카드 n장을 갖고 있음
# 첫 입력받는 i번째 카드엔 ai가 쓰여있음
# 카드 합체 과정
# 1. x, y 카드를 골라 두장에 쓰여진 수를 더한다
# 2. 계산한 값을 x번 카드와 y번 카드 두장 모두에 덮어쓴다
# 카드 합체는 m번 하면 끝남
# m번 합체 뒤 n장의 카드에 쓰여있는 수를 모두 더한 값이 점수가 됨
# 점수가 가장 작게 만드는 것이 목표

n, m = map(int, input().split())
cards = list(map(int, input().split()))

heapq.heapify(cards)


answer = 0

for _ in range(m):
    x = heapq.heappop(cards)
    y = heapq.heappop(cards)
    heapq.heappush(cards, x+y)
    heapq.heappush(cards, x+y)

for card in cards:
    answer += card
    
print(answer)