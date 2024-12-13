# Write your MySQL query statement below
DELETE FROM Person where id not in (select s.id from 
(select min(id) as id from person group by email)as s)