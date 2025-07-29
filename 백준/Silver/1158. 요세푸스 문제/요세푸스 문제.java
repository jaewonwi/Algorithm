import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, K;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++){
			q.offer(i);
		}
		sb.append("<");

		int tot = 0;
		int cnt = 0;
		while (!q.isEmpty()){
			cnt++;
			if (cnt == K){
				sb.append(q.poll()).append(", ");
				cnt = 0;
			} else {
				int n = q.poll();
				q.offer(n);
			}
		}
		int len = sb.length();
		sb.deleteCharAt(len-1);
		sb.deleteCharAt(len-2);
		sb.append(">");
		System.out.println(sb);
	}
}