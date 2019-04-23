-- Postgres dialect

ALTER TABLE pets
  DROP COLUMN IF EXISTS type;

ALTER TABLE pets
  ADD type VARCHAR DEFAULT 'Animal';