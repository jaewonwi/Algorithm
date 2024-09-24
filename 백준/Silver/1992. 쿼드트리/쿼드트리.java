import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        // 입력
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++){
            char[] charArr = br.readLine().toCharArray();
            for (int j = 0; j < N; j++){
                map[i][j] = charArr[j]-'0';
            }
        }

        compress(N,0, 0);

        System.out.println(sb);

    }

    static void compress(int size, int sy, int sx){
        int sum = 0;
        for (int i = sy; i < sy+size; i++){
            for (int j = sx; j < sx+size; j++){
                sum += map[i][j];
            }
        }

        if (sum == 0){
            sb.append(0);
        } else if (sum == size * size) {
            sb.append(1);
        } else {
            sb.append("(");
            int half = size/2;
            compress(half, sy, sx);
            compress(half, sy, sx+half);
            compress(half, sy+half, sx);
            compress(half, sy+half, sx+half);
            sb.append(")");
        }
    }
}
