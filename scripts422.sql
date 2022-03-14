CREATE TABLE people(
                       id integer PRIMARY KEY
    ,fio varchar(150) NOT NULL
    ,age integer check (age>0) DEFAULT 0
    ,driving_license bool DEFAULT false
);
CREATE TABLE auto(
                     id integer primary key
    ,name varchar(100) NOT NULL
    ,model varchar(100) DEFAULT ''
    ,price numeric(16,2) DEFAULT 0
);

ALTER TABLE people ADD COLUMN auto_id integer REFERENCES auto (id);