import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, ans = 0;
	static int[][] inning;
	static int[] tgt;
	static boolean[] visit, ground;
    public static void main(String[] args) throws Exception{
		// N 이닝, 3아웃 -> 이닝 종료 & 공수 교대
		// 타순 변경 X, 4>...>8>9>1>2>..., 이닝 변경 후 타순 유지
		// 이닝 시작 시 주자 X
		// 안타(모두 1루 진루), 2루타, 3루타, 홈런(모두 홈 진루), 아웃(진루X,아웃+)
		// 입력
		N = Integer.parseInt(br.readLine());
		inning = new int[N][9];
		for (int n = 0; n < N; n++){
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++){
				inning[n][i] = Integer.parseInt(st.nextToken());
			}
		}

		tgt = new int[9];
		visit = new boolean[9];
		ground = new boolean[4];	// 홈, 1, 2, 3루

		tgt[3] = 0;	// 1번 타자는 4번째 고정

		perm(0);

		System.out.println(ans);
    }

	static void perm(int cnt){
		if (cnt == tgt.length){
			// 순서가 완성되면
			start();
			return;
		}

		for (int i = 1; i < 9; i++){
			if (visit[i]) continue;

			visit[i] = true;
			if (cnt == 3) cnt++;	// ** tgt[3]은 이미 0번 선수로 고정되어 있으니 다음 자리로 바로 넘기면 됨
			tgt[cnt] = i;
			perm(cnt+1);
			visit[i] = false;
		}
	}

	static void start(){
		int score = 0;
		int idx = 0;	// order[]의 몇번째 선수인지;
		for (int i = 0; i < N; i++){
			// 이닝 시작 - 아웃 count 0, 경기장에 아무도 없음
			int out = 0;
			Arrays.fill(ground, false);

			while (out < 3){	// 아웃 3개 - 다음 이닝
				int player = tgt[idx];			// 현재 타자
				int hit = inning[i][player];	// 현재 타자가 이번 게임에서 얻은 결과

				ground[0] = true;	// 홈에 타자
				if (hit == 0) {
					ground[0] = false;	// 아웃이면 바로 나감
					out++;
				} else
					score += getPoint(hit);	// 아웃이 아니면 점수 계산

				idx = (idx + 1) % 9;	// 다음 타자
			}
		}

		ans = Math.max(ans, score);
	}

	static int getPoint(int hit){
		int point = 0;
		for (int i = 3; i >= 0; i--){
			if (!ground[i]) continue;

			if (hit + i > 3){
				point++;
			} else {
				ground[hit+i] = true;
			}
			ground[i] = false;
		}

		return point;
	}



}