class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n+2];  // 0 dummy
        for (int i = 0; i < lost.length; i++){  // -1 잃어버린 애들
            student[lost[i]]--;
        }
        for (int i = 0; i < reserve.length; i++){  // 1 체육복 여분 있는 애들
            student[reserve[i]]++;
        }
        
        for (int i = 0; i <= n; i++){
            if (student[i] >= 0) continue;
            
            int left = i - 1;
            int right = i + 1;
            
            if (student[left] == 1){
                student[left]--;
                student[i]++;
            } else if (student[right] == 1){
                student[right]--;
                student[i]++;
            }
        }
        
        int ans = 0;
        for (int i = 1; i <= n; i++){
            if (student[i] >= 0) ans++;
        }
        
        return ans;
    }
}