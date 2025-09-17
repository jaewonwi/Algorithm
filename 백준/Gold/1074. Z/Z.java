import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, r, c, idx;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2,N);
        idx = 0;
        Z(r,c,size);
        System.out.println(idx);
    }

    static void Z(int r, int c, int size){
        int half = size / 2;
        if (size == 1){
            return;
        }

        if (r < half && c < half){
            Z(r,c,half);
        } else if (r < half && c >= half){
            idx += (size*size/4);
            Z(r,c-half, half);
        } else if (r >= half && c < half){
            idx += (size*size/4)*2;
            Z(r-half,c, half);
        } else if (r >= half && c >= half) {
            idx += (size*size/4)*3;
            Z(r-half, c-half, half);
        }
    }
}