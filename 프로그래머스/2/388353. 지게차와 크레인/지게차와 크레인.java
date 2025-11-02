import java.util.*;
class Solution {
    int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};
    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        int answer = n * m;
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                arr[i][j] = storage[i].charAt(j);   
            }
        }
        
        for (int i = 0; i < requests.length; i++){
            String request = requests[i];
            int order = request.length();
            char alphavet = request.charAt(0);
            
            if (order == 1){
                answer -= findOuter(alphavet, arr, n, m);
            } else {
                answer -= findInner(alphavet, arr, n, m);
            }
        }
        return answer;
    }
    
    public int findOuter(char c, char[][] arr, int n, int m){
        Queue<int[]> q = new ArrayDeque<>();
    
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                // 가장자리라면
                if (i == 0 || j == 0 || i == (n-1) || j == (m-1)){
                    if (arr[i][j] == c){
                        q.offer(new int[]{i,j});
                    }
                    continue;
                }

                if (arr[i][j] != c) continue;
                boolean[][] visit = new boolean[n][m];
                if (dfs(i,j,arr,n,m, visit)){
                    q.offer(new int[]{i,j});
                }
            }
        }
        
        int result = q.size();
        while (!q.isEmpty()){
            int[] pos = q.poll();
            arr[pos[0]][pos[1]] = '.';
        }
        return result;
    }
    
    public boolean dfs(int i, int j, char[][] arr, int n, int m, boolean[][] visit){
        if (i == 0 || j == 0 || i == n-1 || j == m-1)   // 가장자리에 도달했다면
            return true;
        
        visit[i][j] = true;
        for (int d = 0; d < 4; d++){
            int ny = i + dy[d];
            int nx = j + dx[d];

            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if (visit[ny][nx]) continue;    
            
            if (arr[ny][nx] == '.'){
                if (dfs(ny, nx, arr, n, m, visit)) {
                    return true; // 재귀에서 경로를 찾으면 즉시 true 전파
                }
            }
        }
        
        return false;
    }
    
    public int findInner(char c, char[][] arr, int n, int m){
        int cnt = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (arr[i][j] == c) {
                    arr[i][j] = '.';
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    public void print(char[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j]);
            }    
            System.out.println();
        }
        System.out.println();
    }
}