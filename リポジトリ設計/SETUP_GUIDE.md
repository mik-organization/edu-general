# セットアップガイド

このガイドでは、図書館管理システムの開発環境を Windows 上で構築する詳細な手順を説明します。

## 前提条件

### システム要件
<<<<<<< HEAD
- **OS**: Windows 10 または Windows 11
=======
- **OS**: Windows 10 (または Windows 11
>>>>>>> 8b66408cee739ec818c71ba47e0b4d2a488f27e7
- **RAM**: 8GB以上推奨
- **ディスク容量**: 10GB以上の空き容量
- **ネットワーク**: インターネット接続（パッケージダウンロード用）

### 必要なソフトウェア
以下のソフトウェアが事前にインストールされている必要があります：
- Git for Windows
- MySQL 8.x
- Java 17 (OpenJDK推奨)

---

## 1. Eclipse IDE セットアップ

### 1.1 Eclipse のダウンロード・インストール
1. [Eclipse公式サイト](https://www.eclipse.org/downloads/) にアクセス
2. **Eclipse IDE for Enterprise Java and Web Developers** をダウンロード
3. ダウンロードしたインストーラーを実行
4. インストール先ディレクトリを指定（例：`C:\eclipse`）
5. ワークスペースディレクトリを指定（例：`C:\workspace`）

### 1.2 JDK 17 の設定確認
1. Eclipse起動後、`Window` → `Preferences`
2. `Java` → `Installed JREs` を選択
3. Java 17 が登録されていることを確認
4. 未登録の場合は `Add...` をクリックして追加

```
JRE Type: Standard VM
JRE Home: C:\Program Files\Eclipse Adoptium\jdk-17.x.x.x-hotspot
JRE Name: java-17-openjdk
```

### 1.3 Google Java Format プラグインのインストール

#### 手動インストール方法
1. [google-java-format リリースページ](https://github.com/google/google-java-format/releases) にアクセス
2. 最新版の `google-java-format-eclipse-plugin-x.xx.x.jar` をダウンロード
3. Eclipse の `plugins` ディレクトリに配置
   ```
   C:\eclipse\plugins\google-java-format-eclipse-plugin-x.xx.x.jar
   ```

#### eclipse.ini の設定
4. Eclipse の `eclipse.ini` ファイルを編集
   ```
   C:\eclipse\eclipse.ini
   ```
5. ファイル末尾に以下を追記：
   ```ini
   --add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED
   --add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED
   --add-exports=jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED
   --add-exports=jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED
   --add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED
   --add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED
   ```

#### プラグインの有効化
6. Eclipse を再起動
7. `Window` → `Preferences` → `Java` → `Code Style` → `Formatter`
8. **Formatter implementation** で `google-java-format` を選択
9. `Apply and Close` をクリック

### 1.4 Gradle Buildship プラグイン確認
1. `Help` → `Eclipse Marketplace`
2. `Buildship Gradle Integration` が Installed になっていることを確認
3. 未インストールの場合はインストール

### 1.5 Git 統合設定
1. `Window` → `Preferences` → `Team` → `Git`
2. **Default repository folder** を設定（例：`C:\git`）
3. `Configuration` タブで以下を設定：
   ```
   user.name: [あなたの名前]
   user.email: [あなたのメールアドレス]
   ```

---

## 2. プロジェクトセットアップ
### 2.2 Gradle プロジェクトとして設定
1. プロジェクト右クリック → `Configure` → `Add Gradle Nature`
2. `Gradle` → `Refresh Gradle Project`

#### プロジェクト設定の確認
1. プロジェクト右クリック → `Properties`
2. `Java Build Path` → `Libraries` → `Classpath` を確認
3. Java 17 が設定されていることを確認
4. `Project Facets` で以下が有効になっていることを確認：
   - Java 17
   - Spring Boot

### 2.3 プロジェクト初期構成の作成

#### Spring Boot プロジェクトの作成
1. [Spring Initializr](https://start.spring.io/) にアクセス
2. 以下の設定で生成：
   ```
   Project: Gradle Project
   Language: Java
   Spring Boot: 3.2.x
   Packaging: Jar
   Java: 17
   
   Dependencies:
   - Spring Web
   - Spring Data JPA
   - MySQL Driver
   - Spring Boot DevTools
   - Spring Boot Actuator
   - Validation
   ```
3. `GENERATE` をクリックしてダウンロード
4. 既存プロジェクトに必要ファイルをコピー

#### build.gradle の調整
```gradle
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.2.0'
    id 'io.spring.dependency-management' version '1.1.4'
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'

java {
    sourceCompatibility = '17'
}

configurations {
    compileOnly {
        extendsFrom annotationProcessor
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-validation'
    implementation 'org.springframework.boot:spring-boot-starter-actuator'
    
    // Database
    runtimeOnly 'com.mysql:mysql-connector-j'
    
    // Development
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    
    // Documentation
    implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0'
    
    // Testing
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'com.h2database:h2' // テスト用インメモリDB
    
    // Annotation Processing
    annotationProcessor 'org.springframework.boot:spring-boot-configuration-processor'
}

tasks.named('test') {
    useJUnitPlatform()
}
```

---

## 3. MySQL 環境構築

### 3.1 MySQL サービスの確認
1. Windows サービスで MySQL が起動していることを確認
   ```powershell
   Get-Service -Name MySQL*
   ```
2. サービスが停止している場合は起動
   ```powershell
   Start-Service -Name "MySQL80"
   ```

### 3.2 データベースとユーザーの作成

#### MySQL Command Line Client での操作
```sql
-- rootユーザーでログイン
mysql -u root -p

-- データベース作成
CREATE DATABASE library_system CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 開発用ユーザー作成
CREATE USER 'dev_user'@'localhost' IDENTIFIED BY 'dev_password';

-- 権限付与
GRANT ALL PRIVILEGES ON library_system.* TO 'dev_user'@'localhost';
FLUSH PRIVILEGES;

-- 確認
SHOW DATABASES;
USE library_system;
```

### 3.3 初期化スクリプトの作成
`sql/init/init-db.sql` を作成：
```sql
-- 初期化スクリプト
USE library_system;

-- 文字コード設定
SET NAMES utf8mb4;
SET CHARACTER SET utf8mb4;

-- タイムゾーン設定（オプション）
SET time_zone = '+09:00';
```

### 3.4 接続テスト
```powershell
# 開発用ユーザーで接続
mysql -u dev_user -p -D library_system

# 接続確認
mysql> SELECT DATABASE();
mysql> SHOW TABLES;
mysql> exit
```

---

## 4. アプリケーション設定

### 4.1 application.yml の設定
`src/main/resources/application.yml` を作成：
```yaml
spring:
  application:
    name: library-management-system
  
  datasource:
    url: jdbc:mysql://localhost:3306/library_system?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Tokyo&characterEncoding=UTF-8
    username: dev_user
    password: dev_password
    driver-class-name: com.mysql.cj.jdbc.Driver
  
  jpa:
    hibernate:
      ddl-auto: create-drop  # 開発時のみ
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL8Dialect
        format_sql: true
        jdbc:
          batch_size: 20
  
  devtools:
    restart:
      enabled: true
    livereload:
      enabled: true

server:
  port: 8080

logging:
  level:
    com.example.library: DEBUG
    org.springframework.web: DEBUG
    org.hibernate.SQL: DEBUG

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics
```

### 4.2 プロファイル別設定

#### application-dev.yml
```yaml
spring:
  jpa:
    hibernate:
      ddl-auto: create-drop
    show-sql: true

logging:
  level:
    root: DEBUG
```

#### application-prod.yml
```yaml
spring:
  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: false

logging:
  level:
    root: WARN
    com.example.library: INFO
```

---

## 5. Eclipse での開発設定

### 5.1 Gradle Tasks ビューの設定
1. `Window` → `Show View` → `Other`
2. `Gradle` → `Gradle Tasks` を選択
3. プロジェクトのタスクが表示されることを確認

### 5.2 実行設定 (Run Configuration)

#### アプリケーション実行設定
1. プロジェクト右クリック → `Run As` → `Run Configurations`
2. `Java Application` を右クリック → `New Configuration`
3. 以下を設定：
   ```
   Name: Library Management System
   Project: library-management-system
   Main class: com.example.library.LibraryApplication
   ```
4. `Arguments` タブで VM arguments を設定：
   ```
   -Dspring.profiles.active=dev
   ```

#### Gradle Task 実行設定
1. `Gradle Project` を右クリック → `New Configuration`
2. 以下を設定：
   ```
   Name: Gradle bootRun
   Gradle Tasks: bootRun
   ```

### 5.3 デバッグ設定
1. Eclipse で `Debug Configurations` を開く
2. `Remote Java Application` を作成
3. 以下を設定：
   ```
   Project: library-management-system
   Connection Type: Standard (Socket Attach)
   Host: localhost
   Port: 5005
   ```

---

## 6. 動作確認

### 6.1 ビルドテスト
```powershell
# プロジェクトルートディレクトリで実行
.\gradlew.bat build
```

### 6.2 アプリケーション起動テスト
```powershell
# MySQLサービス確認
Get-Service -Name MySQL*

# アプリケーション起動
.\gradlew.bat bootRun
```

### 6.3 動作確認
1. **アプリケーションログ確認**
   - コンソールに Spring Boot の起動ログが表示されること
   - エラーなく起動完了すること

2. **ヘルスチェック**
   ```
   http://localhost:8080/actuator/health
   ```

3. **Swagger UI 確認**
   ```
   http://localhost:8080/swagger-ui.html
   ```

### 6.4 Eclipse での実行確認
1. Eclipse で `Run As` → `Java Application`
2. `LibraryApplication` を選択
3. Console ビューで起動ログを確認
4. ブラウザで動作確認

---

## 7. 開発用ツール設定

### 7.1 Talend API Tester
1. [Talend API Tester](https://chrome.google.com/webstore/detail/talend-api-tester-free-ed/aejoelaoggembcahagimdiliamlcdmfm) をChromeにインストール
2. 新しいプロジェクトを作成：`Library Management System`
3. Base URL を設定：`http://localhost:8080`

### 7.2 データベース管理ツール（オプション）

#### A5:SQL Mk-2 の設定
※ セットアップ方法は別途提供されている Readme_mysql.md を参照

#### MySQL Workbench のインストール（代替案）
1. [MySQL公式サイト](https://dev.mysql.com/downloads/workbench/) からダウンロード
2. インストール後、新しい接続を追加：
   ```
   Connection Name: Library System
   Hostname: localhost
   Port: 3306
   Username: dev_user
   Password: dev_password
   Default Schema: library_system
   ```

---

## 8. トラブルシューティング

### 8.1 よくある問題と解決方法

#### Java 関連
**問題**: `JAVA_HOME is not set`
```powershell
# 環境変数の確認
echo $env:JAVA_HOME

# 設定されていない場合
[Environment]::SetEnvironmentVariable("JAVA_HOME", "C:\Program Files\Eclipse Adoptium\jdk-17.x.x.x-hotspot", "User")
```

#### MySQL 関連
**問題**: `Access denied for user 'dev_user'@'localhost'`
```sql
-- rootユーザーで再度権限付与
GRANT ALL PRIVILEGES ON library_system.* TO 'dev_user'@'localhost';
FLUSH PRIVILEGES;
```

**問題**: `Communications link failure`
```yaml
# application.yml のURL設定を確認
# useSSL=false と allowPublicKeyRetrieval=true を追加
url: jdbc:mysql://localhost:3306/library_system?useSSL=false&allowPublicKeyRetrieval=true
```

**問題**: 文字化けが発生する
```yaml
# application.yml に文字エンコーディング設定を追加
url: jdbc:mysql://localhost:3306/library_system?characterEncoding=UTF-8
```

#### Eclipse 関連
**問題**: プロジェクトがインポートできない
1. `.metadata` フォルダを削除してワークスペースを初期化
2. Eclipse を管理者権限で実行
3. Gradle プロジェクトとして再インポート

#### Gradle 関連
**問題**: `gradlew.bat` が実行できない
```powershell
# 実行権限の確認・設定
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser

# Gradle Wrapper の再生成
gradle wrapper
```

### 8.2 ログ確認方法

#### アプリケーションログ
```powershell
# Eclipseコンソールまたは
.\gradlew.bat bootRun --debug
```

#### MySQLログ
```sql
-- エラーログの場所確認
SHOW VARIABLES LIKE 'log_error';

-- 一般ログの有効化（デバッグ用）
SET GLOBAL general_log = 'ON';
SET GLOBAL general_log_file = 'C:/ProgramData/MySQL/MySQL Server 8.0/Data/general.log';
```

---

## 9. 開発環境の最適化

### 9.1 Eclipse パフォーマンス設定
`eclipse.ini` に以下を追加：
```ini
-Xms512m
-Xmx2048m
-XX:MaxPermSize=256m
```

### 9.2 Git 設定最適化
```powershell
# 改行コード自動変換（Windows）
git config --global core.autocrlf true

# Git エディタ設定
git config --global core.editor "notepad"

# プッシュ設定
git config --global push.default simple
```

### 9.3 Gradle 設定最適化
`gradle.properties` ファイルを作成：
```properties
# Gradle Daemon
org.gradle.daemon=true

# 並列ビルド
org.gradle.parallel=true

# メモリ設定
org.gradle.jvmargs=-Xmx2048m -XX:MaxPermSize=512m
```

---

## 10. 次のステップ

環境構築が完了したら、以下の手順で開発を開始してください：

1. [開発ルール](DEVELOPMENT_RULES.md) を熟読
2. Issue #1 (プロジェクト初期設定) から開始
3. 作業前に必ずブランチを作成
4. 定期的にコミット・プッシュを実行

### 学習リソース
- [Spring Boot Reference Documentation](https://spring.io/projects/spring-boot#learn)
- [Spring Data JPA Documentation](https://spring.io/projects/spring-data-jpa#learn)
- [MySQL Documentation](https://dev.mysql.com/doc/)
- [Gradle User Manual](https://docs.gradle.org/current/userguide/userguide.html)

---

## サポート

セットアップで困った場合は、以下の順序で対応してください：

1. **このドキュメントの再確認**
2. **トラブルシューティングセクションの確認**
3. **Issue を作成して質問**（ラベル: `question`）
4. **メンターに相談**

質問する際は、以下の情報を含めてください：
- 実行したコマンド
- エラーメッセージの全文
- 環境情報（OS、Java バージョン等）
- 試行した解決方法
