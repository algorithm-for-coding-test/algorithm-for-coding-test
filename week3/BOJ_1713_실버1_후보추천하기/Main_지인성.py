import sys

input = lambda: sys.stdin.readline().rstrip()

n = int(input())

photos = []

k = int(input())

count = [1001] * (k + 1)

lists = list(map(int, input().split()))

# 학생들이 추천 전엔 모든 사진이 비어있다.
# 특정 학생 추천시 추천 받은 학생은 게시된다
# 비어 있는 사진이 없으면 추천받은 횟수가 가장 적은 학생 삭제, 그 자리에 새롭게 추천받은 학생 사진 게시
# 2명 이상이라면 가장 오래된 사진 삭제
# 게시된 사진이 추천을 받으면 추천받은 횟수 증가
# 게시된 사진 삭제시 추천받은 횟수는 0

# 한명씩 추천 학생을 꺼냄
for i in lists:
	# 이미 추천받은 학생이라면
	if i in photos:
		# 해당 학생의 추천수를 1 증가
		count[i] += 1
	
	# 추천받지 않은 학생이라면
	else:
		# 액자 여유분이 있는지 체크
		if len(photos) == n:
			# 여유분이 없다면 추천이 가장 적은 학생을 찾고
			Min = min(count)
			for photo in photos:
				# 그 학생을 사진첩에서 제거하고
				# 새로운 학생을 집어넣음
				if count[photo] == Min:
					count[photo] = 1001
					photos.remove(photo)
					photos.append(i)
					count[i] = 1
					break
		
		# 여유분이 있다면 사진첩에 추가
		else:
			photos.append(i)
			count[i] = 1

photos.sort()
for i in photos:
	print(i, end=" ")
print()