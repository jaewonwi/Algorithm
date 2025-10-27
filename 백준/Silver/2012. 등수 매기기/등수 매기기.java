import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        for (int i = 0; i < N; i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(input);
        long sum = 0;
        for (int i = 1; i <= N; i++){
            sum += cal(input[i-1], i);
        }

        System.out.println(sum);

    }

    public static int cal(int or, int real){
        return Math.abs(or - real);
    }
}