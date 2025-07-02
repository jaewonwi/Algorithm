import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		boolean[] switches = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++){
			switches[i] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
		}

		int students = Integer.parseInt(br.readLine());
		for (int i = 0; i < students; i++){
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());	// 1: 남, 2: 여
			int number = Integer.parseInt(st.nextToken());

			if (gender == 1){
				for (int j = number; j <= n; j += number){
					switches[j] = !switches[j];
				}
			} else {
				switches[number] = !switches[number];
				for (int j = 1; j <= n; j++){
					int left = number - j;
					int right = number + j;
					if (left <= 0 || right > n) break;

					if (switches[left] == switches[right]){
						switches[left] = switches[right] = !switches[right];
					} else
						break;
				}
			}
		}

		for (int i = 1; i <= n; i++){
			sb.append(switches[i] ? 1:0).append(" ");
			if (i % 20 == 0)
				sb.append("\n");
		}

		System.out.println(sb);
	}
}