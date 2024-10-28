import java.io.*;
import java.util.*;

// 이분탐색 left, right 잘 정하기
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] trees;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        // 절단기에 설정할 수 있는 높이 H의 최댓값
        int left = 1;
        int right = Arrays.stream(trees).max().getAsInt();

        while (left <= right){
            int mid = (left+right)/2;

            if (cut(mid) >= M){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        System.out.println(left-1);
    }

    // H 높이에서 잘랐을 때 나오는 나무
    static long cut(int H){
        long sum = 0;
        for (int i = 0; i < N; i++){
            if (trees[i] > H){
                sum += trees[i] - H;
            }
        }

        return sum;
    }
}
