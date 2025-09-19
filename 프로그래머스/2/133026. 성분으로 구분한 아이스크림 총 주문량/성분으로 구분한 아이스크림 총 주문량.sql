# 성분 타입 별 아이스크림의 총 주문량
select INGREDIENT_TYPE, sum(f.TOTAL_ORDER) as TOTAL_ORDER
  from FIRST_HALF f, ICECREAM_INFO i
 where f.flavor = i.flavor
 group by i.INGREDIENT_TYPE
 order by sum(f.total_order) 