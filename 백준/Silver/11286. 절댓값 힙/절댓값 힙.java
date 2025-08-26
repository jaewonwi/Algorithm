import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->
			Math.abs(o1) == Math.abs(o2) ? o1 - o2 : Math.abs(o1) - Math.abs(o2));
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x != 0) {
				pq.offer(x);
			} else {
				if (pq.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(pq.poll()).append("\n");
			}
		}

		System.out.println(sb);
	}
}