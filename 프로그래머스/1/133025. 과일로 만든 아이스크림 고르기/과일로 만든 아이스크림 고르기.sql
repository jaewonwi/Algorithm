select flavor
  from first_half
 group by flavor
having sum(total_order) > 3000
 and flavor in (select flavor from icecream_info where INGREDIENT_TYPE = 'fruit_based')
 order by sum(total_order) desc
 