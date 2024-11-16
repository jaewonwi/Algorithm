import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        
        boolean[][] visit = new boolean[n][m];
        int[] result = new int[m];
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (land[i][j] == 1 && !visit[i][j]){
                    bfs(land, i, j, visit, result);
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < m; i++){
            answer = Math.max(result[i], answer);
        }
        return answer;
    }
    
    public void bfs(int[][] land, int i, int j, boolean[][] visit, int[] result){
        int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};
        boolean[] temp = new boolean[land[0].length];
        int cnt = 1;
        
        Queue<int[]> q = new ArrayDeque<>();
        visit[i][j] = true;
        q.offer(new int[]{i, j});
        temp[j] = true;
        
        while (!q.isEmpty()){
            int[] cur = q.poll();
            
            for (int d = 0; d < 4; d++){
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];
                
                if (ny < 0 || nx < 0 || ny >= land.length || nx >= land[0].length || visit[ny][nx] || land[ny][nx] == 0) continue;
                
                visit[ny][nx] = true;
                q.offer(new int[]{ny, nx});
                temp[nx] = true;
                cnt++;
            }
        }
        
        for (int k = 0; k < land[0].length; k++){
            if (temp[k]) 
                result[k] += cnt;
        }
    }
}