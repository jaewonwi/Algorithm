class Solution {
    public int solution(int n) {
        boolean[] flag = new boolean[n+1];
        for (int i = 2; i <= Math.sqrt(n); i++){
            int j = i;
            while (j <= n){
                j += i;
                if (j <= n)
                    flag[j] = true;
            }
        }
        
        int answer = 0;
        for (int i = 0; i <= n; i++){
            if (flag[i])
                answer++;
        }
        return answer;
    }
}