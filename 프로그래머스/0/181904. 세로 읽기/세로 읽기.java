class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        int length = my_string.length();
        char[][] arr = new char[length/m][m];
        
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                arr[i][j] = my_string.charAt(i*m+j);
            }
            answer += arr[i][c-1];
        }
        
        return answer;
    }
}