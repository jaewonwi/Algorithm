class Solution {
    int N, cnt = 0, target;
    int[] numbers;
    boolean[] flag;
    public int solution(int[] nums, int tgt) {
        numbers = nums;
        target = tgt;
        N = numbers.length;
        flag = new boolean[N];
        
        dfs(0);
        
        return cnt;
    }
    
    void dfs(int idx){
        if (idx == N){
            int sum = 0;
            for (int i = 0; i < N; i++){
                if (flag[i]){
                    sum += numbers[i];
                } else {
                    sum -= numbers[i];
                }
            }
            if (sum == target)  cnt++;
            
            return;
        }
        
        flag[idx] = true;
        dfs(idx+1);
        flag[idx] = false;
        dfs(idx+1);
    }
}