import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, d, k, c, cnt, ans = 0;
    static int[] dish, sushi;

    public static void main(String[] args) throws Exception {
        // 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 접시 수 3,000,000
        d = Integer.parseInt(st.nextToken());   // 종류 3000
        k = Integer.parseInt(st.nextToken());   // 연속으로 먹어야하는 수 3000
        c = Integer.parseInt(st.nextToken()) - 1;   // 쿠폰 번호
        dish = new int[N];
        for (int i = 0; i < N; i++) {
            dish[i] = Integer.parseInt(br.readLine()) - 1;
        }

        int left = 0;
        int right = k;
        sushi = new int[d];
        cnt = 0;
        for (int i = left; i < right; i++){
            eat(i);
        }
        coupon();

        do {
            cancel(left);
            eat(right);
            coupon();

            left = (left+1) % N;
            right = (right+1) % N;
        } while (left > 0);

        System.out.println(ans);
    }

    static void eat(int i){
        int eat = dish[i];
        if (sushi[eat] == 0)
            cnt++;
        sushi[eat]++;
    }

    static void cancel(int i){
        int cancel = dish[i];
        sushi[cancel]--;
        if (sushi[cancel] == 0){
            cnt--;
        }
    }

    static void coupon(){
        if (sushi[c] == 0) {
            ans = Math.max(ans, cnt + 1);
        } else {
            ans = Math.max(ans, cnt);
        }
    }
}
