import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, n, m, o, a, b;
	static int[] parent;
    public static void main(String[] args) throws Exception{
    	T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++){
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			makeSet(n);
			for (int i = 0; i < m; i++){
				st = new StringTokenizer(br.readLine());
				o = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());


				if (o == 0){
					unionSet(a,b);
				} else {
					int pa = findSet(a);
					int pb = findSet(b);

					if (pa == pb) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void makeSet(int n){
		parent = new int[n+1];
		for (int i = 0; i <= n; i++){
			parent[i] = i;
		}
	}

	static boolean unionSet(int a, int b){
		if (findSet(a) == findSet(b)) return false;

		parent[findSet(b)] = a;
		return true;
	}

	static int findSet(int a){
		if (parent[a] == a) return a;
		return parent[a] = findSet(parent[a]);
	}
}