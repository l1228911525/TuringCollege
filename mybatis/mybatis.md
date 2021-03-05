### 一级缓存的使用条件
1.必须是同一个会话<br>
2.必须是相同的mapper<br>
3.必须是相同的方法<br>
4.查询前不能执行session.clearCache()<br>
5.查询语句的中间执行增删改会自动执行session.clearCache()<br>
