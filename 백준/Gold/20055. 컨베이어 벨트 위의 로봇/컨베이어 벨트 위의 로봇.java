import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static int[] A;
    public static void main(String[] args) throws Exception{
        // 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int size = 2*N;
        A = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Robot> q = new ArrayDeque<>();
        boolean[] robot = new boolean[size];
        int start = 0;
        int end = N-1;
        int stage = 0;
        int k = 0;
        while (k < K){
            stage++;
            // 1. 한 칸 회전
            start = (start - 1 + size) % size;
            end = (end - 1 + size) % size;
            if (robot[end])
                robot[end] = false;

            // 2. 가장 먼저 올라간 로봇부터 회전 방향으로 한 칸 이동 (못하면 그냥 있기)
            // - 이동하려는 칸에 로봇 X, 내구도 1 이상 남아있어야 함
            int qSize = q.size();
            for (int i = 0; i < qSize; i++){
                Robot cur = q.poll();
                int next = (cur.idx+1) % size;
                if (cur.idx == end) continue;       // 현재 로봇이 내리는 칸에 있다면
                if (A[next] >= 1 && !robot[next]){  // 다음 칸으로 이동
                    A[next]--;
                    if (A[next] == 0) k++;  // 이동한 칸의 내구도가 0이되었다면
                    robot[cur.idx] = false;
                    robot[next] = true;

                    if (next == end) {  // 이동한 칸이 내리는 칸이라면
                        robot[next] = false;
                        continue;
                    }
                    q.offer(new Robot(next));   // 무사히 이동 완료했다면
                } else {
                    q.offer(new Robot(cur.idx));
                }
            }

            // 3. 올리는 위치(1번 칸)에 있는 칸의 내구도가 0이 아니면 로봇 올림(즉시 1 감소)
            if (A[start] >= 1){
                q.offer(new Robot(start));
                A[start]--;
                if (A[start] == 0) k++; // 이동한 칸의 내구도가 0이되었다면
                robot[start] = true;
            }

            // 4. 내구도가 0인 칸의 개수가 K 개 이상이면 종료 / 반복
            if (k >= K) break;
        }

        System.out.println(stage);
    }

    public static class Robot{
        int idx;
        public Robot(int idx){
            this.idx = idx;
        }
    }
}