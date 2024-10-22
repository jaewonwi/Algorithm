import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T, n, m;
    static int[] parent;

    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++){
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            make(n);

            for (int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int cal = Integer.parseInt(st.nextToken());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (cal == 0){
                    union(a, b);
                } else if (cal == 1) {
                    if (find(a) == find(b)) sb.append(1);
                    else sb.append(0);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean union(int a, int b){
        if (find(a) == find(b)) return false;

        parent[find(b)] = find(a);
        return true;
    }

    static int find(int x){
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);    // ** path compression!
    }

    static void make(int x){
        parent = new int[x+1];
        for (int i = 0; i <= x; i++){
            parent[i] = i;
        }
    }
}
