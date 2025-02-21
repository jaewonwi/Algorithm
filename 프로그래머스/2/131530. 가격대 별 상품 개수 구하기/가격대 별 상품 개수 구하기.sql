select truncate(price/10000, 0)*10000 as price_group, count(truncate(price/10000, 0)) as products
from product
group by truncate(price/10000, 0)
order by price_group;