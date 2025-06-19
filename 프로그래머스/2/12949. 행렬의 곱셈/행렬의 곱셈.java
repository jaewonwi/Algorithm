class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 행렬의 곱 (nxm)*(mxl) = (nxl)
        int n = arr1.length;
        int m = arr2.length;
        int l = arr2[0].length;
        int[][] answer = new int[n][l];
        for (int i = 0; i < n; i++){
            for (int k = 0; k < l; k++){
                for (int j = 0; j < m; j++){   // arr1의 모든 원소에 대해
                    answer[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }
        return answer;
    }
}