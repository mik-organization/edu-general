# 38.39.INTERSECT,EXCEPT
-- リレーショナルデータベースにおいて使われるセット演算子
-- INTERSECT演算子:複数のクエリの結果セットの共通の行を返す
-- EXCEPT演算子:左側のクエリの結果から右側のクエリの結果を差し引いた結果を返す

# カラム数を合わせないとエラーになる

USE day_4_9_db;

# INTERSECT:重複を表示する
SELECT * FROM new_students
INTERSECT
SELECT * FROM students;

# EXCEPT:new_studentsに存在して、studentsに存在しない
SELECT * FROM new_students
EXCEPT
SELECT * FROM students;

# EXCEPT:studentsに存在して、new_studentsに存在しない
SELECT * FROM new_students
EXCEPT
SELECT * FROM students;

# どちらかに存在する
(SELECT * FROM new_students
EXCEPT
SELECT * FROM students)
UNION ALL
(SELECT * FROM new_students
EXCEPT
SELECT * FROM students)
ORDER BY id;

SELECT * FROM students WHERE id < 10
EXCEPT
SELECT * FROM new_students WHERE id < 10;

SELECT * FROM students WHERE id < 10
INTERSECT
SELECT * FROM new_students WHERE id < 10;
