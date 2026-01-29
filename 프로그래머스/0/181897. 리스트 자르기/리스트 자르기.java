import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};
        if (n == 1){
            answer = Arrays.copyOf(num_list, slicer[1]+1);
        } else if (n == 2){
            answer = Arrays.copyOfRange(num_list, slicer[0], num_list.length);
        } else if (n == 3){
            answer = Arrays.copyOfRange(num_list, slicer[0], slicer[1]+1);
        } else if (n == 4){
            List<Integer> aList = new ArrayList<>();
            for (int i = slicer[0]; i <= slicer[1]; i += slicer[2]){
                aList.add(num_list[i]);
            }
            answer = aList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        }
        
        return answer;
    }
}