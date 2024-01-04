SHOW TABLES;

DESCRIBE people;

ALTER TABLE people ADD age INT AFTER name;

INSERT people VALUES(1,"John",18,"2001-01-01");
INSERT people VALUES(2,"Alice",15,"2003-01-01");
INSERT people VALUES(3,"Paul",19,"2000-01-01");
INSERT people VALUES(4,"Chris",17,"2001-01-01");
INSERT people VALUES(5,"Vette",20,"2001-01-01");
INSERT people VALUES(6,"Tsuyoshi",21,"2001-01-01");

SELECT * FROM people;

# ageで昇順(ASC)
SELECT * FROM people ORDER BY age;

# ageで降順(DESC)
SELECT * FROM people ORDER BY age DESC;

# nameで昇順
SELECT * FROM people ORDER BY name;

# nameで降順
SELECT * FROM people ORDER BY name DESC;

# 2つのカラム
SELECT * FROM people ORDER BY birth_day ,name;

SELECT * FROM people ORDER BY birth_day,name DESC;

SELECT * FROM people ORDER BY birth_day DESC,name;


SELECT * FROM people ORDER BY birth_day DESC,name DESC,age ASC;

# DISNTICT(重複を削除して表示)
SELECT DISTINCT birth_day FROM people ORDER BY birth_day;

SELECT DISTINCT name,birth_day FROM people;

# LIMIT(最初の行だけ表示)
SELECT * FROM people LIMIT 3;

SELECT id,name,age FROM people LIMIT 3;

# 飛ばして表示(3飛ばし2表示)
SELECT * FROM people LIMIT 3,2;
SELECT * FROM people LIMIT 2 OEESET 3;