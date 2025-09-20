select count(USER_ID)
  from USER_INFO
 where YEAR(JOINED) = '2021'
   and AGE between 20 and 29