import java.util.*;

class Solution {
    public int solution(String my_string, String is_suffix) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < my_string.length(); i++){
            set.add(my_string.substring(i));
        }
        return set.contains(is_suffix) ? 1 : 0;
    }
}