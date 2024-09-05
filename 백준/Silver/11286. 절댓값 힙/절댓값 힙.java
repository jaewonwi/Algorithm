import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 배열에 정수 x 삽입 (-2^31 < x < 2^31  ==> int 범위 내)
    // 절댓값이 가장 작은 값을 출력 후, 제거 (같은 절댓값이 여러개일 경우 가장 작은 수 출력)
    static int N, x;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(
            // ** 우선순위 큐 comparator lambda식으로 설정하기
            // ** 2가지를 고려해야하는 경우 삼항연산자 사용하기
            // 절댓값 기준으로 오름차순 정렬하되, |n1| == |n2| 이면 값 기준 오름차순 정렬
            (n1, n2) -> Math.abs(n1) == Math.abs(n2) ? n1 - n2 : Math.abs(n1) - Math.abs(n2)
    );

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){
            // x == 0 -> 절댓값이 가장 작은 값 출력 후 제거
            // x != 0 -> 삽입
            x = Integer.parseInt(br.readLine());
            if (x == 0){
                Integer min = pq.poll();
                System.out.println(min == null ? 0 : min);  // ** 비어있는 queue를 poll 하면 null이 return 된다.
            } else {
                pq.offer(x);
            }
        }
    }
}
