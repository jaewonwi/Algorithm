import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        int n = park.length;
        int m = park[0].length;
        int[][] ans = new int[n][m];
        Arrays.sort(mats);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (!park[i][j].equals("-1")) continue;
                
                ans[i][j] = check(i, j, mats, park);   
                answer = Math.max(answer, ans[i][j]);
            }
        }
        
        return answer == 0 ? -1 : answer;
    }
    
    static int check(int si, int sj, int[] mats, String[][] park){
        for (int k = mats.length - 1; k >= 0; k--){
            int len = mats[k];
            boolean flag = true;
            for (int i = 0; i < len; i++){
                for (int j = 0; j < len; j++){
                    if ((si+i) >= park.length || (sj+j) >= park[0].length) {
                        flag = false;
                        break;
                    }
                    
                    if (!park[si+i][sj+j].equals("-1")){
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) return len;
        }
        return 0;
    }
}