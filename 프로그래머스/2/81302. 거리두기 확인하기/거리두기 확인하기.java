class Solution {
    public static final int[] dy = {-1,0,0,1}, dx = {0,-1,1,0}; // 상좌우하(0-1-2-3). 이 순서로 하면 (3 - 방향 index) == 반대방향 index
    public int[] solution(String[][] places) {    
        int[] answer = new int[places.length];  // places.length = 5
        for (int tc = 0; tc < places.length; tc++){
            String[] place = places[tc];
            char[][] room = new char[place.length][];
            for (int i = 0; i < room.length; i++){
                room[i] = place[i].toCharArray();
            }
            answer[tc] = isDistanced(room) ? 1 : 0;
        }
        return answer;
    }
    
    private boolean isDistanced(char[][] room){ // 오버로딩: 이 방 자체가 거리두기를 지키는지 확인하는 함수
        for (int i = 0; i < room.length; i++){
            for (int j = 0; j < room[i].length; j++){  
                if (room[i][j] != 'P') continue; // 응시자마다 거리두기 체크
                
                // 거리두기 확인 방식: 응시자 주변으로 거리 2 이내로 도달할 수 있는 응시자가 있는지 확인하기
                // 1. 응시자 기준 주위 4방향에 빈칸 or 응시자 확인
                // 2. 빈칸일 경우 그 빈칸을 기준으로 주위에 응시자가 존재하면 거리두기를 어긴 것(기준 응시자 제외)
                for (int d = 0; d < 4; d++){
                    int ny = i + dy[d];
                    int nx = j + dx[d];
                    if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
                    
                    if (room[ny][nx] == 'P') return false;  // 거리두기 어김
                    if (room[ny][nx] == 'X') continue;  // 칸막이가 있다면 더이상 살펴볼 필요가 없음
                    if (!isDistanced(room, ny, nx, 3-d)) return false;
                }   
            }
        }
        return true;
    }
    
    private boolean isDistanced(char[][] room, int y, int x, int exceptDir){ // 오버로딩: y,x에 있는 사람이 거리두기를 어겼는지 확인하는 함수
        // System.out.println(y+","+x+" 탐색 시작");
        for (int d = 0; d < 4; d++){
            if (d == exceptDir) continue;
            
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            // System.out.println(ny+","+nx+" : "+room[ny][nx]);
            if (room[ny][nx] == 'P') return false;  // 거리두기 어김
        }
        return true;
    }
}
