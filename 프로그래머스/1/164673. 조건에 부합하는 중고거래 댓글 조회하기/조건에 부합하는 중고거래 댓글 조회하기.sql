# 2022년 10월에 작성된 게시글 제목, 게시글 ID / 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일
# 댓글 작성일을 기준으로 오름차순 - 댓글 작성일이 같다면 게시글 제목을 기준으로 오름차순

select b.title as TITLE, b.board_id as BOARD_ID, r.reply_id as REPLY_ID, r.writer_id as WRITER_ID, r.contents as CONTENTS, date_format(r.created_date, '%Y-%m-%d') as CREATED_DATE
  from used_goods_board b, used_goods_reply r
 where b.board_id = r.board_id
   and b.created_date like '2022-10%'
 order by r.created_date, b.title