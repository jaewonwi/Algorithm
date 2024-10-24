class Solution {
    static int b, s, answer = 0;
    public int solution(int balls, int share) {
        b = balls;
        s = share;
        
        comb(0, 0);
        
        return answer;
    }
    
    static void comb(int idx, int cnt){
        if (cnt == s){
            answer++;
            return;
        }
        
        if (idx == b) return;
        
        comb(idx+1, cnt+1);
        comb(idx+1, cnt);
    }
}