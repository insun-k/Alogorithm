# [BOJ-Silver1] 2667_단지번호붙이기
from collections import deque

n = int(input())
graph = []
for _ in range(n):
    graph.append(list(map(int, input())))
   
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def dfs(x,y):
    if x < 0 or x >= n or y < 0 or y >= n:
        return 0
    
    if graph[x][y] == 1:
        graph[x][y] = 0
        count = 1
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            count += dfs(nx, ny)
            
        return count
    
    return 0

result = []
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            result.append(dfs(i,j))
            
            
            
print(len(result))
result.sort()
for i in result:
    print(i)