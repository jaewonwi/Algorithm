
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = N-1;
            boolean flag = false;
            while (left <= right){
                int mid = (left + right) / 2;

                if (A[mid] == num){
                    flag = true;
                    break;
                } else if (A[mid] < num) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }

            if (flag) System.out.println(1);
            else System.out.println(0);
        }

    }
}
