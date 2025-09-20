select count(*) as fish_count, month(time) as month
  from FISH_INFO
 group by month(time)
 order by month