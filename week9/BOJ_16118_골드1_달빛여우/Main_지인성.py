import sys
import heapq
from collections import defaultdict

input = lambda: sys.stdin.readline().rstrip()

def dijkstra_fox(graph, start):
    distances = {node : float('inf') for node in graph}
    distances[start] = 0

    priorityQueue = [(0, start)]
    while priorityQueue:
        current_distance, current_node = heapq.heappop(priorityQueue)
        if current_distance > distances[current_node]:
            continue
        for neighbor, weight in graph[current_node].items():
            distance = current_distance + weight
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(priorityQueue, (distance, neighbor))
    return distances

def dijkstra_wolf(graph, start):
    # distances[node][0]: 짝수 번째 이동 속도일 때의 최단 거리
    # distances[node][1]: 홀수 번째 이동 속도일 때의 최단 거리
    distances = {node: [float('inf'), float('inf')] for node in graph}
    distances[start][1] = 0  # 출발 시 첫 번째 경로는 홀수 번째로 시작

    priorityQueue = [(0, start, 1)]  # (거리, 노드, 홀수/짝수 여부)

    while priorityQueue:
        current_distance, current_node, step = heapq.heappop(priorityQueue)

        if current_distance > distances[current_node][step]:
            continue

        for neighbor, weight in graph[current_node].items():
            if step == 1:  # 현재 홀수 번째라면, 다음은 짝수 번째 (0.5배 속도)
                distance = current_distance + (weight * 0.5)
                if distance < distances[neighbor][0]:
                    distances[neighbor][0] = distance
                    heapq.heappush(priorityQueue, (distance, neighbor, 0))
            else:  # 현재 짝수 번째라면, 다음은 홀수 번째 (2배 속도)
                distance = current_distance + (weight * 2)
                if distance < distances[neighbor][1]:
                    distances[neighbor][1] = distance
                    heapq.heappush(priorityQueue, (distance, neighbor, 1))

    return distances

graph = defaultdict(dict)
N, M = map(int, input().split())

for _ in range(M):
    a, b, d = map(int, input().split())
    graph[a][b] = d
    graph[b][a] = d

# 달빛 여우와 달빛 늑대의 최단 거리 계산
distances_fox = dijkstra_fox(graph, 1)
distances_wolf = dijkstra_wolf(graph, 1)

# 달빛 여우가 더 빨리 도착할 수 있는 그루터기 수 세기
count = 0
for i in range(2, N+1):
    if distances_fox[i] < min(distances_wolf[i]):
        count += 1

print(count)