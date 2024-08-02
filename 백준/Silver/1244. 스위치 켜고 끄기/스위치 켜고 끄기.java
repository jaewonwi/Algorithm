import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 1244. 스위치 켜고 끄기
public class Main {
    static int N, student;
    static int[] switches;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());

        switches = new int[N+1];

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 1; i <= N; i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }

        student = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < student; i++){
            st = new StringTokenizer(br.readLine().trim());

            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                // 남자 로직
                boy(num);
            } else {
                // 여자 로직
                girl(num);
            }
        }

        // 한 줄에 20개씩 스위치 출력하기
        for (int i = 1; i <= N; i ++){
            sb.append(switches[i]).append(" ");

            if (i % 20 == 0){
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());

    }

    static void boy(int n) {
        for (int i = n; i <= N; i += n){
            change(i);
        }
    }

    static void girl(int n) {
        change(n);

        int idx = 1;
        while (n - idx >= 1 && n + idx <= N) {
            if (switches[n - idx] == switches[n + idx]){
                change(n - idx);
                change(n + idx);
                idx++;
            } else
                break;

        }
    }

    static void change(int n) {
        if (switches[n] == 1)
            switches[n] = 0;
        else
            switches[n] = 1;
    }
}