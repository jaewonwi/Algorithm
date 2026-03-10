import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, K;
    static int[] A;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];

        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        for (int i = N-1; i >= 0; i--){
            if (K == 0) break;

            int value = A[i];
            if (value > K) continue;

            ans += K / value;
            K %= value;
        }

        System.out.println(ans);
    }
}