import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static PriorityQueue<Integer> cards = new PriorityQueue<>((o1, o2) -> o1 - o2);
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++){
            cards.add(Integer.parseInt(br.readLine()));
        }

        if (N == 1){    // 카드 묶음이 1개면 비교할 필요가 없음
            System.out.println(0);
            return;
        }

        int compareCnt = 0;
        while (cards.size() > 1){
            int o1 = cards.poll();
            int o2 = cards.poll();

            compareCnt += o1 + o2;

            cards.offer(o1 + o2);
        }
        System.out.println(compareCnt);
    }
}