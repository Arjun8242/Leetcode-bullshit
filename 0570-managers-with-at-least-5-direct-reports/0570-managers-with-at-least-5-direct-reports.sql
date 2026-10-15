# Write your MySQL query statement below
SELECT m.name FROM Employee m
INNER JOIN Employee e
ON m.id = e.managerId
GROUP BY m.name, m.id
HAVING COUNT(e.managerId)>=5