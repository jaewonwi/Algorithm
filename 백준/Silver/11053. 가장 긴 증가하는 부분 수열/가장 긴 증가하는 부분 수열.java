import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++){
            for (int j = 0; j < i; j++){
                if (input[i] > input[j]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }

            dp[i]++;
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}