class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        char[] chArr = my_string.toCharArray();
        for (char c : chArr){
            if (Character.isUpperCase(c)){
                answer[c-'A']++;
            } else {
                answer[c-'a'+26]++;
            }
        }
        return answer;
    }
}