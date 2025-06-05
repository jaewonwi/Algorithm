import java.util.*;

class Solution {
    public List<String> solution(String my_string) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < my_string.length(); i++){
            list.add(my_string.substring(i, my_string.length()));
        }        
        list.sort((o1, o2) -> o1.compareTo(o2));    // 문자열 오름차순 정렬
        return list;
    }
}