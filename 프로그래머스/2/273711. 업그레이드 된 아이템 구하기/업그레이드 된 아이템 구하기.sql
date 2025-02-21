# select i.item_id, i.item_name, i.rarity
#   from item_info i join (select t.item_id
#                       from item_info i join item_tree t
#                         on i.item_id = t.parent_item_id
#                      where i.rarity = 'RARE') as temp
#                     on temp.item_id = i.item_id
#     order by i.item_id desc;
    
with temp as (
    select t.item_id
      from item_info i join item_tree t
        on i.item_id = t.parent_item_id
     where i.rarity = 'RARE')

select i.item_id, i.item_name, i.rarity
  from item_info i join temp
                     on temp.item_id = i.item_id
    order by i.item_id desc;