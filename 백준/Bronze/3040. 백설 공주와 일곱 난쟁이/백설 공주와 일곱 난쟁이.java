import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int diff, ans;
    static int[] dwarfs, select;

    public static void main(String[] args) throws Exception{
        dwarfs = new int[9];

        // 입력
        for (int i = 0; i < 9; i++){
            dwarfs[i] = Integer.parseInt(br.readLine());
        }

        diff = Arrays.stream(dwarfs).sum() - 100;
        select = new int[2];

        subset(0, 0);
    }

    static void subset(int idx, int cnt){
        if (cnt == 2){
            if (diff != Arrays.stream(select).sum())
                return;

            // 출력
            for (int i = 0; i < 9; i++){
                if (dwarfs[i] == select[0] || dwarfs[i] == select[1])
                    continue;
                System.out.println(dwarfs[i]);
            }

            return;
        }

        if (idx == 9)
            return;

        select[cnt] = dwarfs[idx];
        subset(idx+1, cnt+1);
        subset(idx+1, cnt);
    }

}