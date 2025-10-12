class Solution {
    public int solution(int n, int w, int num) {
        int h = n%w==0 ? n/w : n/w+1;
        // System.out.println(w+"*"+h);
        int[][] map = new int[h][w];
        int idx = 1;
        int col = -1;
        for (int i = h-1; i >= 0; i--){
            if ((h-i) % 2 != 0){
                for (int j = 0; j < w; j++){
                    if (idx > n) break;
                    if (idx == num) col = j;
                    map[i][j] = idx++;
                }
            } else {
                for (int j = w-1; j >= 0; j--){
                    if (idx > n) break;
                    if (idx == num) col = j;
                    map[i][j] = idx++;
                }
            }
            if (idx > n) break;
        }
        
        int answer = 0;
        for (int i = h-1; i >= 0; i--){
            if (map[i][col] != 0 && map[i][col] >= num) answer++;
        }
        
        return answer;
    }
}