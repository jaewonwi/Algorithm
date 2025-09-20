select i.id as ID, n.fish_name as FISH_NAME, i.length as LENGTH
  from FISH_INFO i join FISH_NAME_INFO n on i.FISH_TYPE = n.FISH_TYPE
 where (i.fish_type, i.length) in (select fish_type, max(length)
                                     from FISH_INFO
                                    group by fish_type)
 order by i.id