select customer_id, count(visits.visit_id) as count_no_trans from visits 
left join transactions on Visits.visit_id = transactions.visit_id 
where transactions.visit_id is null
group by customer_id;
