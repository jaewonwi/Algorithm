class Solution {
    public int[] solution(long n) {
        char[] chars = new StringBuffer(String.valueOf(n)).reverse().toString().toCharArray();
        int[] answer = new int[chars.length];
        for (int i = 0; i < answer.length; i++){
            answer[i] = chars[i] - '0';
        }
        return answer;
    }
}