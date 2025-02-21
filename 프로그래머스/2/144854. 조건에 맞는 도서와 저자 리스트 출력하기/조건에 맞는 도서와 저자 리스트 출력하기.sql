select b.book_id, a.author_name, date_format(b.published_date, '%Y-%m-%d') as published_date
 from book b inner join author a
where b.category = '경제'
  and a.author_id = b.author_id
order by b.published_date asc;