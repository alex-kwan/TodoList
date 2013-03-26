# Tasks schema
 
# --- !Ups

CREATE SEQUENCE task_id_seq;
CREATE SEQUENCE user_id_seq;
CREATE TABLE task (
    id integer NOT NULL DEFAULT nextval('task_id_seq'),
    label varchar(255)
);

CREATE TABLE user (
    id integer NOT NULL DEFAULT nextval('user_id_seq'),
    label varchar(255)
);
 
# --- !Downs
 
DROP TABLE task;
DROP SEQUENCE task_id_seq;

DROP TABLE user;
DROP SEQUENCE user_id_seq;