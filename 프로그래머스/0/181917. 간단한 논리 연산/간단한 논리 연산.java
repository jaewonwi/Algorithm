class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean ans1 = false;
        boolean ans2 = false;
        boolean answer = true;
        if (x1 || x2){
            ans1 = true;
        }
        if (x3 || x4){
            ans2 = true;
        }
        
        if (!(ans1 && ans2)){
            answer = false;
        }
        
        return answer;
    }
}