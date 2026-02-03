import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = {};
        int[] before = Arrays.copyOfRange(num_list, 0, n);
        int[] after = Arrays.copyOfRange(num_list, n, num_list.length);
        return IntStream.concat(Arrays.stream(after), Arrays.stream(before)).toArray();
    }
}