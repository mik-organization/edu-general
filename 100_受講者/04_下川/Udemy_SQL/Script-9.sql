SELECT DATABASE();

DESCRIBE customers;

# IS NULLでないと取り出せない
SELECT * FROM customers WHERE name IS NULL;

SELECT NULL = NULL;
SELECT NULL IS NULL;

# IS NOT NULL
SELECT * FROM customers WHERE name IS NOT NULL;

SELECT * FROM prefectures;

SELECT * FROM prefectures WHERE name IS NULL;

SELECT * FROM prefectures WHERE name = '';

# BETWEEN,NOT BETWEEN
SELECT * FROM users WHERE age NOT BETWEEN 5 AND 10;

# LIKE,NOT LIKE
SELECT * FROM users WHERE name LIKE "村%"; -- 前方一致

SELECT * FROM users WHERE name LIKE "%郎"; -- 後方一致

SELECT * FROM users WHERE name LIKE "%ed%"; -- 中間一致

SELECT * FROM prefectures WHERE name LIKE "福_%" ORDER BY name; -- _は任意の一文字

