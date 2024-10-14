import java.io.*;
import java.util.*;

// 걸으면 X -> X+1 / X-1
// 순간이동 X -> 2 * X
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, K, ans;
    static Queue<Integer> queue = new ArrayDeque<>();
    static boolean[] visit;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ans = Integer.MAX_VALUE;
        visit = new boolean[100_001];
        System.out.println(bfs(N, K));
    }

    static int bfs(int N, int K){
        int minus = 0;
        int plus = 0;
        int mult = 0;

        visit[N] = true;
        queue.offer(N);

        int count = 0;
        while (true) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == K) return count;

                minus = cur - 1;
                plus = cur + 1;
                mult = cur * 2;

                if (minus >= 0 && !visit[minus]) {
                    visit[minus] = true;
                    queue.offer(minus);
                }

                if (plus <= 100_000 && !visit[plus]) {
                    visit[plus] = true;
                    queue.offer(plus);
                }

                if (mult <= 100_000 && !visit[mult]) {
                    visit[mult] = true;
                    queue.offer(mult);
                }
            }

            count++;

        }
    }
}
