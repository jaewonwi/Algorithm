import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, ans = Integer.MAX_VALUE;
    static int[][] map;
    static List<Pos> home, chicken;
    static int[] select;
    public static void main(String[] args) throws Exception{
    	// 빈칸 0, 집 1 (1 <= <= 2N), 치킨집 2 (M <= <= 13)
		// (1,1) ~ (N,N)

		// 도시의 치킨거리 = 모든 집의 치킨 거리의 합 = 각각의 집에서 가장 가까운 치킨집까지 맨해튼 거리의 합
		// 가장 수익을 많이 낼 수 있는 치킨집 M개 제외 폐점

        // 최대 M개의 치킨집만 남겨놓을 때, 도시의 치킨거리의 최솟값
        // 1. 입력받기 - 치킨집 List, 집 List
        // 2. 남겨놓을 치킨집 선택(조합) - 1개 ~ M개
        // 3. 계산 및 갱신

        // 1. 입력받기
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;

                if (n == 1){
                    home.add(new Pos(i,j));
                } else if (n == 2){
                    chicken.add(new Pos(i,j));
                }
            }
        }

        // System.out.println("home : "+home.size()+"개, chicken: "+chicken.size()+"개");
        select = new int[M];
        // 2. 남겨놓을 치킨집 선택
        comb(0, 0);

        System.out.println(ans);
    }

    public static void comb(int idx, int cnt){
        if (cnt == M){
            // 3. 계산
            int sum = 0;
            for (int i = 0; i < home.size(); i++){
                int dist = Integer.MAX_VALUE;
                Pos hp = home.get(i);
                for (int j = 0; j < select.length; j++){
                   int k = select[j];
                    Pos cp = chicken.get(k);
                    dist = Math.min(dist, Math.abs(hp.y - cp.y) + Math.abs(hp.x - cp.x));
                }
                sum += dist;
                if (sum > ans) break;
            }
            ans = Math.min(sum, ans);
            return;
        }

        if (idx == chicken.size()) return;

        select[cnt] = idx;
        comb(idx+1, cnt+1);
        comb(idx+1, cnt);
    }

    public static class Pos{
        int y, x;
        public Pos(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}