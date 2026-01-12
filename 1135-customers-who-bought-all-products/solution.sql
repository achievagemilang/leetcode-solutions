SELECT customer_id
FROM customer c
INNER JOIN product p
    ON c.product_key = p.product_key
GROUP BY customer_id
HAVING COUNT(DISTINCT c.product_key) = (
    SELECT COUNT(*) FROM product
)
