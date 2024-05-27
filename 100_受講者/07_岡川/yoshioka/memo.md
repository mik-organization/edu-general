# javaアプリを動かす環境構築
* mysqlインストール
  * ユーザ root パスワード 9qg3ypnusql
  * パスワード変更手順は、https://qiita.com/bonny_d/items/58ec2c1c21dafbe3869e
* mysql jdbcドライバーをダウンロードして、プロジェクトに追加
  * https://dev.mysql.com/downloads/connector/j/
  * Platform Independent (Architecture Independent), ZIP Archive　を選択
  * 参考サイト
  https://qiita.com/Yuriko-Y/items/d4c5cb29780ce0347375
  * プロジェクト－プロパティ－javaのビルドパス－ライブラリ－jarの追加
  で、ダウンロードしたjarファイルを追加