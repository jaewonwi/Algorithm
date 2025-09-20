select count(i.fish_type) as fish_count, n.FISH_NAME as FISH_NAME
  from FISH_NAME_INFO n join FISH_INFO i on n.fish_type = i.fish_type
 group by fish_name
 order by count(i.id) desc