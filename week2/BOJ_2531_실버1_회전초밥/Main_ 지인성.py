import sys 
input = lambda:sys.stdin.readline().rstrip()

N,d,k,c = map(int, input().split())
sushicounts = [0] * (d+1)
sushies = []
count = 0
answer = 0

for _ in range(N):
  sushies.append(int(input()))
sushies.extend(sushies[0:k])

for i in range(k):
  if sushicounts[sushies[i]] == 0:
    count += 1 
  sushicounts[sushies[i]] += 1

if sushicounts[c] == 0:
  answer = count + 1
else:
  answer = count 

# 슬라이딩 윈도우 기법을 활용해서, 오른쪽으로 한칸씩 이동하며 최대 answer를 구한다.

for i in range(k, N+k):
  if sushicounts[sushies[i-k]] == 1:
    count -= 1
  sushicounts[sushies[i-k]] -= 1
  
  if sushicounts[sushies[i]] == 0:
    count += 1
  sushicounts[sushies[i]] += 1
  if sushicounts[c] == 0:
    answer = max(answer, count +1)
  else:
    answer = max(answer, count)
  
  
  
print(answer)