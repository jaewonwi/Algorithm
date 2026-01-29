import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {-1};
        
        int left = 0;
        int right = arr.length-1;
        boolean lFlag = false, rFlag = false;
        while ((!lFlag || !rFlag) && left <= right) {
            if (!lFlag){
                if (arr[left] == 2){
                    lFlag = true;
                    System.out.println("left: "+left);
                    continue;
                }
                left++;
            }
            
            if (!rFlag){
                if (arr[right] == 2){
                    rFlag = true;
                    continue;
                }
                right--;
            }
        }
        
        System.out.println(left+" , "+right);
        if (left > right){
            return answer;
        }
        
        answer = Arrays.copyOfRange(arr, left, right+1);
        return answer;
    }
}