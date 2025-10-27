import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static int[] input;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());   // 10000
        N = Integer.parseInt(st.nextToken());   // 100_0000
        input = new int[K];
        for (int i = 0; i < K; i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        long left = 1;
        long right = Arrays.stream(input).max().getAsInt();
        while (left <= right){
            long mid = (left+right)/2;

            if (getCnt(mid) < N){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        System.out.println(right);
    }

    static int getCnt(long len){
        int cnt = 0;
        for (int i = 0; i < K; i++){
            cnt += input[i] / len;
        }
        return cnt;
    }
}