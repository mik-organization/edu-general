SHOW DATABASES;

CREATE DATABASE my_db;

SHOW DATABASES; #DB一覧を表示する

# DBの削除
DROP DATABASE my_db;

# performance_schemaを利用する
USE performance_schema;

# 利用中のDBの表示
SELECT DATABASE();

USE my_db;
