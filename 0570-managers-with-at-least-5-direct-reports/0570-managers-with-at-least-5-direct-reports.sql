# Write your MySQL query statement below
select e1.name
from Employee as e1
inner join Employee as e2
on e1.id=e2.managerId
GROUP BY e2.managerId
HAVING COUNT(e2.managerId)>=5
