import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, ans;
    static List<Point> house = new ArrayList<>();
    static List<Point> chicken = new ArrayList<>();

    static int[] select;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());

        // 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++){
                int n = Integer.parseInt(st.nextToken());
                if (n == 1){
                    house.add(new Point(i, j));
                } else if (n == 2){
                    chicken.add(new Point(i, j));
                }
            }
        }

        // 치킨집 M개만 선택
        select = new int[M];
        // 선택한 치킨집을 돌면서 각 집의 치킨거리 구하기
        ans = Integer.MAX_VALUE;
        subset(0, 0);

        System.out.println(ans);

    }
    static int cal(int idx){
        int min = 1000;
        int r1 = house.get(idx).r;
        int c1 = house.get(idx).c;
        for (int i = 0; i < M; i++){
            int r2 = chicken.get(select[i]).r;
            int c2 = chicken.get(select[i]).c;

            min = Math.min(min, Math.abs(r1-r2) + Math.abs(c1-c2));
        }
        return min;
    }

    static void subset(int idx, int cnt){
        if (cnt == M){
//            System.out.println(Arrays.toString(select));

            // 각 집의 치킨거리 계산
            int sum = 0;
            for (int i = 0; i < house.size(); i++){
                sum += cal(i);
            }
            // 최솟값 갱신
            ans = Math.min(ans, sum);

            return;
        }

        if (idx == chicken.size())
            return;

        select[cnt] = idx;
        subset(idx+1, cnt+1);
        subset(idx+1, cnt);
    }

    static class Point {
        int r, c;

        private Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}