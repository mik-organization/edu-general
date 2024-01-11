# UNION、UNION ALL　2つのSQLの実行結果を両方向につなげる

SHOW DATABASES;
USE day_4_9_db;

# UNION:重複を削除する
SELECT * FROM new_students
UNION
SELECT * FROM students;

# ORDER BYでidの並び変え
SELECT * FROM new_students
UNION
SELECT * FROM students
ORDER BY id;

# UNION ALL:重複を削除しない
SELECT * FROM new_students
UNION ALL
SELECT * FROM students;

# ORDER BYでidの並び変え
SELECT * FROM new_students
UNION ALL
SELECT * FROM students
ORDER BY id;

SELECT * FROM students WHERE id < 10
UNION ALL
SELECT * FROM new_students WHERE id > 250;

SELECT id,name FROM students WHERE id < 10
UNION
SELECT age,name FROM users WHERE id < 10
ORDER BY age;

SELECT id,name,height FROM students
UNION
SELECT age,name FROM users;



