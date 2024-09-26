import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, ans = 0;
    static int[] tgt;
    static boolean[] select;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tgt = new int[N];
        select = new boolean[N];

        nQueen(0);

        System.out.println(ans);
    }

    static void nQueen(int tgtIdx){
        if (tgtIdx == N){
            ans++;
            return;
        }

        for (int i = 0; i < N; i++){
            tgt[tgtIdx] = i;

            if (check(tgtIdx)){
                nQueen(tgtIdx + 1);
            }
        }
    }

    static boolean check(int tgtIdx){
        for (int i = 0; i < tgtIdx; i++){
            if (tgt[i] == tgt[tgtIdx] || (tgtIdx - i) == Math.abs(tgt[i] - tgt[tgtIdx])){
                return false;
            }
        }
        return true;
    }
}
