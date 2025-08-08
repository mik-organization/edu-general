# セットアップガイド

このガイドでは、図書館管理システムの開発環境を Windows 上で構築する詳細な手順を説明します。

## 前提条件

### システム要件
- **OS**: Windows 10 (または Windows 11
- **RAM**: 8GB以上推奨
- **ディスク容量**: 10GB以上の空き容量
- **ネットワーク**: インターネット接続（パッケージダウンロード用）

### 必要なソフトウェア
以下のソフトウェアが事前にインストールされている必要があります：
- Git for Windows
- Docker Desktop for Windows
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
   - PostgreSQL Driver
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
    runtimeOnly 'org.postgresql:postgresql'
    
    // Development
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    
    // Documentation
    implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0'
    
    // Testing
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'org.testcontainers:junit-jupiter'
    testImplementation 'org.testcontainers:postgresql'
    
    // Annotation Processing
    annotationProcessor 'org.springframework.boot:spring-boot-configuration-processor'
}

tasks.named('test') {
    useJUnitPlatform()
}
```

---

## 3. データベース環境構築

### 3.1 Docker Desktop の確認
1. Docker Desktop が起動していることを確認
2. タスクトレイの Docker アイコンが `Running` 状態であることを確認

### 3.2 PostgreSQL 設定ファイルの作成

#### db/compose.yaml の作成
```yaml
version: '3.8'
services:
  postgres:
    image: postgres:15
    container_name: library_postgres
    environment:
      POSTGRES_DB: library_system
      POSTGRES_USER: dev_user
      POSTGRES_PASSWORD: dev_password
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data
      - ./scripts:/docker-entrypoint-initdb.d
    restart: unless-stopped

volumes:
  postgres_data:
```

#### 初期化スクリプトの作成
`db/scripts/init-db.sql` を作成：
```sql
-- 初期化スクリプト
CREATE SCHEMA IF NOT EXISTS library;

-- データベースの初期設定
SET timezone = 'Asia/Tokyo';
```

### 3.3 PostgreSQL の起動確認
1. PowerShell で db ディレクトリに移動
   ```powershell
   cd C:\workspace\library-management-system\db
   ```
2. Docker Compose で PostgreSQL を起動
   ```powershell
   docker compose up -d
   ```
3. コンテナの状態確認
   ```powershell
   docker compose ps
   ```
4. ログの確認
   ```powershell
   docker compose logs postgres
   ```

### 3.4 データベース接続テスト
```powershell
# PostgreSQL に接続
docker compose exec postgres psql -U dev_user -d library_system

# 接続確認クエリ
\l
\q
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
    url: jdbc:postgresql://localhost:5432/library_system
    username: dev_user
    password: dev_password
    driver-class-name: org.postgresql.Driver
  
  jpa:
    hibernate:
      ddl-auto: create-drop  # 開発時のみ
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true
        jdbc:
          lob:
            non_contextual_creation: true
  
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
# データベース起動
cd db
docker compose up -d
cd ..

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
#### pgAdmin のインストール
1. [pgAdmin公式サイト](https://www.pgadmin.org/download/pgadmin-4-windows/) からダウンロード
2. インストール後、新しいサーバーを追加：
   ```
   Host: localhost
   Port: 5432
   Database: library_system
   Username: dev_user
   Password: dev_password
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

#### Docker 関連
**問題**: `Error response from daemon: driver failed programming external connectivity`
```powershell
# ポート5432が使用されているか確認
netstat -an | findstr 5432

# 使用プロセスを停止
taskkill /F /PID <プロセスID>
```

**問題**: Docker Desktop が起動しない
1. Windows の仮想化機能が有効か確認
2. WSL2 が正しくインストールされているか確認
3. Docker Desktop を管理者権限で実行

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

#### データベースログ
```powershell
cd db
docker compose logs -f postgres
```

#### Docker システムログ
```powershell
docker system events
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
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)
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
