import sys
from collections import deque, Counter
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
numbers = list(map(int ,input().split()))
numbers.sort()
answer = 0

for i in range(N-2):
    left = i+1
    right = N-1
    while left < right:
        two_sum = numbers[left] + numbers[right]
        if two_sum == -numbers[i]:
            if numbers[left] == numbers[right]:
                answer += (right-left)
                left += 1
            else:
                j,k = left, right
                while numbers[j] == numbers[left] and j < right:
                    j += 1
                while numbers[k] == numbers[right] and k > left:
                    k -= 1
                answer += (j-left)*(right-k)
                left,right = j,k
        elif two_sum < -numbers[i]:
            left += 1
        else:
            right -= 1
print(answer)