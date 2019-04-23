-- Postgres dialect

DELETE FROM cars WHERE speed NOT BETWEEN 200 AND 500;

UPDATE pets SET name = 'leon' WHERE name LIKE '%at';

UPDATE address SET country = 'Belarus', city = 'Gomel', street = 'Lenin Ave', house = '3' WHERE country = 'Russia';