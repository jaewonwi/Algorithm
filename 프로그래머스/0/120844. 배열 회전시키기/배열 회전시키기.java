class Solution {
    static int[] numbers;
    public int[] solution(int[] nums, String direction) {
        numbers = nums;
        int n = nums.length;
        int[] answer = new int[n];
        if (direction.equals("right")){
            int temp = numbers[n-1];
            for (int i = n-1; i > 0; i--){
                answer[i] = numbers[i-1];
            }
            answer[0] = temp;
        } else {
            int temp = numbers[0];
            for (int i = 0; i < n-1; i++){
                answer[i] = numbers[i+1];
            }
            answer[n-1] = temp;
        }
        
        return answer;
    }
}