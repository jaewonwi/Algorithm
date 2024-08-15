import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// N 개의 높이가 서로다른 탑을 왼->오로 세운다.
// 탑의 꼭대기에서 수평 왼쪽으로 레이저 발사. 탑의 기둥에 레이저 신호 수신
// 가장 먼저 만나는 단 하나의 탑에서만 수신 가능
public class Main {
    static int N;
    static int[] tower, answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        tower = new int[N+1];
        answer = new int[N+1];
        for (int i = 1; i <= N; i++){
            tower[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = N; i >= 1; i--){
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            // 스택에서 꺼낸 애랑 현재 보고 있는 애 비교
            boolean flag = true;
            while (flag) {
                if (stack.isEmpty()) {
                    stack.push(i);
                    flag = false;
                    continue;
                }

                int prev = tower[stack.peek()];
                int cur = tower[i];
                if (prev < cur) {   // 꺼내기
                    answer[stack.pop()] = i;
                } else if (prev > cur) {    // 넣기
                    stack.push(i);
                    flag = false;
                }
            }


        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = 0;
        }

        for (int i = 1; i <= N; i++) sb.append(answer[i]).append(" ");

        System.out.println(sb);
    }
}
