import sys
import heapq
input = lambda: sys.stdin.readline().rstrip()

def dijkstra(graph, start):
    distances = {node: float('INF') for node in range(1, V + 1)}
    distances[start] = 0

    # 우선순위 큐 (거리, 노드)
    priority_queue = [(0, start)]

    while priority_queue:
        current_distance, current_node = heapq.heappop(priority_queue)

        # 현재 노드까지의 거리가 기존 기록된 거리보다 큰 경우 무시
        if current_distance > distances[current_node]:
            continue

        # 현재 노드의 인접 노드 탐색
        for adjacent, weight in graph.get(current_node, {}).items():
            distance = current_distance + weight

            # 현재 경로가 더 짧은 경우
            if distance < distances[adjacent]:
                distances[adjacent] = distance
                heapq.heappush(priority_queue, (distance, adjacent))

    return distances

V, E = map(int, input().split())

start = int(input())

graph = {}

for _ in range(E):
    u, v, w = map(int, input().split())

    if u not in graph:
        graph[u] = {}
    if v in graph[u]:
        graph[u][v] = min(graph[u][v], w)  # 여러 간선 중 최소 가중치 선택
    else:
        graph[u][v] = w

distances = dijkstra(graph, start)

for i in range(1, V + 1):
    if distances[i] == float('INF'):
        print("INF")
    else:
        print(distances[i])