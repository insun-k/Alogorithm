# [BOJ-Silver1] 2468_안전 영역

from collections import deque

n = int(input())
graph = []
min_value = 100
max_value = 1

for _ in range(n):
    row = list(map(int, input().split()))
    graph.append(row)
    min_value = min(min_value, min(row))
    max_value = max(max_value, max(row))
  

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]  

def bfs(x, y, num):
    q = deque()
    visited[x][y] = True
    q.append((x,y))
    
    while q:
        x, y = q.popleft()
            
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if (0 <= nx < n and 0 <= ny < n) and not visited[nx][ny]:
                if graph[nx][ny] > num:
                    visited[nx][ny] = True
                    q.append((nx, ny))
                    
    return 1

max_count = 1
for num in range(min_value, max_value + 1):
    count = 0
    visited = [[False] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if graph[i][j] > num and not visited[i][j]:
                count += bfs(i,j, num)

    if max_count <= count:
        max_count = count
        
print(max_count)