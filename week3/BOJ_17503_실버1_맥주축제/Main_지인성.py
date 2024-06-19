# 브루트포스 알고리즘 -> 시간 초과
# import sys
# from itertools import combinations
#
# input = lambda: sys.stdin.readline().rstrip()
#
# N, M, K = map(int, input().split())
# favors = []
# dosus = []
#
# power = float('INF')
# lists = list(range(K))
#
# for _ in range(K):
# 	f, d = map(int, input().split())
# 	favors.append(f)
# 	dosus.append(d)
#
# for selected in combinations(lists, N):
# 	m_sum = 0 # 만족도
# 	m_pow = 0 # 최대 도수
# 	for s in selected:
# 		m_sum += favors[s]
# 		m_pow = max(m_pow, dosus[s])
#
# 	if m_sum >= M:
# 		power = min(power, m_pow)
#
# if power == float('INF'):
# 	print(-1)
# else:
# 	print(power)

# N일동안 축제 열림
# K종류의 맥주 있다
# 하루에 맥주 1병 소비, 같은 맥주는 못마심
# N일동안 N병을 마실 예정
# ==> K에서 N을 선택
# 각 맥주는 선호도, 도수레벨이 있음
# 맥주의 도수 레벨은 간 레벨보다 높으면 안됨.
# 맥주 N개를 마실때 선호도는 M이상이 돼야 한다.
# 간 레벨의 최솟값을 구하는 문제
# ==> 선호도를 모두 더한 값이 M이상이라면 간 레벨을 반영

import sys
from heapq import heappush, heappop, heapify
input = lambda: sys.stdin.readline().rstrip()

N, M, K = map(int, input().split())

beers = []

for _ in range(K):
	beers.append(tuple(map(int, input().split())))

beers.sort(key= lambda x: x[0])
beers.sort(key= lambda x: x[1])

hq = []
heapify(hq)

mSum = 0
minP = float('INF')


for i in range(K):
	heappush(hq, beers[i])
	mSum += beers[i][0]
	maxP = beers[i][1]
	if len(hq) == N:
		if mSum >= M:
			minP = min(minP, maxP)
			break
		
		else:
			x, y = heappop(hq)
			mSum -= x


if minP == float('INF'):
	print(-1)
else:
	print(minP)
		
		
	
	


	
