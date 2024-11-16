# [BOJ-Gold5] 7569_토마토

from collections import deque


m, n, h = map(int, input().split())  # 가로 * 세로 * 높이
graph = [[list(map(int, input().split())) for _ in range(n)] for _ in range(h)]
visited = [[[False]*m for _ in range(n)] for _ in range(h)]

dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]


queue = deque()

def bfs():
    while queue:
        x, y, z = queue.popleft()
        
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            
            if 0 <= nx < h and 0 <= ny < n and 0 <= nz < m:
                if visited[nx][ny][nz] == False and graph[nx][ny][nz] == 0:
                    queue.append((nx, ny, nz))
                    graph[nx][ny][nz] = graph[x][y][z] + 1
                    visited[nx][ny][nz] = True
    

# 익은 토마토   
for i in range(h):
    for j in range(n):
        for k in range(m):
            if graph[i][j][k] == 1 and not visited[i][j][k]:
                queue.append((i,j,k))
                visited[i][j][k] = True
                
bfs()

# print(graph)


def check(graph):
    result = 0       
    for a in graph:
        for b in a:
            for c in b:
                if c == 0:
                    return -1
                if c > result:
                    result = c
    return result - 1

print(check(graph))
          
                
                
            