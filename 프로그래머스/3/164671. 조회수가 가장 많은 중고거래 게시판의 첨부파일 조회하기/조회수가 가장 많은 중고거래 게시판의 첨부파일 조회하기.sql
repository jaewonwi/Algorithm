select CONCAT('/home/grep/src/', b.board_id,'/', f.file_id, f.file_name, f.file_ext) as FILE_PATH
  from USED_GOODS_BOARD b join USED_GOODS_FILE f on b.board_id = f.board_id
 where b.views = (select max(views) from USED_GOODS_BOARD)
ORDER BY F.FILE_ID DESC