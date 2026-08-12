class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if (!(s.length() == 4 || s.length() == 6)) {
            answer = false;
            System.out.println("false");
        }
        
        for (char c : s.toCharArray()){
            System.out.println(c);
            if (c >= '0' && c <= '9') continue;
            else {
                answer = false;
                break;
            }
        }
        return answer;
    }
}