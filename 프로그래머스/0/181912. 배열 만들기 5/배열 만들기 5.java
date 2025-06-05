import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();
        for (String str : intStrs){
            String cut = str.substring(s, s+l);
            if (Integer.parseInt(cut) > k)
                list.add(Integer.parseInt(cut));
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}