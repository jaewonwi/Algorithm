import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] nums = new int[]{a,b,c,d};
        for (int n : nums){
            int cnt = map.getOrDefault(n, 0);
            map.put(n, cnt+1);
        }
        
        if (map.size()==1){
            return 1111 * a;
        } else if (map.size()==2){
            int t = a;
            for (int n : nums){
                if (t != n){
                    t = n;
                    break;
                }
            }
            int cnt1 = map.get(a);
            int cnt2 = map.get(t);
            
            if (cnt1 == cnt2){
                return (a + t) * Math.abs(a-t);   
            } else {
                if (cnt1 < cnt2){
                    int temp = a;
                    a = t;
                    t = temp;
                }
                return (int) Math.pow((10 * a + t), 2);
            }   
        } else if (map.size() == 4){
            int min = a;
            for (int n : nums){
                min = Math.min(min, n);
            }
            return min;
        } else {
            int q = 0, r = 0;
            for (int n : nums){
                if (map.get(n) == 2){
                    continue;
                } else if (q == 0){
                    q = n;
                } else {
                    r = n;
                }
            }
            
            return q * r;
        }
    }
}