import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] coins = {25, 10, 5, 1};	// 쿼터 $0.25, 다임 $0.10, 니켈 $0.05, 페니 $0.01
		for (int tc = 1; tc <= T; tc++){
			int C = sc.nextInt();	// 100C = 1$
			int val = 0, rem = C;
			for (int i = 0; i < 4; i++){
				int coin = coins[i];
				val = rem / coin;
				rem = rem % coin;
				sb.append(val).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
    }
}