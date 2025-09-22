import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, N, ans;
    static int[][] S;
    static boolean[] select;
    public static void main(String[] args) throws Exception{
        // A와 B의 맛 = sum(Sij) 차이가 최소가 되는 경우와 그 최솟값 찾기
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            S = new int[N][N];
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++){
                    S[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = Integer.MAX_VALUE;
            select = new boolean[N];
            comb(0,0);

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static void comb(int idx, int cnt){
        if (idx == N){
            if (cnt == N/2){
                ans = Math.min(diff(), ans);
                return;
            }
            return;
        }

        select[idx] = true;
        comb(idx+1, cnt+1);
        select[idx] = false;
        comb(idx+1, cnt);
    }

    static int diff(){
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < N; i++){
            for (int j = i+1; j < N; j++){
                if (select[i] && select[j]){
                    sumA += S[i][j] + S[j][i];
                } else if (!select[i] && !select[j]){
                    sumB += S[i][j] + S[j][i];
                }
            }
        }

        // System.out.println("A: "+sumA+", B: "+sumB);
        return Math.abs(sumA-sumB);
    }
}