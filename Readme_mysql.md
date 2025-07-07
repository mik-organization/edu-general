# MySqlのインストールと設定
## MySqlのインストール
  * mysqlインストール [参考サイト](https://qiita.com/aki_number16/items/bff7aab79fb8c9657b62)
    * version：8.4.2 LTS
      
      ![alt text](Readme_mysqlimages/Readme_mysql.png)  
  * MySQL Configuratorを起動後
    * 基本はそのままnext
      ![alt text](Readme_mysqlimages/Readme_mysql-1.png)    
    * Root Account Password  パスワードは"root"
      ![alt text](Readme_mysqlimages/Readme_mysql-2.png)
  * インストール後の確認
    * MySQL x.x Command Line Client を起動し、rootユーザのパスワードを入力してログインできればOK
      ![alt text](Readme_mysqlimages/Readme_mysql-3.png)
  * データベース"mik"の作成
    * 現在の データベースの確認
      
      ![alt text](Readme_mysqlimages/Readme_mysql-4.png)
      
    * データベースの追加、確認
      コマンドは "create database mik;" に置き換える  
      コマンド実行後、"mik"が作成されていればOK  
      
      ![alt text](Readme_mysqlimages/Readme_mysql-5.png)
## A5のインストールと設定
### A5のインストール
* A5のインストール [参考サイト](https://www.a5m2.mmatsubara.com/)
### A5の設定
  * A5を開き、「データベース」を右クリック、「データベースの追加と削除」
    
    ![alt text](Readme_mysqlimages/Readme_mysql-6.png)
    
  * 「MY SQL」を選択
    
    ![alt text](Readme_mysqlimages/Readme_mysql-7.png)
    
  * rootのパスワード。データベース名を選択
    データベースは"mik"を入力

    ![alt text](Readme_mysqlimages/Readme_mysql-8.png)
    
  * 別名を登録
    
    ![alt text](Readme_mysqlimages/Readme_mysql-9.png)
    
  * パスワード入力後、以下のように表示される
    
    ![alt text](Readme_mysqlimages/Readme_mysql-10.png)


# その他mysql関連
* mysql ログインの仕方
  * mysql -u admin -p
  * admin

# MySQL Shell
```
 MySQL  JS > \sql
Switching to SQL mode... Commands end with ;
 MySQL  SQL > \connect root@localhost:3306
Creating a session to 'root@localhost:3306'
Please provide the password for 'root@localhost:3306': ****
Save password for 'root@localhost:3306'? [Y]es/[N]o/Ne[v]er (default No): N
Fetching global names for auto-completion... Press ^C to stop.
Your MySQL connection id is 15
Server version: 8.0.42 MySQL Community Server - GPL
No default schema selected; type \use <schema> to set one.
 MySQL  localhost:3306 ssl  SQL > show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
4 rows in set (0.0016 sec)
```
