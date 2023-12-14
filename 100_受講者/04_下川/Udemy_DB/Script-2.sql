SELECT DATABASE();

# テーブル一覧
SHOW TABLES;

# テーブル名変更(RENAME TO)
ALTER TABLE users RENAME TO users_table;

# カラムの削除(DROP COLUMN)
ALTER TABLE users_table DROP COLUMN message;

# カラムの追加(ADD)
ALTER TABLE users_table ADD post_code CHAR(8);

# 指定したカラムの後ろにカラムを新規追加
ALTER TABLE users_table ADD gender CHAR(1) AFTER age;

# 一番最初にカラムを追加
ALTER TABLE users_table ADD new_id INT FIRST;

ALTER TABLE users_table DROP COLUMN new_id;

# カラムの定義変更
ALTER TABLE users_table MODIFY name VARCHAR(50);

# カラム名の変更
ALTER TABLE users_table CHANGE COLUMN name 名前 VARCHAR(50);

# すでに追加済みのカラムの場所変更
ALTER TABLE users_table CHANGE COLUMN gender gender CHAR(1) AFTER post_code;

# 主キーの削除
ALTER TABLE users_table DROP PRIMARY KEY;

# 定義状況の確認
DESCRIBE users_table;