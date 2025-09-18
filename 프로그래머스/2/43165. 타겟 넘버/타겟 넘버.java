class Solution {
    int N, cnt = 0, target;
    int[] numbers;
    boolean[] flag;
    public int solution(int[] nums, int tgt) {
        numbers = nums;
        target = tgt;
        N = numbers.length;
        flag = new boolean[N];
        
        dfs(0, 0);
        
        return cnt;
    }
    
    void dfs(int idx, int sum){
        if (idx == N){
            if (sum == target)  cnt++;
            
            return;
        }
        
        flag[idx] = true;
        dfs(idx+1, sum + numbers[idx]);
        flag[idx] = false;
        dfs(idx+1, sum - numbers[idx]);
    }
}