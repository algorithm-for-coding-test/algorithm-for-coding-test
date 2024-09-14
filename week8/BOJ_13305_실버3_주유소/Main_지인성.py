N = int(input())

distance = list(map(int,input().split())) #거리에 대한 정보
price = list(map(int,input().split())) # 기름값에 대한 정보

min_index = 0
total = 0

#알고리즘
#만약 현재 주유소의 가격 보다 다음 주요소의 가격이 더 저렴하다면
#현재주유소에서 다음 목적지 까지 갈 기름만 넣는다

#만약 현재 우유소의 가격이 다음 주요소의 가격보다 저렴하다면
#더 저렴한 주유소가 어디까지 인지를 파악한 다음 그 주유소 까지 갈 기름을 현재 주유소에서 모두 넣는다
#만약 현재 주유소가 가장 저렴한 주유소라면 현재 주유소에서 목적지 까지의 기름을 모두 넣는다

for i in range(1,N):
  if price[min_index] > price[i]:
    total = total+price[min_index] * sum(distance[min_index:i])
    min_index = i

  elif i == N-1:
    total = total+price[min_index] * sum(distance[min_index:i])





print(total)