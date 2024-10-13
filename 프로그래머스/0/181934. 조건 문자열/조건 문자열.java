class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        
        if (ineq.charAt(0) == '>'){
            if (eq.charAt(0) == '=') answer = n >= m ? 1 : 0;
            else answer = n > m ? 1 : 0;
        } else {
            if (eq.charAt(0) == '=') answer = n <= m ? 1 : 0;
            else answer = n < m ? 1 : 0;           
        }    
        
        return answer;
    }
}