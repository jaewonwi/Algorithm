import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // data: code, date, maximum, remain
        // ext: 뭐를 기준으로 데이터를 뽑을지?
        // val_ext: 뽑아낼 정보의 기준 값(이것보다 작은 값만 추출)
        // sort by: 정렬 기준인 문자열(오름차순 정렬)
        int extract = getIndex(ext);
        int sort = getIndex(sort_by);
        
        data = Arrays.stream(data)
            .filter(d -> d[extract] < val_ext)
            .sorted((d1, d2) -> d1[sort] - d2[sort])
            .toArray(int[][]::new);
        
        return data;
    }
    
    public int getIndex(String s){
        switch (s){
            case "code" :
                return 0;
            case "date":
                return 1;
            case "maximum" :
                return 2;
            case "remain":
                return 3;   
        }
        
        return -1;
    }
}