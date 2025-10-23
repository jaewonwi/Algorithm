import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, start, from, to, ans;
	static List<List<Integer>> friends = new ArrayList<>();
	static boolean[] visit = new boolean[101];
	static Queue<Integer> q = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		for (int i = 0; i < 101; i++){		// friends 리스트 생성
			friends.add(new ArrayList<>());
		}

		for (int tc = 1; tc <= 10; tc++){
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			Arrays.fill(visit, false);
			for (int i = 0; i < 101; i++){
				friends.get(i).clear();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n/2; i++){
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				friends.get(from).add(to);
			}

			q.clear();
			visit[start] = true;
			q.offer(start);
			while (!q.isEmpty()){
				int size = q.size();
				ans = 0;

				for (int i = 0; i < size; i++){
					int cur = q.poll();
					ans = Math.max(ans, cur);

					for (int next : friends.get(cur)){
						if (visit[next]) continue;

						visit[next] = true;
						q.add(next);
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}