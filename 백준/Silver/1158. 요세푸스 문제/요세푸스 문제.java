import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;    // 1 <= K <= N <= 5,000

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        sb.append("<");

        // 요세푸스 순열 구하기
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++){
            queue.offer(i);
        }

        int idx = 1;
        for (int i = 1; i < K; i++){
            queue.offer(queue.poll());
        }
        sb.append(queue.poll());

        while (!queue.isEmpty()){
            if (idx % K == 0){
                idx = 1;
                sb.append(", ").append(queue.poll());
                continue;
            }

            queue.offer(queue.poll());
            idx++;
        }

        sb.append(">");
        System.out.println(sb);
    }
}
