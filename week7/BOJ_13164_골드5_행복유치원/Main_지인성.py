import sys

N, K = map(int,input().split())
sensors = list(map(int, input().split()))
sensors.sort()

distance = []
for i in range(N-1):
    distance += [sensors[i+1]-sensors[i]]
distance.sort()
print(sum(distance[:N-K]))

