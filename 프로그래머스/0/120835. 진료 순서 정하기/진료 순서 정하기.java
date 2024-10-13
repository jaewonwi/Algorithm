import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int size = emergency.length;
        int[] answer = new int[size];
        for (int i = 0; i < size; i++){
            answer[i] = emergency[i];
        }
        
        Arrays.sort(emergency);
        // System.out.println("answer: "+Arrays.toString(answer));
        // System.out.println("emergency: "+Arrays.toString(emergency));
        for (int i = 0; i < size; i++){
            answer[i] = size - Arrays.binarySearch(emergency, answer[i]);
        }
        // System.out.println(Arrays.toString(answer));
        return answer;
    }
}