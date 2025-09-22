import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
    	st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<List<Integer>> friends = new ArrayList<>();
		for (int i = 0; i < N; i++)
			friends.add(new ArrayList<>());

		for (int i = 0; i < M; i++){
			st= new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			friends.get(A).add(B);
			friends.get(B).add(A);
		}

		int ans = 0;
		boolean[] visit = new boolean[N];
		for (int i = 0; i < N; i++){
			visit[i] = true;
 			if (dfs(i,1, friends, visit)){
				ans = 1;
				break;
			}
			 visit[i] = false;
		}

		System.out.println(ans);
    }

	static boolean dfs(int me, int cnt, List<List<Integer>> friends, boolean[] visit){
		if (cnt >= 5){
			return true;
		}

		List<Integer> myFriend = friends.get(me);
		for (int i = 0; i < myFriend.size(); i++){
			int friend = myFriend.get(i);
			if (visit[friend]) continue;

			visit[friend] = true;
			if (dfs(friend, cnt+1, friends, visit)) return true;
			visit[friend] = false;
		}

		return false;
	}
}