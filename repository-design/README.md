# 図書館管理システム

## 概要
Spring Boot を使用した図書館管理システムの研修用プロジェクトです。  
図書館の基本的な業務（書籍管理、利用者管理、貸出・返却、予約）をWeb APIで実現します。

## 機能
### Phase 1: 基本機能
- **書籍管理** - 書籍の登録・更新・削除・検索
- **利用者管理** - 利用者の登録・更新・削除
- **貸出管理** - 書籍の貸出・返却
- **基本検索** - タイトル・著者による検索

### Phase 2: 中級機能
- **予約機能** - 貸出中書籍の予約
- **延長機能** - 貸出期間の延長
- **履歴管理** - 貸出履歴の管理
- **在庫管理** - 複数冊管理

### Phase 3: 高度な機能
- **レポート機能** - 貸出統計・人気書籍ランキング
- **通知機能** - 返却期限通知・予約完了通知
- **API機能** - REST API の提供
- **認証・認可** - ユーザー権限管理

## 技術スタック
- **Java 17** - プログラミング言語
- **Spring Boot 3.x** - Webアプリケーションフレームワーク
- **Spring Data JPA** - データアクセス
- **MySQL 8.x** - データベース
- **Gradle** - ビルドツール
- **Eclipse IDE** - 統合開発環境

## 前提条件
- Windows 10/11
- Java 17
- Eclipse IDE for Enterprise Java and Web Developers
- MySQL 8.x
- Git

## クイックスタート
1. **リポジトリクローン**
   ```powershell
   git clone <repository-url>
   cd library-management-system
   ```

2. **データベース作成**
   ```sql
   -- MySQL Command Line Client で実行
   CREATE DATABASE library_system CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   ```

3. **アプリケーション起動**  
Eclipseからの起動でOK  
コマンドで起動する場合は下記
   ```powershell
   .\gradlew.bat bootRun
   ```

4. **動作確認**
   - アプリケーション: http://localhost:8080
   - API ドキュメント: http://localhost:8080/swagger-ui.html

## プロジェクト構成
```
edu-xxx/
├── docs/                        # ドキュメント
├── README.md                    # このファイル
└── library-management-system/
    ├── src/main/java/           # Javaソースコード
    ├── src/main/resources/      # 設定ファイル
    ├── src/test/java/           # テストコード
    ├── db/                      # データベース関連
    │   ├── docker-compose.yml
    │   └── sql/
    │       ├── 01_create_tables.sql
    │       ├── 02_insert_data.sql
    │       └── 03_additional_setup.sql
    └── build.gradle            # ビルド設定
```
## 開発用コマンド
```powershell
# ビルド
.\gradlew.bat build

# テスト実行
.\gradlew.bat test

# アプリケーション起動
.\gradlew.bat bootRun

# データベース接続確認（MySQL Command Line Client）
mysql -u root -p

# データベース選択
USE library_system;
```

## API エンドポイント
| 機能 | Method | URL | 説明 |
|------|--------|-----|------|
| 書籍一覧 | GET | `/api/books` | 書籍の一覧取得 |
| 書籍登録 | POST | `/api/books` | 新しい書籍の登録 |
| 書籍詳細 | GET | `/api/books/{id}` | 指定書籍の詳細取得 |
| 書籍更新 | PUT | `/api/books/{id}` | 書籍情報の更新 |
| 書籍削除 | DELETE | `/api/books/{id}` | 書籍の削除 |

*その他のAPIエンドポイントは開発進捗に応じて追加されます。*

## ドキュメント
- [開発ルール](docs/development/DEVELOPMENT_RULES.md) - ブランチ戦略、コミット規則等
- [セットアップガイド](docs/development/SETUP_GUIDE.md) - 詳細な環境構築手順
- [API仕様書](docs/api/API_SPECIFICATION.md) - 詳細なAPI仕様
- [データベース設計](docs/database/DATABASE_DESIGN.md) - テーブル設計・ER図

## トラブルシューティング
### よくある問題
1. **ポート3306が使用中エラー**
   ```powershell
   netstat -an | findstr 3306
   # 他のMySQLプロセスを停止してください
   ```

2. **Gradleビルドエラー**
   ```powershell
   .\gradlew.bat clean build
   ```

3. **MySQLサービスが起動しない**
   ```powershell
   # サービスの状態確認
   Get-Service -Name MySQL*
   
   # サービスの起動
   Start-Service -Name "MySQL80"
   ```

詳細なトラブルシューティングは[こちら](docs/development/TROUBLESHOOTING.md)を参照してください。

## ライセンス
このプロジェクトは研修用途のため、教育目的でのみ使用してください。

## 貢献
このプロジェクトは研修用のため、外部からのPull Requestは受け付けておりません。  
研修参加者は指定されたIssueに対してのみ貢献してください。