import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] number;
    // static boolean[] primes;

    // 소수 판별식 = 에라토스테네스의 체
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        number = new int[N];

        int size = (int) Math.pow(10, N);
        // primes = new boolean[size+1];
        // Arrays.fill(primes,true);

        for (int i = 2; i < 9; i++){
            if (!isPrime(i)) continue;

            backtracking(String.valueOf(i));    // 가장 왼쪽을 i로 시작해서, N 자리까지 만들면서 소수인지 백트래킹
        }

        System.out.print(sb);
    }

    static void backtracking(String num){
        if (num.length() == N){
            sb.append(num).append("\n");
            return;
        }

        for (int i = 0; i <= 9; i++){
            String nextNum = num + Integer.toString(i);
            if (isPrime(Integer.valueOf(nextNum)))      // 매번 소수인지 체크
                backtracking(nextNum);
        }
    }

    static boolean isPrime(int n){
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0)     // n의 제곱근 보다 작은 어떤 수로 나누어 떨어지면 -> 소수 X
                return false;
        }
        return true;
    }
}