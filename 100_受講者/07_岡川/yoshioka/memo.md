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

# git branchイメージ


       issuexx  -> 
        ↑         ↓
main ->           main ->
  ↓                       ↑
  issue13 ->                    


  # mybatis

  MavenやGradleを使用しない場合、MyBatisとその依存関係を手動で設定する必要があります。以下の手順に従ってください。

1. 必要なライブラリをダウンロード
MyBatisおよび使用するJDBCドライバのJARファイルをダウンロードします。

MyBatis
MySQL Connector/J（MySQLを使用する場合）
2. プロジェクトのディレクトリ構造
以下のようなディレクトリ構造を作成します。

bash
コードをコピーする
mybatis-example/
├── lib/
│   ├── mybatis-3.5.7.jar
│   ├── mysql-connector-java-8.0.23.jar
│   └── その他必要なJARファイル
├── src/
│   ├── com/example/Main.java
│   ├── com/example/mappers/UserMapper.java
│   ├── com/example/models/User.java
│   └── mybatis-config.xml
└── mybatis-example.bat (Windowsの場合)
└── mybatis-example.sh (Linux/Macの場合)
3. mybatis-config.xml の作成
設定ファイルを src/mybatis-config.xml に作成します。

xml
コードをコピーする
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mydatabase"/>
                <property name="username" value="root"/>
                <property name="password" value="password"/>
            </dataSource>
        </environment>
    </environments>

    <mappers>
        <mapper resource="com/example/mappers/UserMapper.xml"/>
    </mappers>
</configuration>
4. マッパーインターフェースの作成
src/com/example/mappers/UserMapper.java にマッパーインターフェースを作成します。

java
コードをコピーする
package com.example.mappers;

import com.example.models.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT * FROM users WHERE id = #{id}")
    User getUserById(int id);
}
5. マッパーXMLファイルの作成
src/com/example/mappers/UserMapper.xml にマッパーXMLファイルを作成します。

xml
コードをコピーする
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.example.mappers.UserMapper">
    <select id="getUserById" parameterType="int" resultType="com.example.models.User">
        SELECT * FROM users WHERE id = #{id}
    </select>
</mapper>
6. データモデルの作成
src/com/example/models/User.java にデータモデルクラスを作成します。

java
コードをコピーする
package com.example.models;

public class User {
    private int id;
    private String name;
    private String email;

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
7. メインクラスの作成
src/com/example/Main.java にメインクラスを作成します。

java
コードをコピーする
package com.example;

import com.example.mappers.UserMapper;
import com.example.models.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load MyBatis configuration file.", e);
        }

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.getUserById(1);
            System.out.println("User ID: " + user.getId());
            System.out.println("User Name: " + user.getName());
            System.out.println("User Email: " + user.getEmail());
        }
    }
}
8. 実行スクリプトの作成
コンパイルと実行を行うためのスクリプトを作成します。

Windows (mybatis-example.bat)
bat
コードをコピーする
@echo off
set CLASSPATH=lib\mybatis-3.5.7.jar;lib\mysql-connector-java-8.0.23.jar;lib\その他の必要なJARファイル
javac -cp %CLASSPATH% -d out src/com/example/models/User.java src/com/example/mappers/UserMapper.java src/com/example/Main.java
java -cp out;%CLASSPATH% com.example.Main
Linux/Mac (mybatis-example.sh)
sh
コードをコピーする
#!/bin/bash
CLASSPATH=lib/mybatis-3.5.7.jar:lib/mysql-connector-java-8.0.23.jar:lib/その他の必要なJARファイル
mkdir -p out
javac -cp $CLASSPATH -d out src/com/example/models/User.java src/com/example/mappers/UserMapper.java src/com/example/Main.java
java -cp out:$CLASSPATH com.example.Main
9. 実行
スクリプトを実行してアプリケーションをコンパイルし、実行します。

Windows
cmd
コードをコピーする
mybatis-example.bat
Linux/Mac
sh
コードをコピーする
chmod +x mybatis-example.sh
./mybatis-example.sh
これで、MyBatisを使用してJavaコンソールアプリケーションでデータベースアクセスができるようになります。必要なライブラリを手動で管理し、スクリプトを使用してコンパイルおよび実行することで、MavenやGradleなしでMyBatisを導入することができます。