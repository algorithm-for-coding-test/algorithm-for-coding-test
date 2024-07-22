def count(A, n): # 활성화된 비트가 몇개 있는지를 세는 메서드
  count = 0
  for i in range(n):
      if ((A & (1 << i)) != 0):
          count += 1
  return count

def isIn(i, A): # i가 A에 포함돼있는지 검사하는 메서드
  return ((A & (1 << (i - 2))) != 0)

def diff(A, j): # A에서 vj 를 빼주는 차집합 메서드
  t = 1 << (j - 2)
  return A & (~t)

def minimum(W, D, i, A):
  minValue = float('INF')
  minJ = 1
  n = len(W) - 1
  for j in range(2, n + 1):
      if isIn(j, A):
          m = W[i][j] + D[j][diff(A, j)]
          if minValue > m:
              minValue = m
              minJ = j
  return minValue, minJ

def travel(W, N):
  size = 2 ** (N-1) 
  D = [[0] * size for _ in range(N+1)] 
  P = [[0] * size for _ in range(N+1)]
  
  for i in range(2, N+1): # 2~n까지
      if W[i][1] == 0:
        D[i][0] = float('INF')
      else:
        D[i][0] = W[i][1] # i번 도시에서 1번 도시로 오는 길
          
  for k in range(1, N-1): # k개의 도시를 거치는 모든 경우의 수에 대해 
      for A in range(1, size): 
          if count(A, N) == k:
              for i in range(2, N + 1):
                  if not isIn(i, A):
                      D[i][A], P[i][A] = minimum(W, D, i, A)
  A = size - 1
  D[1][A], P[1][A] = minimum(W, D, 1, A)
  return D, P

N = int(input())
W = [[-1] * (N + 1)]
for _ in range(N):
    lists = [-1] + list(map(int, input().split()))
    # 0이 아닌 값을 float('inf')로 변경
    for i in range(1, N + 1):
        if lists[i] == 0:
            lists[i] = float('inf')
    W.append(lists)

    

D, P = travel(W, N)

print(D[1][2**(N-1) - 1])