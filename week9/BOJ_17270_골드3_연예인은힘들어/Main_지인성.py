import sys
import heapq
input = lambda: sys.stdin.readline().rstrip()

def dijkstra(graph, start, V):
    distances = {node: float('inf') for node in range(1, V + 1)}
    distances[start] = 0
    priorityQueue = [(0, start)]

    while priorityQueue:
        current_distance, currentNode = heapq.heappop(priorityQueue)

        if current_distance > distances[currentNode]:
            continue

        for neighbor, weight in graph[currentNode].items():
            distance = current_distance + weight
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(priorityQueue, (distance, neighbor))

    return distances

# 그래프 초기화
graph = {}
V, M = map(int, input().split())

for _ in range(M):
    a, b, c = map(int, input().split())

    # 양방향 그래프 생성
    if a not in graph:
        graph[a] = {}
    if b not in graph:
        graph[b] = {}

    # 이미 간선이 있다면, 더 작은 가중치를 선택
    if b in graph[a]:
        graph[a][b] = min(graph[a][b], c)
    else:
        graph[a][b] = c

    if a in graph[b]:
        graph[b][a] = min(graph[b][a], c)
    else:
        graph[b][a] = c

# 지헌과 성하의 출발 위치
l, s = map(int, input().split())

# 다익스트라 알고리즘을 사용하여 최단 거리 계산
l_distances = dijkstra(graph, l, V)
s_distances = dijkstra(graph, s, V)

min_distance = float('inf')
for i in range(1, V + 1):
    if i == l or i == s:
        continue
    if l_distances[i] == float('inf') or s_distances[i] == float('inf'):
        continue

    both = l_distances[i] + s_distances[i]
    min_distance = min(min_distance, both)

answer = -1
best_distance_for_l = float('inf')

for i in range(1, V + 1):
    if i == l or i == s:
        continue
    if l_distances[i] == float('inf') or s_distances[i] == float('inf'):
        continue

    both = l_distances[i] + s_distances[i]

    if both == min_distance and l_distances[i] <= s_distances[i]:
        if l_distances[i] <= best_distance_for_l:
            best_distance_for_l = l_distances[i]
            answer = i

print(answer)