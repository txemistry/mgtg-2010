CREATE DATABASE IF NOT EXISTS ptDB;
USE ptDB;

--
-- Create USERS
--

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP
           ON ptDB.*
           TO eside@'%'
           IDENTIFIED BY 'eside';

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP
           ON ptDB.*
           TO eside@localhost
           IDENTIFIED BY 'eside';