import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                
                if (maps[nx][ny] == 1){
                    maps[nx][ny] = maps[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        
        if (maps[n-1][m-1] <= 1) return -1;
        else return maps[n-1][m-1];
    }
}
