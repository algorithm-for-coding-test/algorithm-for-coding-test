import sys
from collections import deque

F, S, G, U, D = map(int, sys.stdin.readline().split())
answer = [1000001] * (F+1)
visited = [False] * (F+1)
floors = [] * (F+1)

de = [U, -D]
queue = deque([S])


answer[S] = 0

while queue:
	s = queue.popleft()
	visited[s] = True

	#위층으로 올라갈 수 있고, 최단 경로라면
	if U > 0:
		du = s + de[0]
		if 1 <= du <= F and not visited[du]:
			answer[du] = (answer[s] + 1)
			visited[du] = True
			queue.append(du)

	#아래층으로 내려갈 수 있고, 최단 경로라면
	if D > 0:
		dd = s + de[1]
		if 1 <= dd <= F and not visited[dd]:
			answer[dd] = (answer[s] + 1)
			visited[dd] = True
			queue.append(dd)

if answer[G] == 1000001:
	print('use the stairs')
else:
	print(answer[G])