  CREATE TABLE IF NOT EXISTS users
  (
      ID               SERIAL PRIMARY KEY,
      NAME    VARCHAR(50) NOT NULL,
      EMAIL          VARCHAR(50) NOT NULL
  );