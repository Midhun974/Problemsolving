# Write your MySQL query statement below
WITH cte As
(Select player_id,event_date,
ROW_Number() OVER(PARTITION BY player_id ORDER BY event_date) As "rnk"
From Activity)
select player_id,event_date As "first_login"
from cte
WHERE rnk=1;