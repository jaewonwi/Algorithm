import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] nums;
    public static void main(String[] args) throws Exception{
        for (int tc = 1; tc <= 10; tc++){
            br.readLine();
            sb.append("#").append(tc).append(" ");

            st = new StringTokenizer(br.readLine());
            nums = new int[8];
            for (int i = 0; i < 8; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            sol();


        }
        System.out.println(sb);
    }

    static void sol(){
        int idx = 0;
        int minus = 1;
        while (true){
            nums[idx] -= minus;
            if (nums[idx] <= 0){
                nums[idx] = 0;
                break;
            }
            idx = (idx + 1) % 8;
            minus = minus == 5 ? 1 : minus + 1;
        }

        for (int i = 1; i <= 8; i++){
            sb.append(nums[(idx + i)%8]).append(" ");
        }
        sb.append("\n");
    }
}