select i.ingredient_type, sum(total_order) as total_order
  from first_half h 
      join icecream_info i
        on h.flavor = i.flavor
 group by i.ingredient_type