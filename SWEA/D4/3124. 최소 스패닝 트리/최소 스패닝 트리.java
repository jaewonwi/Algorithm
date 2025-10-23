import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, V, E;
	static long ans;
	static List<List<Edge>> graph = new ArrayList<>();
	static boolean[] visit;
	static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);
    public static void main(String[] args) throws Exception{
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++){
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			// 초기화
			graph.clear();
			for (int i = 0; i <= V; i++){
				graph.add(new ArrayList<>());
			}
			visit = new boolean[V+1];

			for (int i = 0; i < E; i++){
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());

				graph.get(A).add(new Edge(B,C));
				graph.get(B).add(new Edge(A,C));
			}

			// prim 알고리즘
			ans = 0;
			pq.clear();

			prim();

			sb.append("#"+tc+" ").append(ans).append("\n");
		}
		System.out.println(sb);
    }

	static void prim(){
		int cnt = 1;	// 선택된 정점의 수
		visit[1] = true;
		pq.addAll(graph.get(1));	// 1번 정점에서 갈 수 있는 간선 추가

		while (!pq.isEmpty()){
			Edge e = pq.poll();
			if (visit[e.b]) continue;

			visit[e.b] = true;
			ans += e.c;
			cnt++;

			if (cnt == V) break;

			for (Edge ne : graph.get(e.b)){
				if (!visit[ne.b]) pq.add(ne);
			}
		}
	}

	static class Edge{
		int b, c;	// |c| <= 1000_000

		public Edge(int b, int c){
			this.b = b;
			this.c = c;
		}
	}
}