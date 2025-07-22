import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;	// 1~N번 카드 쌓여있음. (맨위가 1)
    public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++){
			q.offer(i);
		}

		while (q.size() != 1){
			int n = q.poll();
			if (q.size() == 1) break;

			n = q.poll();
			q.offer(n);
		}
		System.out.println(q.poll());
    }
}