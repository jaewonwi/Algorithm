import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        // Ax + By + C = 0
        // 1. x,y가 정수인 교점 구하기
            // 좌표 객체 필요
            // 두 직선의 교점을 구하는 함수 필요
        // 2. 모든 교점을 포함하는 가장 작은 평면 출력
            // offset(1000이하여야 함) 활용해서 제일 왼쪽 상단을 0,0으로 맞춰주자
        
        int n = line.length;    // 직선의 수(n) 1000개 이하
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n - 1; i++){
            for (int j = i+1; j < n; j++){
                Point intersection = intersection(line, i, j);    // 모든 직선쌍에 대해 교점구하기
                // 1000*1000 = 최대 100만번 계산  ==> 시간복잡도 0.01초
                if (intersection != null){
                    points.add(intersection);
                }
            }
        }
        
        Point minPoint = getMinPoint(points);
        Point maxPoint = getMaxPoint(points);
        
        int width = (int) (maxPoint.x - minPoint.x + 1);    // (0,0)에 하나를 찍더라도 크기는 1
        int height = (int) (maxPoint.y - minPoint.y + 1);
        
        char[][] arr = new char[height][width];
        for (char[] row : arr){     // 배열 초기화
            Arrays.fill(row, '.');
        }
        
        // 2차원 배열에 별 찍기
        for (Point p : points){
            // 좌표변환
            // 1. offset 활용하여 점 이동
            // 2. 좌표평면의 y 좌표는, 2차원 배열의 좌표랑 방향이 반대
            int x = (int) (p.x - minPoint.x);
            int y = (int) (maxPoint.y - p.y);
            arr[y][x] = '*';
        }
        
        String[] answer = new String[arr.length];
        for (int i = 0; i < answer.length; i++){
            answer[i] = new String(arr[i]);     // arr로 값을 반환한다.
        }
        return answer;
    }
    
    private static class Point {   
        public final long x, y;     // final: 데이터를 나타내는 클래스니까. long: 좌표범위가 주어지지 않음(주의! 1000*1000 크기라고 실제 좌표값 자체가 int 범위 내라는 보장이 없음)
        private Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
    
    public Point intersection(int[][] line, int i, int j){
        long a1 = line[i][0];
        long b1 = line[i][1];
        long c1 = line[i][2];
        long a2 = line[j][0];
        long b2 = line[j][1];
        long c2 = line[j][2];
        
        long denomiator = a1 * b2 - b1 * a2;
        if (denomiator == 0) return null; 
        
        double x = (double) (b1 * c2 - c1 * b2) / denomiator;   // double로 변환해서 계산해야 값 손실이 발생하지 않는다.
        double y = (double) (c1 * a2 - a1 * c2) / denomiator;
        
        if (x % 1 != 0 || y % 1 != 0) return null;  // 정수가 아닐 경우 null 반환
        
        return new Point((long) x, (long) y);
    }
    
    public Point getMinPoint(List<Point> points){   // 가장 작은 좌표
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        for (Point p : points){
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }
        return new Point(x, y);
    }
    
    public Point getMaxPoint(List<Point> points){   // 가장 작은 좌표
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        for (Point p : points){
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }
        return new Point(x, y);
    }
}