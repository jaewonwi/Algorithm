import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
	static int T, K;
	static String W;
	static int[] alphabet = new int[26];
    public static void main(String[] args) throws Exception{
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++){
			Arrays.fill(alphabet, 0);	// 알파벳 카운트 배열, 정답 초기화
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;

			W = br.readLine();	// 문자열
			K = Integer.parseInt(br.readLine());	// 충족해야하는 최소 개수

			if (K == 1){	// K가 1인 경우는 무조건 답이 이렇게 나옴
				System.out.println("1 1");
				continue;
			}

			for (int i = 0; i < W.length(); i++){	// 문자열 내에 있는 알파벳들을 미리 카운트해놓자
				alphabet[W.charAt(i) - 'a']++;
			}

			for (int i = 0; i < W.length() - K; i++){	// 시작점을 왼쪽 끝부터 보면서 K개를 충족하는지 본다.
				if (alphabet[W.charAt(i)-'a'] < K) continue;	// 시작점으로 잡은 알파벳이 K개 이하면 볼 필요가 없음

				// 시작점부터 오른쪽으로 보면서 같은 알파벳을 만날때마다 카운트해준다. 그리고 cnt가 K가 되면 답 갱신 후 다음 시작점을 보러간다
				int cnt = 1;
				for (int l = i + 1; l < W.length(); l++){
					if (W.charAt(i) == W.charAt(l)) cnt++;
					if (cnt == K){
						min = Math.min(min, l - i + 1);
						max = Math.max(max, l - i + 1);
						break;
					}
				}
			}

			if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE)
				System.out.println("-1");
			else
				System.out.println(min+" "+max);

		}
    }
}