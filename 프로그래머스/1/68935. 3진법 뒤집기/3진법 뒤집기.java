class Solution {
    static StringBuilder sb = new StringBuilder();
    public int solution(int n) {
        String cur = "";
        while (n > 0){          // 10 -> 3 진법 변환
            cur = (n % 3) + cur;
            n /= 3;
        }
        cur = sb.append(cur).reverse().toString();  // 뒤집기
        
        return Integer.parseInt(cur, 3);    // 3진법 문자열을 10진법 int로 변환
    }
}