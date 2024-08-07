// BOJ 11659. 구간 합 구하기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, i, j, sum, psum;
    static int[] num;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];

        int[] arr = new int[N+1];
        sum = 0;

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
            sum += num[i];
            arr[i+1] = sum;
        }

        for (int t = 0; t < M; t++){
            st = new StringTokenizer(br.readLine().trim());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());

            // 구간합 = 누적합끼리의 차이
            psum = arr[j] - arr[i-1];

            sb.append(psum).append("\n");
        }

        System.out.println(sb.toString());
    }
}
