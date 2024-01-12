# 40.SUM,MIN,MAX,AVG,COUNT
-- 集計関数
-- SUM:数値型→合計値　文字列型→×　日付型→×  (×→実行できない)
-- MIN:数値型→最小値　文字列型→並び替えて最初の文字列　日付型→最も古い日付
-- MAX:数値型→最大値　文字列型→並び替えて最後の文字列　日付型→最も新しい日付
-- AVG:数値型→平均値　文字列型→×　日付型→×
-- COUNT:数値型→行数　文字列型→行数　日付型→行数

# COUNT:行数
-- 古いDBでCOUNTを用いる場合、COUNT(*)よりもCOUNT(主キー)の方が高速なことがある
SELECT COUNT(*) FROM customers; -- 何行データが入っているか(上記にならって*はidでもよい)
SELECT COUNT(name) FROM customers; -- 列指定(この行に何行データが入っているか(NULLはカウントしない))

SELECT COUNT(name) FROM customers WHERE id > 80;

SELECT * FROM customers;

# MAX:最大,MIN:最小
SELECT MAX(age),MIN(age) FROM users WHERE birth_place = "日本";

SELECT MAX(birth_day),MIN(birth_day) FROM users;

# SUM:合計
SELECT SUM(salary) FROM employees;

SELECT * FROM employees;
SELECT AVG(salary) FROM employees;

# AVG:平均（NULLの場合面倒）
CREATE TABLE tmp_count(
  num INT
);

SHOW TABLES;

INSERT INTO tmp_count VALUES(1);
INSERT INTO tmp_count VALUES(2);
INSERT INTO tmp_count VALUES(3);
INSERT INTO tmp_count VALUES(NULL);

SELECT * FROM tmp_count;

SELECT AVG(num) FROM tmp_count; -- (1+2+3)÷3=2

SELECT AVG(COALESCE(num,0)) FROM tmp_count; -- (1+2+3)÷4=1.5




