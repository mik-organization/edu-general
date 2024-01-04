# ROUND,FLOOR,CEILING
SELECT ROUND(13.14,-1); -- 四捨五入

SELECT FLOOR(3.14); -- 切り捨て

SELECT FLOOR(3.84); -- 切り捨て

SELECT CEILING(3.14); -- 切り上げ

SELECT RAND(); # 0~1
SELECT FLOOR(RAND()*10); # 0~10

# power
SELECT POWER(3,4);

SELECT weight/POWER(height/100,2) AS BMI FROM students;

# COALESCE:NULLではない最初の値を返す
SELECT * FROM tests_score;

SELECT COALESCE(NULL,NULL,NULL,"A",NULL,"B");

SELECT COALESCE(test_score_1,test_score_2,test_score_3),test_score_1,test_score_2,test_score_3 AS score FROM test_score;