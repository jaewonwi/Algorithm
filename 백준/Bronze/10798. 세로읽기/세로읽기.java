import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		char[][] arr = new char[15][15];
		for (int i = 0; i < 15; i++){
			Arrays.fill(arr[i], '-');
		}

		for (int i = 0; i < 5; i++){
			String str = br.readLine();
			int len = str.length();
			for (int j = 0; j < len; j++){
				char c = str.charAt(j);
				arr[i][j] = c;
			}
		}
		for (int j = 0; j < 15; j++){
			for (int i = 0; i < 5; i++){
				if (arr[i][j] == '-') continue;
				sb.append(arr[i][j]);
			}
		}

		System.out.print(sb);
	}
}