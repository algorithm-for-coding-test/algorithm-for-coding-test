import sys
import copy 
input = lambda: sys.stdin.readline().rstrip()


T = int(input())
for _ in range(T):
    DP = [1] * 10 # 각 숫자별 등장 횟수  
    len = int(input())
    for i in range(1, len):
        num = copy.deepcopy(DP)
        DP[0] = num[7]
        DP[1] = num[2] + num[4]
        DP[2] = num[1] + num[3] + num[5]
        DP[3] = num[2] + num[6] 
        DP[4] = num[1] + num[5] + num[7]
        DP[5] = num[2] + num[4] + num[6] + num[8]
        DP[6] = num[3] + num[5] + num[9]
        DP[7] = num[4] + num[8] + num[0]
        DP[8] = num[5] + num[7] + num[9]
        DP[9] = num[6] + num[8]
        
    print(sum(DP) % 1234567)