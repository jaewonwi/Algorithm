class Solution {
    static int cur, end, opStart, opEnd;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        cur = toIntVal(pos.split(":"));
        end = toIntVal(video_len.split(":"));
        opStart = toIntVal(op_start.split(":"));
        opEnd = toIntVal(op_end.split(":"));
        
        for (String command : commands){
            skip();
            
            if (command.equals("prev")){
                System.out.println("prev");
                cur = prev(cur);
            } else if (command.equals("next")){
                System.out.println("next");
                cur = next(cur);
            }
            
            skip();
            
        }
    
        return toTime(cur);
    }
    
    int prev(int time){
        if (time < 10)
            return time = 0;
        else
            return time -= 10;
    }
    
    int next(int time){
        if (end - time < 10)
            return time = end;
        else 
            return time += 10;
    }
    
    int toIntVal(String[] time){
        return Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]);
    }
    
    String toTime(int time){
        String answer = "";
        int min = time / 60;
        int sec = time % 60;
        
        if (min < 10){
            answer += "0";
        }
        answer += Integer.toString(min);
        answer += ":";
        if (sec < 10){
            answer += "0";
        }
        answer += Integer.toString(sec);
        
        
        return answer;
    }
    
    void skip(){
        if (cur >= opStart && cur < opEnd){
            System.out.println("skip!");
            cur = opEnd;            
        }
    }
}