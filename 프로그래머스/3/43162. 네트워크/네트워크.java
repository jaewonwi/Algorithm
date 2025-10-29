import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int[] parent = new int[n];
        int answer = 0;
        
        make(n, parent);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == j) continue;
                
                int connect = computers[i][j];
                if (connect == 1){
                    union(i, j, parent);
                }
            }            
        }
        
        for (int i = 0; i < n; i++){
            if (parent[i] == i) answer++;
        }
        
        return answer;
    }
    
    public void make(int n, int[] parent){
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
    }
    
    public int find(int x, int[] parent){
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x], parent);
    }
    
    public boolean union(int a, int b, int[] parent){
        int pa = find(a, parent);
        int pb = find(b, parent);
        
        if (pa == pb) return false;
        
        parent[pa] = pb;
        return true;
    }
}