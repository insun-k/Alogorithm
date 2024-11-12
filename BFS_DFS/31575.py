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

        for i in range(2):
            nx = x + dx[i]
            ny = y + dy[i]

            if (nx < 0 or ny < 0 or nx >= m or ny >= n):
                continue
            if graph[nx][ny] == 0:
                continue
            
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))

    return graph[m-1][n-1]
    

result = bfs(0,0)
if result > 1:
    print("Yes")
else:
    print("No")