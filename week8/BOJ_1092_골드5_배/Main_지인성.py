import sys
input = lambda: sys.stdin.readline().rstrip()

# N : 크레인의 개수
# limits : 각 크레인의 최대 무게제한
# M : 박스의 수
# boxes : 각 박스의 무게

N = int(input())
limits = list(map(int, input().split()))

M = int(input())
boxes = list(map(int, input().split()))

limits.sort(reverse=True)
boxes.sort(reverse=True)

answer = 0
if boxes[0] > limits[0]:
    answer = -1
else:
    while boxes:
        for c in limits:
            if boxes and c < boxes[-1]:
                continue
            for b in boxes:
                if c >= b:
                    boxes.remove(b)
                    break
        answer+=1

print(answer)