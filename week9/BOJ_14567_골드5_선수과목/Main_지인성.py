import sys
from collections import deque
input = lambda: sys.stdin.readline().rstrip()

def togologySort():
    q = deque([])
    for i in range(1, N+1):
        if inDegree[i] == 0:
            q.append(i)
    while q:
        # 현재 과목을 큐에서 뺀다
        now = q.popleft()
        result.append(now)

        # 현재 과목에 연결된 간선들을 제거
        for i in graph[now]:
            inDegree[i] -= 1
            answer[i] = answer[now] + 1
            if inDegree[i] == 0:
                q.append(i)

result = []
N, M = map(int, input().split())
inDegree = [0] * (N+1)
graph = [[] for _ in range(N+1)]
for _ in range(M):
    A, B = map(int, input().split())
    inDegree[B] += 1
    graph[A].append(B)

answer = [1] * (N+1)
togologySort()

for x in answer[1:]:
    print(x, end=" " )
print()