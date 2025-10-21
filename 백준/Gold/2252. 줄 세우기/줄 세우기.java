import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, A, B;
	static int[] topo;	// 위상정렬 차수
	static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		topo = new int[N+1];

		for (int i = 0; i <= N; i++){
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			// A -> B 연결
			graph.get(A).add(B);
			topo[B]++;
		}

		// 진입 차수가 0인 것 Queue에 추가
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++){
			if (topo[i] == 0) q.offer(i);
		}

		while (!q.isEmpty()){	// 남은 원소가 없을 때까지
			int cur = q.poll();
			sb.append(cur).append(" ");

			List<Integer> list = graph.get(cur);
			int size = list.size();
			for(int i = 0; i < size; i++){
				int next = list.get(i);
				topo[next]--;
				if (topo[next] == 0) q.offer(next);
			}
		}

		System.out.println(sb);
    }
}