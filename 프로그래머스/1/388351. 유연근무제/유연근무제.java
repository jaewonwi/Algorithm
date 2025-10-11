class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        // 토, 일 - 출근시각 상관 X
        // startday = 1 ~ 7 (6,7 = 토,일)
        startday--;                 // 요일 계산 편의
        int n = schedules.length;   // 직원 수
        for (int i = 0; i < n; i++){
            int hopeTime = schedules[i];    
            int admitTime = addTime(hopeTime, 10);
            
            boolean flag = true;
            for (int j = 0; j < 7; j++){
                int day = (startday + j) % 7;
                if (day == 5 || day == 6) continue;
                
                if (timelogs[i][j] > admitTime)
                    flag = false;
            }
            
            if (flag) answer++;
        }
        
        return answer;
    }
    
    public int addTime(int origin, int add){
        int originHour = origin / 100;
        int originMin = origin % 100;
        int addedMin = originMin + add;
        if (addedMin >= 60){
            addedMin -= 60;
            originHour++;
        }
        return originHour*100 + addedMin;
    }
}