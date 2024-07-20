import sys
from collections import deque
input = lambda: sys.stdin.readline().rstrip()

# N: 카드의 개수
# M : 게임 진행 횟수  
N, M = map(int, input().split())

# 덱 : 숫자가 보이지 않게 카드를 뒤집어 쌓아 놓은 카드 더미
# 가장 위의 카드를 그라운드에 내려놓음
dodo_deck = deque()
suyeon_deck = deque()

dodofield = deque()
suyeonfield = deque()

# 바닥부터 맨 위 까지 차례대로 주어짐
for _ in range(N):
    x, y = map(int, input().split())
    dodo_deck.append(x)  # dodo 덱의 아래에 쌓기
    suyeon_deck.append(y)  # suyeon 덱의 아래에 쌓기

for i in range(M):
    # 카드를 덱에서 꺼내 자신의 필드에 내려놓음
    # 도도 차례라면
    if i % 2 == 0:
        dodofield.append(dodo_deck.pop())
    else:
        suyeonfield.append(suyeon_deck.pop())
    
    if not dodo_deck or not suyeon_deck:
        break
    
    # 만약 둘중 한명의 카드덱 중 5라는 숫자가 있다면 도도가 종을 친다
    if (dodofield and dodofield[-1] == 5) or (suyeonfield and suyeonfield[-1] == 5):
        # 도도 승리
        # 상대 그라운드에 있는 카드를 뒤집은 다음 덱 아래에 그대로 합친다
        # 이후 나의 그라운드에 있는 카드를 뒤집은 다음 나의 덱 아래로 가져와 합친다
        while suyeonfield:
            dodo_deck.appendleft(suyeonfield.popleft())
            
        while dodofield:
            dodo_deck.appendleft(dodofield.popleft())


    elif dodofield and suyeonfield and (dodofield[-1] + suyeonfield[-1]) == 5:
        # 수연이 승리
        # 상대 그라운드에 있는 카드를 뒤집은 다음 덱 아래에 그대로 합친다
        # 이후 나의 그라운드에 있는 카드를 뒤집은 다음 나의 덱 아래로 가져와 합친다
        while dodofield:
            suyeon_deck.appendleft(dodofield.popleft())
        while suyeonfield:
            suyeon_deck.appendleft(suyeonfield.popleft())



# 결과 확인
if len(dodo_deck) > len(suyeon_deck):
    print("do")
    
elif len(dodo_deck) < len(suyeon_deck):
    print("su")
    
else:
    print("dosu")

