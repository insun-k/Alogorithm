from collections import deque


n, m, k = map(int, input().split())
graph = [list(map(int, input())) for _ in range(n)]
visited = [[[0] * (k+1) for _ in range(m)] for _ in range(n)]
visited[0][0][0] = 1

queue = deque()
queue.append((0, 0, 0, 1))

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


while queue:
    x, y, z, day = queue.popleft()
    
    if x == n-1 and y == m-1:
        print(day)
        break
    
    count = day % 2 # 1이면 낮
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if 0 <= nx < n and 0 <= ny < m:
            # 벽이 아닌 경우
            if graph[nx][ny] == 0 and visited[nx][ny][z] == 0:
                queue.append((nx, ny, z, day + 1))
                visited[nx][ny][z] = day
                
            # 벽인 경우    
            if graph[nx][ny] == 1 and z < k and visited[nx][ny][z+1] == 0: 
                if count: #낮
                    visited[nx][ny][z+1] = day
                    queue.append((nx, ny, z+1, day + 1))
                else:
                    queue.append((x, y, z, day + 1))

else:
    print(-1)