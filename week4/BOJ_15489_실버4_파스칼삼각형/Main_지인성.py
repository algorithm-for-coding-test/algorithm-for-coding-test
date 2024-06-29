R, C, W = map(int, input().split())

squares = [[1], [1,1]]


for i in range(2, R+W):
    graph=[]
    
    for j in range(i+1):     
        if j == 0:
            graph.append(1)
            
        elif j == i:
            graph.append(1)
            
        else:
            graph.append(squares[i-1][j-1]+squares[i-1][j])
            
    squares.append(graph)

answer = 0


for i in range(W):
    for j in range(i + 1):
        answer += squares[R - 1 + i][C - 1 + j]
        

    
print(answer)