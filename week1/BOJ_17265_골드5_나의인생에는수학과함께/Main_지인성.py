N = int(input())
graph = []
visited = [[False] * N for _ in range(N)]
answer = [-float('inf'), float('inf')]

for _ in range(N):
	graph.append(list(input().split()))

dx = [1, 0]
dy = [0, 1]


# x,y : 좌표
# value : 현재 값
# calc : 문자열 형식의 수식
def dfs(x, y, expression need_sign):
	if x == N-1 and y == N-1:
		result = eval(expression)
		answer[0] = max(answer[0], result)
		answer[1] = min(answer[1], result)
		return
	
	visited[x][y] = True
	for i in range(2):
		nx = x + dx[i]
		ny = y + dy[i]

		if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny]:
			# 부호가 필요하며 타겟 대상이 부호인 경우
			if need_sign and not graph[nx][ny].isdigit():
				# 기존 표현식에 부호를 붙임
				dfs(nx, ny, expression + " " + graph[nx][ny], False)

			# 숫자가 필요하며, 다음 타겟 대상이 숫자인 경우
			elif not need_sign and graph[nx][ny].isdigit():
				dfs(nx, ny, "(" + expression + " " + graph[nx][ny] + ")", True)
	visited[x][y] = False


dfs(0, 0, graph[0][0], True)

print(answer[0], answer[1])
