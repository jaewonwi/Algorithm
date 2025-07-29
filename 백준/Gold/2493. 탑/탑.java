import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] tower, recieve;
    public static void main(String[] args) throws Exception{
        // 오 -> 왼 레이저 발사
        // 레이저 수신: 가장 먼저 만나는 하나의 탑에서만 수신 가능
        N = Integer.parseInt(br.readLine());
        tower = new int[N+1];
        recieve = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            tower[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = N; i >= 1; i--){
            boolean flag = true;
            while (flag) {
                if (stack.isEmpty()) {
                    stack.push(i);
                    flag = false;
                    continue;
                }

                int prev = tower[stack.peek()];
                int cur = tower[i];
                if (prev < cur){
                    recieve[stack.pop()] = i;
                } else {
                    stack.push(i);
                    flag = false;
                }
            }
        }

        while (!stack.isEmpty()){
            recieve[stack.pop()] = 0;
        }

        for (int i = 1; i <= N; i++){
            sb.append(recieve[i]).append(" ");
        }
        System.out.print(sb);
    }
}