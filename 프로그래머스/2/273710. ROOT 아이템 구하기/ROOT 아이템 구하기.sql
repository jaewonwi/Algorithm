select I.ITEM_ID, I.ITEM_NAME
  from ITEM_INFO as I, ITEM_TREE as T
 where T.PARENT_ITEM_ID is null
   and I.ITEM_ID = T.ITEM_ID
 order by I.ITEM_ID