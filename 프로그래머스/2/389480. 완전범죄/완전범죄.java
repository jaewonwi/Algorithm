class Solution {
    public int solution(int[][] info, int n, int m) {
        // A [i][0]에, B는 [i][1]에 흔적을 남김. (1~3)
        // 모든 물건을 훔쳤을 때,
        // A 도둑이 남긴 흔적의 누적 개수의 최솟값
        // 완전 탐색 -> 시간초과 -> DP 풀이
        // dp[a][b] = A가 a만큼, B가 b만큼 흔적을 남기는 상태가 가능한가?

        boolean[][] dp = new boolean[n][m];
        dp[0][0] = true;
        
        for (int[] item : info){
            int a = item[0];
            int b = item[1];
            boolean[][] next = new boolean[n][m];
            
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (!dp[i][j]) continue;
                    
                    if (i+a < n) next[i+a][j] = true;
                    if (j+b < m) next[i][j+b] = true;
                }
            }
            
            dp = next;
        }
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                 if (dp[i][j]) return i;
            }
        }
        
        return -1;
    }
}