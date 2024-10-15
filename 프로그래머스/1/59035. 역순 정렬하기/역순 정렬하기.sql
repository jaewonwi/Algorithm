-- 코드를 입력하세요
    select name, datetime
      from animal_ins
  group by animal_id
  order by animal_id desc
