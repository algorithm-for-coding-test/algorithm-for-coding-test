import heapq
import sys
input = lambda: sys.stdin.readline().rstrip()

# v : 정점의 개수, e: 간선의 개수
v, e = map(int, input().split())
start = int(input()) # 시작점

for _ in range(e):
	# s: 시작점, e : 도달점, w : 가중치
	s, e, w = map(int , input().split()

	if s not in graph:
		# s가 그래프에 없다면
		graph[s] = {}

	if e not in graph:
		# e가 그래프에 없다면
		graph[e] = {}

	# 기존에 있는 경우가 있을수 있음으로
	graph[s][e] = min(graph[s][e], w)
	# 양방향 그래프일 경우 처리
	graph[e][s] = min(graph[e][s], w)

distances = dijkstra(graph, start)

# 다익스트라 함수
def dijkstra(graph, start):
	distances = {node: float('inf') for node in graph }
	distances[start] = 0

	priorityQueue = [(0, start)]
	while priorityQueue:
		current_distance, current_node = heapq.heappop(priorityQueue)
		# 현재 distance가 기존 distance보다 더 멀다면 패스
		if current_distance > distances[current_node]:
				continue

		# 연결된 간선들을 순회
		for destination, weight in graph[current_node].items():
			distance = current_distance + weight
			if distance < distances[desitnation]:
					distances[destination] = distance
					heapq.heappush(priorityQueues, (distance, destination))
	return distances

distances = dijkstra(graph, start)
print(distances)
