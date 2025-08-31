select h.flavor
  from first_half h, icecream_info i
 where h.total_order >= 3000 and h.flavor = i.flavor and i.ingredient_type like 'fruit_based'
 order by h.total_order desc;