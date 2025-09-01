import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        if (N % 5 == 0){
            System.out.println(N/5);
        } else {
            int cnt = 0;
            while (N >= 0){
                N -= 3;
                cnt++;
                if (N % 5 == 0){
                    System.out.println(cnt + N/5);
                    break;
                }
            }
            if (N < 0){
                System.out.println(-1);
            }
        }
    }
}