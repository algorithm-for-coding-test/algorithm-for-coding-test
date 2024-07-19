import sys
import heapq
from collections import deque
input = lambda:sys.stdin.readline().rstrip()

N, Q, C = map(int, input().split()) 
caches = list(map(int, input().split())) # 페이지 별 캐시용량
lists = []

backwards = deque()
forwards = deque()
buffer = 0 # 현재 사용중인 캐시
current_page = 0 # 현재 접속중인 페이지

for _ in range(Q):
    lists.append(input().split())
    
for order in lists:
    if order[0] == 'A':
        # 접속이라면
        # 앞으로 가기 공간에 저장된 페이지를 모두 삭제
        # 삭제되는 페이지의 용량을 제거
        for p in forwards:
            buffer -= caches[p-1]
        forwards.clear() # 앞으로 가기 공간 모두 비우기

        # page : 새롭게 접속할 페이지 번호
        page = int(order[1])
        
        # 현재 페이지를 뒤로 가기 공간에 추가 (이번 페이지가 최초 접속 페이지가 아닌 경우)
        if current_page != 0:
            backwards.append(current_page)
            
        # 현재 페이지를 새로운 페이지로 변경
        current_page = page

        # 새로운 페이지 용량을 버퍼에 추가 
        buffer += caches[page-1] # 현재 페이지 용량을 추가
        # 만약 버퍼가 초과 됐다면 초과되지 않을때까지 뒤로가기에서 오래된 페이지를 뺀다
        while buffer > C: 
            p = backwards.popleft() # 만약 캐시가 오바됐다면 오바돼지않을때까지 뒤로가기에서 pop하기   
            buffer -= caches[p-1]
            
    
    elif order[0] == 'B': # 뒤로가기
        if not backwards: # 뒤로가기 버퍼에 페이지가 없다면 무시
            continue
        forwards.append(current_page)
        page = backwards.pop()
        current_page = page
    
    elif order[0] == 'F': # 앞으로 가기
        if not forwards: # 앞으로가기 버퍼에 페이지가 없다면 무시
            continue 
        backwards.append(current_page)
        current_page = forwards.pop()

    
    elif order[0] == 'C':
        temp_queue = deque()
        if backwards: 
            p = backwards.popleft()
            temp_queue.append(p)
            while backwards:
                q = backwards.popleft()
                if p == q:
                    buffer -= caches[p-1]
                    continue
                else:
                    p = q
                    temp_queue.append(p)

        backwards = temp_queue
print(current_page)

if backwards:
    while backwards:
        print(backwards.pop(), end=" ")
    print()
else:
    print(-1)

if forwards:
    while forwards:
        print(forwards.pop(), end=" ")
    print()
else:
    print(-1)
        