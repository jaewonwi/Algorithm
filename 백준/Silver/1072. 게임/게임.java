import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static long X, Y;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        int Z = getPercent(0);    // 현재 승률

        long start = 1;
        long end = X;

        long mid = 0;
        while (start <= end){
            mid = (start + end) / 2;
            int per = getPercent(mid);

            if (per <= Z){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        long answer = start > X ? -1 : start;
        System.out.println(answer);
        
    }

    public static int getPercent(long cnt){
        return (int) Math.floor((Y+cnt) * 100 / (X+cnt));   // 원래라면 0.xxxxx... -> xx.xxxx로 바꾸고 소수점 버림
    }
}
