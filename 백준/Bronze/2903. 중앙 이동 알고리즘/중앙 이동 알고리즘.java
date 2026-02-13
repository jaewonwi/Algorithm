import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
    	// 중앙이동 알고리즘? 정사각형을 이루는 점 4개 선택 -> 중심에 점 추가 => 반복
		// 0 -> 2 * 2	-> 한 변에 1개
		// 1 -> 3 * 3	-> 한 변에 2개
		// 2 -> 5 * 5	-> 한 변에 4개
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int line = (int) Math.pow(2, N) + 1;
		System.out.println((int) Math.pow(line, 2));
    }
}