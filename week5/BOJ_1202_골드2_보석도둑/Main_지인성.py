import heapq 
import sys

N,K = map(int,input().split()) #N은 보석개수 K는 가방개수
jew = [] #각 보석의 정보
Bags = [] #각 가방용량의 정보
temp = []


for i in range(N): #보석의개수만큼 정보를 입력받는다 
  M,V = map(int,sys.stdin.readline().split()) 
  #M은 보석의무게 V는 보석의 가격
  heapq.heappush(jew, [M,V]) 
  #보석은 무게가 가변운 것을 우선순위가 높도록 

for i in range(K):
  Bags.append(int(sys.stdin.readline())) #가방의 용량에 대한 정보를 받는다 
Bags.sort() #가방의 용량이 낮은것부터 오름차순으로 정렬  

total = 0
for bag in Bags:
  while jew and jew[0][0]<=bag:
    heapq.heappush(temp,-(heapq.heappop(jew)[1]))
  if temp:
    total-=heapq.heappop(temp)
print(total)