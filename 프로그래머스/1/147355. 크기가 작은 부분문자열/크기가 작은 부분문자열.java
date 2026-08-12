class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tlen = t.length();
        int plen = p.length();
        for (int i = 0; i <  tlen - plen + 1; i++){
            String temp = t.substring(i, i + plen);
            
            boolean flag = true;
            for (int j = 0; j < plen; j++){
                if (temp.charAt(j) > p.charAt(j)) {
                    flag = false;
                    break;
                } else if (temp.charAt(j) < p.charAt(j))
                    break;
            }
            
            if (flag) {
                answer++;
            }
        }
        
        return answer;
    }
}