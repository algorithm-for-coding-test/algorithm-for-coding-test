n = int(input())

list = []

for i in range(n):
    s, e = map(int, input().split())
    list.append([s, e])

list.sort(key=lambda x: x[0])
list.sort(key=lambda x: x[1])

cnt = 0
k = 0
for i in range(len(list)):
    j = list[i][0]

    if j >= k:
        cnt += 1
        k = list[i][1]
print(cnt)
