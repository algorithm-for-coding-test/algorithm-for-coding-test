N, M = map(int, input().split())

trees = list(map(int, input().split()))

i = 0
j = max(trees)

while i <= j:
	mid = (i + j) // 2
	cnt = 0
	
	for tree in trees:
		if tree >= mid:
			cnt += (tree - mid)
	
	if cnt >= M:
		i = mid + 1
	
	else:
		j = mid - 1

print(j)

