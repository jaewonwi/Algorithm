import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

	// ** 자료형 주의
	// N 배열의 길이 ~ 100만, M 나누는 수 ~ 1000, 배열의 원소 ~ 10억
	// 배열의 원소가 10억이라서 long

	// ** (A+B) % C = ((A % C) + (B % C)) % C 를 이용
	// 즉, 어떤 수의 나머지가 같으면, 그 두 수를 뺐을때 나머지는 0이 된다 = 나누어 떨어진다는 뜻
    public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] S = new long[N];	// 합 배열
		st = new StringTokenizer(br.readLine().trim());
		S[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {    // 입력받으면서 누적합 배열 구하기
			S[i] = S[i-1] + Integer.parseInt(st.nextToken());
		}

		long[] C = new long[M]; // 나머지 카운트 배열
		long cnt = 0;
		for (int i = 0; i < N; i++){
			int remain = (int) (S[i] % M);
			if (remain == 0) cnt++;		// 애초에 나머지가 0인 것의 수
			C[remain]++;
		}

		// 나머지가 같은 것 중 2개씩 뽑는 경우 * 나머지마다 수행
		for (int i = 0; i < M; i++){
			if (C[i] > 1) {
				cnt += C[i] * (C[i]-1) / 2;
			}
		}

		System.out.println(cnt);
    }
}