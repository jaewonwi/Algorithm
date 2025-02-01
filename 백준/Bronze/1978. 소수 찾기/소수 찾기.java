import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] primes = new boolean[1001];

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        // 소수 판별식 = 에라토스테네스의 체

        Arrays.fill(primes,true);
        checkPrime(1000);
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            if (primes[n]) cnt++;
        }

        System.out.println(cnt);
    }

    static void checkPrime(int n){
        primes[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (primes[i]){
                for (int j = i*2; j <= n; j += i){
                    primes[j] = false;
                }
            }
        }
    }
}
