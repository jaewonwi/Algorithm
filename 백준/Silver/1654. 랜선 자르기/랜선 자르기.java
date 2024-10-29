import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, K;    // 100만, >= 만
    static int[] lan;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lan = new int[K];
        for (int i = 0; i < K; i++){
            lan[i] = Integer.parseInt(br.readLine());
        }

        long left = 1;
        long right = Arrays.stream(lan).max().getAsInt();
        long mid = 0;
        while (left <= right){
            mid = (left + right)/2;

            if (getCnt(mid) >= N){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        System.out.println(left-1);
    }

    static long getCnt(long length){
        long sum = 0;
        for (int i = 0; i < K; i++){
            sum += lan[i] / length;
        }
        return sum;
    }
}