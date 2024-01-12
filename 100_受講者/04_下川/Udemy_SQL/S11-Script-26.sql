# 43.テーブル名に別名を付けて参照する


SHOW DATABASES;

CREATE DATABASE day_10_14_db;

USE day_10_14_db;

SHOW TABLES;

# テーブルに別名をつける
SELECT
  cs_2.id,
  cs_2.name
FROM 
  classes AS cs_2;