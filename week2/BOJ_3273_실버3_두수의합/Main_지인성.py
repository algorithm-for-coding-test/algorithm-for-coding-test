import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
numbers = list(map(int, input().split()))
x = int(input())
answer = 0
i = 0 
j = n-1

numbers.sort()

while i < j:
  sum = numbers[i] + numbers[j]
  if sum == x:
    answer += 1
    i+=1
  elif sum > x:
    j-=1
  else:
    i+=1
    
    
  


print(answer)