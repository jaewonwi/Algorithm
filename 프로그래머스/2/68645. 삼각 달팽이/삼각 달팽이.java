class Solution {
    public int[] solution(int n) {
        // 맨 위 꼭짓점부터 반시계로 돌면서 안으로 채우기
        // 직각삼각형으로 생각할 수 있을 것 같아요.
        int[][] arr = new int[n][n];
        // index 반시계로 돌리면서 1. 삼각형 범위 밖(x>y) 2. 이미 채워진 경우 방향 전환하기
            // 방향 순서 하->우->좌상-> ... 현재 진행 방향에서 반시계로 돌아서 갈 곳 찾기
        
        int[] dy = {1, 0, -1}, dx = {0, 1, -1};
        int num = 1;
        int d = 0;
        int sy = 0, sx = 0;
        arr[0][0] = num++;
        while(true){
            int ny = sy + dy[d];
            int nx = sx + dx[d];
            
            if (!canGo(arr, n, ny, nx)){
                d = (d+1) % 3;
                if (!canGo(arr, n, sy+dy[d], sx+dx[d])) break;
                continue;
            }
            
            arr[ny][nx] = num++;
            sy = ny;
            sx = nx;
        }
        
        // 출력
        // 2차원 삼각형의 0,0부터 순서대로 담은 1차원 배열(row마다 x==y인 곳 까지)
        int[] answer = new int[n*(n+1)/2];
        int idx = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++){
                answer[idx++] = arr[i][j];
            }
        }
        return answer;
    }
    
    private boolean canGo(int[][] arr, int n, int y, int x){
        if (y < 0 || x < 0 || y >= n || x >= n || x > y)
            return false;
        if (arr[y][x] != 0) return false;
        return true;
    }
}