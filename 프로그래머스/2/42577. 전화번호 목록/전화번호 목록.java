import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        Arrays.sort(phone_book, (n1, n2) -> n2.length() - n1.length());
        // set에 전화번호 전체 집어넣기
        for (String phone : phone_book){    // 최대 100만
            if (set.contains(phone)){
                return false;
            }
            
            for (int i = 1; i < phone.length(); i++){
                set.add(phone.substring(0,i));
                // System.out.println("+ "+phone.substring(0,i));
            }
        }
        
        return true;
    }
}