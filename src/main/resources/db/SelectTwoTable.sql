-- Postgres dialect

SELECT u.name, u.email, adr.country, r.role
FROM users u,
     address adr,
     roles r
WHERE u.id = adr.user_id
  AND u.id = r.user_id;

SELECT u.registered, u.name, c.name, c.release_year, p.name, p.birthday
FROM users u,
     cars c,
     pets p
WHERE u.registered BETWEEN '6/3/2014' AND '30/1/2020'
  AND c.release_year BETWEEN '6/3/2014' AND '30/1/2020'
  AND p.birthday BETWEEN '6/3/2014' AND '30/1/2020';

SELECT u.name, u.email, r.role
FROM users u,
     roles r
WHERE u.id = r.user_id
  AND u.id = (SELECT id FROM users WHERE email = 'admin@gmail.com');