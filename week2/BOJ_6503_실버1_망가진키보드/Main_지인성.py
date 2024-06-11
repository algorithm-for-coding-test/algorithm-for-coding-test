import sys 
input = lambda: sys.stdin.readline().rstrip() 

while True:
  answer = 0
  
  m = int(input())
  if m == 0:
    break
    
  str = input() # 문자열
  sets = list(set(str)) # 문자열 리스트 (중복제거)
  frequent = [0] * len(sets) # 빈도수
  
  
  i=0
  j=1
  frequent[sets.index(str[0])] += 1
  
  count = 1
  m -= 1
  
  while j < len(str):
     
    c1 = str[i] 
    c2 = str[j]

    # 만약 j번째 문자가 기존에 포함된 문자중 하나라면
    if frequent[sets.index(c2)] > 0:
      # 최대 길이를 1증가 시키며 
      # j 포인터가 다음 문자를 가르키게 만든다.
      count += 1
      j += 1
      frequent[sets.index(c2)] += 1

    # 만약 기존에 포함된 문자가 아니라면  
    else:
      # 포함시킬 수 있는지 체크 
      if m > 0:
        # 포함시킬 수 있다면 
        m -= 1 # m을 1 감소 시키고 
        frequent[sets.index(c2)] += 1 # 다음 문자열을 포함시킨다
        count += 1 # 길이를 1증가 시킨다 
        j += 1 # 다음 인덱스로 이동 
        
      else:
        # 포함시킬 수 없다면 포함 시킬 수 있을때까지 i포인터를 앞으로 이동 시킨다.
        # i포인터를 한칸씩 이동
        frequent[sets.index(c1)] -= 1
        if frequent[sets.index(c1)] == 0:
          m += 1
        count -= 1
        i+=1
          
        

    answer = max(answer, count)
  print(answer)