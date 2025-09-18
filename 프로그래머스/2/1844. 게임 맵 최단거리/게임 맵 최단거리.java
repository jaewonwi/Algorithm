import java.util.*;

class Solution {
    int n, m, answer = Integer.MAX_VALUE;
    int[] dr = {0,0,1,-1}, dc = {1,-1,0,0}; // 동서남북
    public int solution(int[][] maps) { // 0: 벽, 1: 빈칸
        n = maps.length;
        m = maps[0].length;
        bfs(maps);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    void bfs(int[][] maps){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][m];
        
        q.offer(new int[]{0,0,0});  // r,c,cnt
        visit[0][0] = true;
        
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int cnt = cur[2];
            if (r == n-1 && c == m-1){
                answer = Math.min(answer, cnt+1);
            }
            
            for (int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if (!isMap(nr,nc) || visit[nr][nc] || maps[nr][nc] == 0) continue;
                
                visit[nr][nc] = true;
                q.offer(new int[]{nr,nc,cnt+1});
            }    
        }
    }
    
    boolean isMap(int r, int c){
        if (r < 0 || r >= n || c < 0 || c >= m) return false;
        return true;
    }
}