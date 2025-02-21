select p.product_code, sum(s.sales_amount * p.price) as sales
  from product p, offline_sale s
 where p.product_id = s.product_id
 group by p.product_code
 order by sales desc, product_code