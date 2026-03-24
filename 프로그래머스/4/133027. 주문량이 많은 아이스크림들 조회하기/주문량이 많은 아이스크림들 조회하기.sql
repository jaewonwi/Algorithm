# 7월은 = 같은 아이스크림을 서로 다른 두 공장에서 아이스크림 가게로 출하를 진행 ? 같은 맛이더라도 다른 출하 번호
# 7월 아이스크림 총 주문량 + 상반기 아이스크림 총 주문량 합 desc limit 3
# outer join 이 필요하지 않을까? 이유 = 한쪽에만 있을 수 있음
select h.flavor
  from first_half as h inner join july as j
    on h.flavor = j.flavor
 group by j.flavor
 order by h.total_order + sum(j.total_order) desc 
 limit 3 