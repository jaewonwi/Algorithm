import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

	static int N, S;
	static int[] A;		// 원소는 1~10만
    public static void main(String[] args) throws Exception{
		// '연속된' 두개의 원소만 교환할 수 있음 = 최대 S번
		// 소트 결과가 사전순으로 가장 뒷서는 것 => 내림차순이 되도록 소트하자!
		// 맨 왼쪽부터 보면서 교체할 수 있는 구간 내에 제일 큰 값을 앞으로 당겨주자!

		N = Integer.parseInt(br.readLine());	// ~ 50
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++){
			A[i] = Integer.parseInt(st.nextToken());
		}
		S = Integer.parseInt(br.readLine());	// 0 ~ 100만

		for (int i = 0; i < N; i++) {
			if (S == 0) break;

			int max = 0;
			int maxIdx = 0;
			for (int j = i; j < Math.min(i+S+1, N); j++) {	// 정렬이 완료되지 않은 왼쪽 끝부터 (교체 가능한 곳까지 or 배열 끝까지) 보면서
				if (max < A[j]) {	// 그 구역 내 최댓값을 찾는다
					max = A[j];
					maxIdx = j;
				}
			}

			while (maxIdx != i && S > 0){	// 최댓값이 있는 곳부터 왼쪽으로 가면서 바꿔준다.
				int temp = A[maxIdx-1];
				A[maxIdx-1] = A[maxIdx];
				A[maxIdx] = temp;
				maxIdx--;
				S--;
			}
		}

		for (int i = 0; i < N; i++){
			sb.append(A[i]).append(" ");
		}
		System.out.println(sb);
    }
}