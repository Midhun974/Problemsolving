# Write your MySQL query statement below
select x,y,z,
CASE
    when x+y <=z or y+z <=x or z+x <=y THEN 'No'
    ELSE 'Yes'
END as triangle
from triangle;
