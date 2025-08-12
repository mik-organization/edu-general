#!/bin/bash
# GitHub CLI を使用したIssue一括作成スクリプト
# 使用方法: ./create-issues.sh [owner/repo]

REPO=$1

if [ -z "$REPO" ]; then
    echo "使用方法: ./create-issues.sh [owner/repo]"
    echo "例: ./create-issues.sh myusername/library-management-system"
    exit 1
fi

echo "リポジトリ $REPO にIssueを作成します..."

# Phase 1: 環境構築・基盤 (Issue #1-10)

gh issue create --repo $REPO \
  --title "プロジェクト初期設定・Eclipse環境構築" \
  --body "## 目的
Eclipse + Spring Boot + Gradle の基本環境理解

## 作業内容
- [ ] Spring Boot プロジェクト作成（Spring Initializr）
- [ ] Eclipse への Gradle プロジェクトインポート
- [ ] Gradle 設定ファイル（build.gradle）理解
- [ ] Eclipse での Gradle タスク実行方法
- [ ] JDK 17 設定確認
- [ ] Google Java Format プラグイン設定
- [ ] application.yml 設定
- [ ] プロジェクト構造の理解
- [ ] README.md 作成

## 受け入れ条件
- [ ] Spring Boot アプリケーションが起動すること
- [ ] Eclipse で Gradle タスクが実行できること
- [ ] Google Java Format が適用されること
- [ ] README.md に基本的な説明が記載されていること" \
  --label "enhancement" \
  --label "Phase1"

gh issue create --repo $REPO \
  --title "MySQL データベース設定" \
  --body "## 目的
MySQL・JPA設定の理解

## 作業内容
- [ ] MySQL データベース作成
- [ ] MySQL ユーザー作成と権限設定
- [ ] application.yml でデータベース接続設定
- [ ] JPA 設定（DDL auto, naming strategy等）
- [ ] 初期データ投入スクリプト（data.sql）作成
- [ ] 文字コード設定（UTF-8/utf8mb4）の確認

## 受け入れ条件
- [ ] MySQL に接続できること
- [ ] JPA エンティティからテーブルが自動生成されること
- [ ] 日本語データが正しく保存・取得できること" \
  --label "enhancement" \
  --label "Phase1"

gh issue create --repo $REPO \
  --title "Book エンティティ作成" \
  --body "## 目的
JPA エンティティの基本理解

## 作業内容
- [ ] Book エンティティクラス作成
- [ ] アノテーション設定 (@Entity, @Id, @Column)
- [ ] バリデーション設定

## 受け入れ条件
- [ ] Book エンティティが作成されていること
- [ ] 必要なフィールドが定義されていること（id, title, author, isbn, publishedYear）
- [ ] テーブルが自動生成されること" \
  --label "enhancement" \
  --label "Phase1"

gh issue create --repo $REPO \
  --title "Book Repository 作成" \
  --body "## 目的
Spring Data JPA の理解

## 作業内容
- [ ] JpaRepository を継承した Repository 作成
- [ ] 基本的なクエリメソッド実装
- [ ] カスタムクエリ作成

## 受け入れ条件
- [ ] BookRepository が作成されていること
- [ ] 基本的な CRUD 操作ができること
- [ ] findByTitle, findByAuthor などのメソッドが動作すること" \
  --label "enhancement" \
  --label "Phase1"

gh issue create --repo $REPO \
  --title "Book Service 作成" \
  --body "## 目的
ビジネスロジック層の理解

## 作業内容
- [ ] Service クラス作成
- [ ] CRUD メソッド実装
- [ ] トランザクション設定

## 受け入れ条件
- [ ] BookService が作成されていること
- [ ] トランザクション管理が適切に設定されていること
- [ ] ビジネスロジックが Service 層に集約されていること" \
  --label "enhancement" \
  --label "Phase1"

gh issue create --repo $REPO \
  --title "Book Controller 作成" \
  --body "## 目的
REST API の基本理解

## 作業内容
- [ ] RestController 作成
- [ ] CRUD エンドポイント実装
- [ ] リクエスト/レスポンス DTO 作成

## 受け入れ条件
- [ ] 以下のエンドポイントが動作すること
  - GET /api/books（一覧取得）
  - GET /api/books/{id}（詳細取得）
  - POST /api/books（登録）
  - PUT /api/books/{id}（更新）
  - DELETE /api/books/{id}（削除）
- [ ] Talend API Tester で動作確認済みであること" \
  --label "enhancement" \
  --label "Phase1"

gh issue create --repo $REPO \
  --title "ログ設定・Eclipse デバッグ設定" \
  --body "## 目的
Eclipse でのデバッグ・運用を意識した基本設定

## 作業内容
- [ ] Logback 設定
- [ ] Eclipse でのブレークポイント設定
- [ ] デバッグ実行方法
- [ ] コンソールログの確認方法
- [ ] Eclipse の Git 統合使用方法
- [ ] 基本的なエラーハンドリング

## 受け入れ条件
- [ ] ログレベル別の出力が確認できること
- [ ] Eclipse でブレークポイントデバッグができること
- [ ] Git 操作が Eclipse から実行できること" \
  --label "enhancement" \
  --label "Phase1"

gh issue create --repo $REPO \
  --title "例外ハンドリング実装" \
  --body "## 目的
エラー処理の理解

## 作業内容
- [ ] カスタム例外クラス作成
- [ ] GlobalExceptionHandler 作成
- [ ] エラーレスポンス統一

## 受け入れ条件
- [ ] 統一されたエラーレスポンス形式が定義されていること
- [ ] 各種例外が適切にハンドリングされること
- [ ] HTTPステータスコードが適切に返されること" \
  --label "enhancement" \
  --label "Phase1"

gh issue create --repo $REPO \
  --title "バリデーション強化" \
  --body "## 目的
入力値検証の理解

## 作業内容
- [ ] Bean Validation 設定
- [ ] カスタムバリデーター作成
- [ ] エラーメッセージ国際化

## 受け入れ条件
- [ ] 必須項目のバリデーションが動作すること
- [ ] ISBN形式のバリデーションが動作すること
- [ ] エラーメッセージが日本語で表示されること" \
  --label "enhancement" \
  --label "Phase1"

gh issue create --repo $REPO \
  --title "API テスト・ドキュメント" \
  --body "## 目的
API 設計・テストの理解

## 作業内容
- [ ] Swagger/OpenAPI 設定
- [ ] API ドキュメント自動生成
- [ ] Talend API Tester でのテストケース作成
- [ ] Postman Collection エクスポート

## 受け入れ条件
- [ ] Swagger UI が表示されること（http://localhost:8080/swagger-ui.html）
- [ ] すべての API が Swagger UI から実行できること
- [ ] API テストケースが作成されていること" \
  --label "enhancement" \
  --label "Phase1"

# Phase 2以降も同様に続く...
# 全40個のIssueを作成

echo "Phase 1のIssue作成完了"
echo "続けてPhase 2-4のIssueも作成する場合は、スクリプトを拡張してください"