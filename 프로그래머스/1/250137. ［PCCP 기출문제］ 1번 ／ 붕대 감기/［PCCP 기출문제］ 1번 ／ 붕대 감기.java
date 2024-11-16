import java.util.*;
// System.out.println();

// 붕대감기: t초 * x 회복 -> t초 연속으로 붕대 감기 성공하면 y 추가 회복
// 최대 체력 >= 현재 체력
// 중간에 공격당하면 기술 취소 & 그 순간에는 체력회복 X
// 기술 취소 or 기술 끝나면 -> 즉시 붕대감기 다시 사용 & 연속 성공시간 0초로 초기화
// 공격 당함: 현재체력 - 피해량 (현재체력 <= 0 이면 죽음)

// bandage: 붕대감기 기술의 시전시간 t, 1초당 회복량 x, 추가 회복량 y
// health: 최대체력
// attacks: 공격시간 at(attack time), 피해량 damage
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int ht = bandage[0];    // heal time
        int x = bandage[1];
        int y = bandage[2];
        
        int T = attacks.length;
        int max = health;
        
        int success = 0;
        int idx = 0;
        for (int t = 1; t <= attacks[T-1][0]; t++){
            int at = attacks[idx][0];
            int damage = attacks[idx][1];
            
            if (t == at){  // 현재가 공격 타이밍 -> 연속성공 초기화 & 체력회복 X & 데미지 감소 & 죽었는지 체크
                success = 0;
                health -= damage;
                idx++;
                
                if (health <= 0){
                    return -1;
                }
            } else {    // 공격 받지 않는 타이밍 -> 연속성공 ++ & 체력회복 & 추가체력회복
                success++;
                health += x;
                
                if (success == ht){
                    health += y;
                    success = 0;
                }
                
                if (health > max){
                    health = max;
                }
                
            }
            
            
        }
        
        return health;
    }
}