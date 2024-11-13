# [BOJ-Sliver3] 31575_도시와 비트코인

from collections import deque

n, m = map(int, input().split())
graph = []
for i in range(m):
    graph.append(list(map(int, input().split())))

# 우 하
dx = [0, 1]
dy = [1, 0]

def bfs(x,y):
    queue = deque()
    queue.append((x,y))

    while queue:
        x, y = queue.popleft()

        if (x == m - 1) & (y == n - 1):
            return True

        for i in range(2):
            nx = x + dx[i]
            ny = y + dy[i]

            if (nx < 0 or ny < 0 or nx >= m or ny >= n):
                continue
            if graph[nx][ny] == 0:
                continue
            
            if graph[nx][ny] == 1:
                graph[nx][ny] = 2
                queue.append((nx, ny))
    return False
    

if bfs(0,0):
    print("Yes")
else:
    print("No")