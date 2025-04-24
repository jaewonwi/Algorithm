import java.util.*;
class Solution {
    public int solution(String numbers) {
        int[] cnt = new int[10];
        for (int i = 0; i < numbers.length(); i++){
            int j = numbers.charAt(i) - '0';
            cnt[j]++;
        }
        System.out.println(Arrays.toString(cnt));
        // boolean[] flag = new boolean[10_000_000];
        int answer = 0;
        String maxS = "";
        for (int i = 9; i >= 0; i--){
            if (cnt[i] != 0){
                for (int j = 0; j < cnt[i]; j++)
                    maxS += String.valueOf(i);
            }
        }
        int max = Integer.parseInt(maxS);
        
        for (int i = 1; i <= max; i++){
            if (isPrime(i) && canMake(i, cnt)){
                answer++;
            }
        }
        
        return answer;
    }
    
    static boolean canMake(int n, int[] arr){
        String s = String.valueOf(n);
        int[] cnt = new int[10];
        for (int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - '0';
            if (++cnt[c] > arr[c]) return false;
        }
        return true;
    }
    
    static boolean isPrime(int n){
        if (n == 1) return false;
        
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}