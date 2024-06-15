C, R = map(int, input().split())
K = int(input())

graph = []

for i in range(R):
	graph.append([0] * C)

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

x = 0
y = R - 1
d = 0
c = 1

if C * R < K:
	print(0)

else:
	while True:
		
		if c == K:
			print(x + 1, R - y)
			break
		
		graph[y][x] = c
		
		nx = x + dx[d]
		ny = y + dy[d]
		
		if 0 <= nx < C and 0 <= ny < R and graph[ny][nx] == 0:
			x = nx
			y = ny
			c = c + 1
		
		else:
			d = (d + 1) % 4
			x = x + dx[d]
			y = y + dy[d]
			c += 1




