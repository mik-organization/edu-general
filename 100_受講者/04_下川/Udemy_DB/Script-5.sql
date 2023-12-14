SHOW TABLES;

# 全レコード、全カラム
SELECT * FROM people;

# カラム一部
SELECT name,id,birth_day,name FROM people;

# 名前を付け替えて表示
SELECT id AS "番号",name AS "名前" FROM people;

# WHERE句
SELECT * FROM people WHERE id=3;

# UPDATE文
UPDATE people SET birth_day="1900-01-01";

SELECT * FROM people;

# UPDATE where
UPDATE people SET name = "Taro",birth_day = "2000-01-01" WHERE id = 3;

UPDATE people SET name = "Jiro",birth_day = "2000-01-01" WHERE id = 4;

# DELETE:レコード削除
DELETE FROM people WHERE id = 2;

DELETE FROM people WHERE id>4;

# 全て削除
DELETE FROM people;



