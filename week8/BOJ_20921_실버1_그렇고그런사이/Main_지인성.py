import sys
input = lambda: sys.stdin.readline().rstrip()

N, K = map(int, input().split())
answer = []
numbers = [i for i in range(1, N+1)]
can_make = (N-1)

while True:
    if can_make < K:
        answer.append(numbers.pop(-1))  # 마지막 요소를 결과에 추가
        K -= can_make
        can_make -= 1
        numbers.sort()

    else:
        # K가 N-1보다 작을 때, K번째 요소와 첫 번째 요소를 교환
        answer.append(numbers.pop(K))  # K번째 요소를 결과에 추가
        numbers.sort()
        answer.extend(numbers)  # 나머지 요소들을 결과에 추가
        break

for x in answer:
    print(x, end=" ")
print()