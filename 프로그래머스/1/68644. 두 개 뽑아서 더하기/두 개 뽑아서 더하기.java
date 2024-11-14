import java.util.*;

class Solution {
    HashSet<Integer> answer = new HashSet<>();
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] tgt = new int[2];
        boolean[] select = new boolean[n];
        
        comb(0, 0, n, numbers, tgt, select);
        
        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public void comb(int tgtIdx, int srcIdx, int n, int[] numbers, int[] tgt, boolean[] select){
        if (tgtIdx == 2){
            int sum = tgt[0] + tgt[1];
            answer.add(sum);
            // System.out.println(tgt[0]+" "+tgt[1]);
            return;
        }
        
        if (srcIdx == n) return;        

        tgt[tgtIdx] = numbers[srcIdx];
        select[srcIdx] = true;
        comb(tgtIdx+1, srcIdx+1, n, numbers, tgt, select);
        comb(tgtIdx, srcIdx+1, n, numbers, tgt, select);
        
    }
}

