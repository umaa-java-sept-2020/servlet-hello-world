CREATE DATABASE IF NOT EXISTS testdb;
show databases;
USE testdb;
CREATE TABLE TBL_USER(
UUID VARCHAR(100),
EMAIL VARCHAR(100) UNIQUE,
FULLNAME VARCHAR(100),
PASSWORD VARCHAR(100)
);