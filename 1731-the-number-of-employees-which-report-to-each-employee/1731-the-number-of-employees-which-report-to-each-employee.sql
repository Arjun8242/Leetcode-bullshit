# Write your MySQL query statement below
SELECT e.employee_id, e.name, COUNT(*) as reports_count, ROUND(AVG(m.age), 0) as average_age FROM Employees e
JOIN Employees m
ON e.employee_id = m.reports_to
GROUP BY e.employee_id
ORDER BY e.employee_id