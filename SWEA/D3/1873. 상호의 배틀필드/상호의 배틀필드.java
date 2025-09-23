import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, H, W, N, sr, sc, sd;
	static char[][] map;
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};  // UDLR 순서
    public static void main(String[] args) throws Exception{
        // 포탄 - 벽돌벽, 강철벽, 맵 밖까지 직진
        // 벽? 포탄소멸! -> 벽돌벽? 벽도 함께 소멸되어 평지가 됨
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++){
            sb.append("#").append(tc).append(" ");

            st = new StringTokenizer(br.readLine().trim());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            for (int i = 0; i < H; i++){
                String str = br.readLine().trim();
                for (int j = 0; j < W; j++){
                    char c = str.charAt(j);
                    map[i][j] = c;
                    if (c == '>' || c == '<' || c == '^' || c == 'v'){
                        sd = changeToInt(c);
                        sr = i;
                        sc = j;
                    }

                }
            }
            N = Integer.parseInt(br.readLine());
            String str = br.readLine().trim();
            for (int i = 0; i < N; i++){
                char order = str.charAt(i);
                if (order == 'S')
                    shoot();
                else {
                    move(order);
                }
            }
            printMap();
        }
        System.out.println(sb);
    }
    static void move(char c){
        sd = getDir(c);
        int nr = sr + dr[sd];
        int nc = sc + dc[sd];

        if (isMap(nr, nc) && map[nr][nc] == '.') {
            map[sr][sc] = '.';
            sr = nr;
            sc = nc;
        }
        map[sr][sc] = changeToDir(sd);
    }

    static void shoot(){
        int nr = sr;
        int nc = sc;
        while (true){
            nr += dr[sd];
            nc += dc[sd];

            if (!isMap(nr, nc)) break;  // 맵을 벗어날 경우
            if (map[nr][nc] == '#') break;  // 강철벽
            if (map[nr][nc] == '*') {   // 벽돌벽
                map[nr][nc] = '.';
                break;
            }
        }
    }

    static int getDir(char c){
        if (c == 'U') return 0;
        else if (c == 'D') return 1;
        else if (c == 'L') return 2;
        else return 3;
    }

    static int changeToInt(char c){
        if (c == '^') return 0;
        else if (c == 'v') return 1;
        else if (c == '<') return 2;
        else return 3;
    }

    static char changeToDir(int d){
        if (d == 0) return '^';
        else if (d == 1) return 'v';
        else if (d == 2) return '<';
        else return '>';
    }

    static boolean isMap(int r, int c){
        if (r < 0 || r >= H || c < 0 || c >= W) return false;
        return true;
    }

    static void printMap(){
        for (int i = 0; i < H; i++){
            for (int j = 0; j < W; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
    }
}