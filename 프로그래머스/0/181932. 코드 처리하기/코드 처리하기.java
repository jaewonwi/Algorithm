class Solution {
    public String solution(String code) {
        int mode = 0;
        String ret = "";
        for (int i = 0; i < code.length(); i++){
            char ch = code.charAt(i);
            if (ch == '1'){
                mode = mode == 0 ? 1 : 0;
                continue;
            };
            
            
            if (mode == 0){
                if (i % 2 == 0) ret += ch;
            } else {
                if (i % 2 == 1) ret += ch;
            }
        }
        
        
        String answer = (ret == "") ? "EMPTY" : ret;
        return answer;
    }
}