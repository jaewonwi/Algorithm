class Solution {
    StringBuilder sb = new StringBuilder();
    public String solution(int n) {
        String answer = "";
        //    1,    2,    3,     4,   5,    6,     7,      8,     9,    10    | 10진법
        //    1,    2,    4,    11,  12,   14,    21,     22,    24,    41    | 124나라법
        //   42,   44,  111,   112, 114,  121,   122,    124,   141,   142 
        //  144,  211,  212,   214, 221,  222,   224,    241,   242,   244
        //  411,  412,  414,   421, 422,  424,   441,    442,   444,  1111
        // 1 -> 2 -> 4, 순서대로 나가고 그 앞에 같은 순서로 숫자 붙임
        int num = n;
        int jarisu = 1;
        while (num >= 0){
            num -= Math.pow(3, jarisu);
            if (num <= 0){
                break;
            } 
            
            jarisu++;                
        }
        
        num = n;
        for (int i = jarisu - 1; i >= 0; i--){
            int val = (int) Math.pow(3, i);
            
            int rem = 0;
            for (int j = i-1; j >= 0; j--){
                rem += (int) Math.pow(3, j);
            }
                
            int cnt = 0;
            while ((num - val) >= 0 && cnt < 3){
                if ((num - val - rem) < 0) break;
                cnt++;
                num -= val;
                // System.out.println("-"+val+" = "+num);
            }
            
            if (cnt == 3){
                sb.append(4);
            } else if (cnt == 2){
                sb.append(2);
            } else if (cnt == 1){
                sb.append(1);
            }
        }
        
        return sb.toString();
    }
    
}





// 0001, 0010, 0100, 1011, 1100, 1110, 1 0101, 1 0110, 1 1000, 10 1001