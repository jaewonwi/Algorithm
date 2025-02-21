select 
    year(differentiation_date) as YEAR,
    (max_size - size_of_colony) as YEAR_DEV,
    id as ID
  from ecoli_data
  join (select 
        year(differentiation_date) as YEAR, max(size_of_colony) as max_size
       from ecoli_data
       group by year(differentiation_date)) 
       as max_sizes 
       on year(ecoli_data.differentiation_date) = max_sizes.YEAR
 order by year, year_dev;
 
#  SELECT 
#     YEAR(differentiation_date) year,
#     (year_max - size_of_colony) year_dev,
#     id
# FROM 
#     (SELECT 
#         *,
#         MAX(size_of_colony) OVER (PARTITION BY YEAR(differentiation_date)) year_max
#     FROM
#         ecoli_data) t
# ORDER BY
#     1, 2;