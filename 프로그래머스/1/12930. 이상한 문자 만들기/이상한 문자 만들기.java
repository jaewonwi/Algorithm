class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if (c == ' '){
                answer += c;
                idx = 0;
            } else if (idx % 2 == 0){
                answer += Character.toUpperCase(c);
                idx++;
            } else {
                answer += Character.toLowerCase(c);
                idx++;
            }
        }
        
        return answer;
    }
}