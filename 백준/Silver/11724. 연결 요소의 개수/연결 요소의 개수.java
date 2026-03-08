import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, ans = 0;
	static List<List<Integer>> adjList = new ArrayList<>();
	static boolean[] visit;
    public static void main(String[] args) throws Exception{
    	st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 정점 입력이 1 ~ N임을 고려하며 인접리스트, 방문 배열 초기화
		for (int i = 0; i <= N; i++){
			adjList.add(new ArrayList<>());
		}
		visit = new boolean[N+1];

		for (int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}

		for (int i = 1; i <= N; i++){
			if (!visit[i]) {
				dfs(i);
				ans++;
			}
		}

		System.out.println(ans);
    }

	static void dfs(int start){
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		visit[start] = true;
		while (!stack.isEmpty()){
			int cur = stack.pop();

			for (int j = 0; j < adjList.get(cur).size(); j++){
				int next = adjList.get(cur).get(j);
				if (visit[next]) continue;

				stack.push(next);
				visit[next] = true;
			}
		}
	}
}