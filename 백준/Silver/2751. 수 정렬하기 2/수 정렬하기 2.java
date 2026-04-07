import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] origin, temp;
    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        origin = new int[N+1];
        temp = new int[N+1];
        for (int i = 1; i <= N; i++){
            origin[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(1, N);

        for (int i = 1; i <= N; i++){
            System.out.println(origin[i]);
        }
    }

    public static void mergeSort(int start, int end){
        if (end - start < 1){
            return;
        }

        int mid = start + (end - start)/2;

        mergeSort(start, mid);
        mergeSort(mid+1, end);

        for (int i = start; i <= end; i++){
            temp[i] = origin[i];
        }

        int k = start;
        int idx1 = start;
        int idx2 = mid+1;

        while (idx1 <= mid && idx2 <= end){
            if (temp[idx1] > temp[idx2]){
                origin[k] = temp[idx2];
                k++;
                idx2++;
            } else {
                origin[k] = temp[idx1];
                k++;
                idx1++;
            }
        }

        while (idx1 <= mid){
            origin[k] = temp[idx1];
            k++;
            idx1++;
        }

        while (idx2 <= end){
            origin[k] = temp[idx2];
            k++;
            idx2++;
        }
    }
}