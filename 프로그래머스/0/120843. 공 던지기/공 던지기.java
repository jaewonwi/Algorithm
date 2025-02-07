class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int cnt = 1;
        while (cnt < k){
            answer = (answer + 2 + numbers.length) % numbers.length; 
            cnt++;
        }
        return numbers[answer];
    }
}