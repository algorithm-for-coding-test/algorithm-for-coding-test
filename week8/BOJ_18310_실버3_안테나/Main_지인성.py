import sys 

input = lambda: sys.stdin.readline().strip()

N = int(input())
house = list(map(int, input().split()))

house.sort()

print(house[(N-1)//2])

#오답 
# distances = []

# distances.append((house[0], 0))

# for i in range(1, N):
#     distances.append((house[i], abs(house[i] - house[i-1])))

# distances.sort(key=lambda x: x[1])

# x, y = distances[-1]
# print(x)





    
