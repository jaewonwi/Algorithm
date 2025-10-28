class Solution {

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];

        // 물에 잠긴 지역을 -1로 마킹
        for (int[] loc : puddles) {
            dp[loc[1] - 1][loc[0] - 1] = -1;
        }

        dp[0][0] = 1; // 시작점 초기화

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 시작점 또는 물웅덩이는 건너뜀
                if ((i == 0 && j == 0) || dp[i][j] == -1) continue;

                // 위쪽 경로가 물웅덩이이면 0, 아니면 해당 값
                int top = (i == 0 || dp[i - 1][j] == -1) ? 0 : dp[i - 1][j];
                // 왼쪽 경로가 물웅덩이이면 0, 아니면 해당 값
                int left = (j == 0 || dp[i][j - 1] == -1) ? 0 : dp[i][j - 1];

                // 현재 위치의 경로 수 = 위쪽 + 왼쪽
                dp[i][j] = (top + left) % 1_000_000_007;
            }
        }

        return dp[n - 1][m - 1];
    }
}