import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long M = Long.parseLong(br.readLine());

        int left = 1;
        int right = Arrays.stream(arr).max().getAsInt();

        int mid = 0;
        while (left <= right){
            mid = (left+right)/2;

            if (getSum(arr, mid) <= M){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        System.out.println(left-1);

    }

    static long getSum(int[] arr, int budget){
        long sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i] >= budget ? budget : arr[i];
        }
        return sum;
    }
}
