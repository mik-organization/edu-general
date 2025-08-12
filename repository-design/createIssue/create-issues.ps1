# create-issues.ps1
# GitHub Issue 全40件一括作成スクリプト
# 使用方法: .\create-issues.ps1 -Owner "username" -Repo "repository-name"

param(
    [Parameter(Mandatory=$true)]
    [string]$Owner,
    [Parameter(Mandatory=$true)]
    [string]$Repo
)

$Repository = "$Owner/$Repo"

Write-Host "========================================" -ForegroundColor Cyan
Write-Host "GitHub Issue 一括作成スクリプト" -ForegroundColor Cyan
Write-Host "リポジトリ: $Repository" -ForegroundColor Cyan
Write-Host "作成予定: 40件" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# カウンター
$created = 0
$failed = 0

# Issue作成関数
function Create-Issue {
    param(
        [string]$Title,
        [string]$Body,
        [string]$Labels
    )
    
    Write-Host "[$($created + $failed + 1)/40] 作成中: $Title" -ForegroundColor Yellow
    
    try {
        $result = gh issue create --repo $Repository --title "$Title" --body "$Body" --label "$Labels" 2>&1
        
        if ($LASTEXITCODE -eq 0) {
            Write-Host "  ✅ 成功" -ForegroundColor Green
            $script:created++
        } else {
            Write-Host "  ❌ 失敗: $result" -ForegroundColor Red
            $script:failed++
        }
    } catch {
        Write-Host "  ❌ エラー: $_" -ForegroundColor Red
        $script:failed++
    }
    
    Start-Sleep -Seconds 1
}

Write-Host "Phase 1: 環境構築・基盤 (Issue #1-10)" -ForegroundColor Cyan
Write-Host "----------------------------------------" -ForegroundColor Gray

# Issue #1
Create-Issue -Title "プロジェクト初期設定・Eclipse環境構築" -Body "## 目的
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
- [ ] README.md に基本的な説明が記載されていること" -Labels "enhancement,Phase1"

# Issue #2
Create-Issue -Title "MySQL データベース設定" -Body "## 目的
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
- [ ] 日本語データが正しく保存・取得できること" -Labels "enhancement,Phase1,database"

# Issue #3
Create-Issue -Title "Book エンティティ作成" -Body "## 目的
JPA エンティティの基本理解

## 作業内容
- [ ] Book エンティティクラス作成
- [ ] アノテーション設定 (@Entity, @Id, @Column)
- [ ] バリデーション設定

## 受け入れ条件
- [ ] Book エンティティが作成されていること
- [ ] 必要なフィールドが定義されていること（id, title, author, isbn, publishedYear）
- [ ] テーブルが自動生成されること" -Labels "enhancement,Phase1,backend"

# Issue #4
Create-Issue -Title "Book Repository 作成" -Body "## 目的
Spring Data JPA の理解

## 作業内容
- [ ] JpaRepository を継承した Repository 作成
- [ ] 基本的なクエリメソッド実装
- [ ] カスタムクエリ作成

## 受け入れ条件
- [ ] BookRepository が作成されていること
- [ ] 基本的な CRUD 操作ができること
- [ ] findByTitle, findByAuthor などのメソッドが動作すること" -Labels "enhancement,Phase1,backend"

# Issue #5
Create-Issue -Title "Book Service 作成" -Body "## 目的
ビジネスロジック層の理解

## 作業内容
- [ ] Service クラス作成
- [ ] CRUD メソッド実装
- [ ] トランザクション設定

## 受け入れ条件
- [ ] BookService が作成されていること
- [ ] トランザクション管理が適切に設定されていること
- [ ] ビジネスロジックが Service 層に集約されていること" -Labels "enhancement,Phase1,backend"

# Issue #6
Create-Issue -Title "Book Controller 作成" -Body "## 目的
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
- [ ] Talend API Tester で動作確認済みであること" -Labels "enhancement,Phase1,api"

# Issue #7
Create-Issue -Title "ログ設定・Eclipse デバッグ設定" -Body "## 目的
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
- [ ] Git 操作が Eclipse から実行できること" -Labels "enhancement,Phase1"

# Issue #8
Create-Issue -Title "例外ハンドリング実装" -Body "## 目的
エラー処理の理解

## 作業内容
- [ ] カスタム例外クラス作成
- [ ] GlobalExceptionHandler 作成
- [ ] エラーレスポンス統一

## 受け入れ条件
- [ ] 統一されたエラーレスポンス形式が定義されていること
- [ ] 各種例外が適切にハンドリングされること
- [ ] HTTPステータスコードが適切に返されること" -Labels "enhancement,Phase1,backend"

# Issue #9
Create-Issue -Title "バリデーション強化" -Body "## 目的
入力値検証の理解

## 作業内容
- [ ] Bean Validation 設定
- [ ] カスタムバリデーター作成
- [ ] エラーメッセージ国際化

## 受け入れ条件
- [ ] 必須項目のバリデーションが動作すること
- [ ] ISBN形式のバリデーションが動作すること
- [ ] エラーメッセージが日本語で表示されること" -Labels "enhancement,Phase1,backend"

# Issue #10
Create-Issue -Title "API テスト・ドキュメント" -Body "## 目的
API 設計・テストの理解

## 作業内容
- [ ] Swagger/OpenAPI 設定
- [ ] API ドキュメント自動生成
- [ ] Talend API Tester でのテストケース作成
- [ ] Postman Collection エクスポート

## 受け入れ条件
- [ ] Swagger UI が表示されること（http://localhost:8080/swagger-ui.html）
- [ ] すべての API が Swagger UI から実行できること
- [ ] API テストケースが作成されていること" -Labels "enhancement,Phase1,documentation,api"

Write-Host ""
Write-Host "Phase 2: 機能拡張 (Issue #11-20)" -ForegroundColor Cyan
Write-Host "----------------------------------------" -ForegroundColor Gray

# Issue #11
Create-Issue -Title "User エンティティ・機能作成" -Body "## 目的
複数エンティティの関連理解

## 作業内容
- [ ] User エンティティ作成
- [ ] User Repository/Service/Controller 作成
- [ ] User 関連機能実装
- [ ] Book との関連は未実装

## 受け入れ条件
- [ ] User の CRUD 操作ができること
- [ ] メールアドレスの重複チェックが動作すること" -Labels "enhancement,Phase2,backend"

# Issue #12
Create-Issue -Title "貸出機能（Loan エンティティ）" -Body "## 目的
エンティティ間の関連理解

## 作業内容
- [ ] Loan エンティティ作成
- [ ] Book-User-Loan の関連設定
- [ ] 貸出API実装

## 受け入れ条件
- [ ] 貸出処理が実行できること
- [ ] 同じ本を複数回貸出できないこと
- [ ] 貸出中の本の状態が管理されること" -Labels "enhancement,Phase2,backend"

# Issue #13
Create-Issue -Title "返却機能実装" -Body "## 目的
ビジネスロジックの複雑化対応

## 作業内容
- [ ] 返却API実装
- [ ] 返却日の自動設定
- [ ] 貸出状態の更新

## 受け入れ条件
- [ ] 返却処理が実行できること
- [ ] 返却日が自動記録されること
- [ ] 延滞日数が計算されること" -Labels "enhancement,Phase2,backend"

# Issue #14
Create-Issue -Title "検索機能強化" -Body "## 目的
複雑なクエリの理解

## 作業内容
- [ ] 複数条件検索
- [ ] 部分一致検索
- [ ] ページネーション実装

## 受け入れ条件
- [ ] タイトル・著者での部分一致検索ができること
- [ ] 複数条件での AND/OR 検索ができること
- [ ] ページネーションが動作すること" -Labels "enhancement,Phase2,backend,database"

# Issue #15
Create-Issue -Title "貸出期限管理" -Body "## 目的
日付処理とビジネスルール実装

## 作業内容
- [ ] 貸出期限の設定（デフォルト14日）
- [ ] 延滞チェック機能
- [ ] 延滞者一覧取得API

## 受け入れ条件
- [ ] 貸出時に返却期限が設定されること
- [ ] 延滞している貸出が検索できること
- [ ] 延滞日数が計算できること" -Labels "enhancement,Phase2,backend"

# Issue #16
Create-Issue -Title "Eclipse でのJUnit単体テスト導入" -Body "## 目的
Eclipse + JUnit を活用したテスト駆動開発の基礎学習

## 作業内容
- [ ] Eclipse での JUnit 5 実行環境設定
- [ ] Eclipse でのテストクラス作成方法
- [ ] Repository テスト作成（JUnit Runner使用）
- [ ] Service テスト作成
- [ ] Controller テスト作成（MockMvc使用）
- [ ] Eclipse でのテスト実行・デバッグ方法
- [ ] テストカバレッジ確認（EclEmma使用）

## 受け入れ条件
- [ ] 各層のテストが作成されていること
- [ ] テストカバレッジが60%以上であること
- [ ] Eclipse からテストが実行できること" -Labels "enhancement,Phase2,testing"

# Issue #17
Create-Issue -Title "予約機能実装" -Body "## 目的
より複雑なビジネスロジック

## 作業内容
- [ ] Reservation エンティティ作成
- [ ] 予約API実装
- [ ] 貸出可能時の自動通知（ログ出力）
- [ ] 予約機能のテスト作成

## 受け入れ条件
- [ ] 貸出中の本を予約できること
- [ ] 予約順序が管理されること
- [ ] 返却時に予約者に通知されること（ログ）" -Labels "enhancement,Phase2,backend"

# Issue #18
Create-Issue -Title "在庫管理機能" -Body "## 目的
複数在庫の管理

## 作業内容
- [ ] BookCopy エンティティ作成（書籍の複数冊管理）
- [ ] 在庫数の管理
- [ ] 貸出可能冊数の表示

## 受け入れ条件
- [ ] 同じ書籍を複数冊登録できること
- [ ] 貸出可能な在庫数が確認できること
- [ ] すべて貸出中の場合は貸出不可となること" -Labels "enhancement,Phase2,backend"

# Issue #19
Create-Issue -Title "貸出履歴機能" -Body "## 目的
履歴データの管理

## 作業内容
- [ ] LoanHistory エンティティ作成
- [ ] 返却時の履歴保存
- [ ] ユーザー別貸出履歴取得API
- [ ] 書籍別貸出履歴取得API

## 受け入れ条件
- [ ] 返却後も貸出履歴が保持されること
- [ ] ユーザーの貸出履歴が取得できること
- [ ] 書籍の貸出回数が集計できること" -Labels "enhancement,Phase2,backend,database"

# Issue #20
Create-Issue -Title "データ整合性チェック" -Body "## 目的
データ整合性の保証

## 作業内容
- [ ] 貸出時の在庫チェック強化
- [ ] 予約と貸出の整合性チェック
- [ ] トランザクション管理の見直し

## 受け入れ条件
- [ ] 同時アクセス時のデータ整合性が保たれること
- [ ] 楽観的ロックが実装されていること
- [ ] エラー時のロールバックが正しく動作すること" -Labels "enhancement,Phase2,backend,database"

Write-Host ""
Write-Host "Phase 3: 高度な機能 (Issue #21-30)" -ForegroundColor Cyan
Write-Host "----------------------------------------" -ForegroundColor Gray

# Issue #21
Create-Issue -Title "認証機能実装" -Body "## 目的
Spring Security の基本理解

## 作業内容
- [ ] Spring Security 設定
- [ ] JWT トークン認証
- [ ] ユーザー認証API
- [ ] ログイン/ログアウト機能

## 受け入れ条件
- [ ] ログイン API が動作すること
- [ ] JWT トークンが発行されること
- [ ] 認証が必要な API が保護されること" -Labels "enhancement,Phase3,security,backend"

# Issue #22
Create-Issue -Title "権限制御実装" -Body "## 目的
認可の理解

## 作業内容
- [ ] ロールベースアクセス制御
- [ ] メソッドレベルセキュリティ
- [ ] 管理者・一般ユーザー区分

## 受け入れ条件
- [ ] 管理者のみ書籍登録・更新・削除ができること
- [ ] 一般ユーザーは閲覧・貸出のみ可能なこと
- [ ] 権限不足の場合 403 エラーが返ること" -Labels "enhancement,Phase3,security,backend"

# Issue #23
Create-Issue -Title "統計・レポート機能" -Body "## 目的
集約クエリの理解

## 作業内容
- [ ] 貸出統計API
- [ ] 人気書籍ランキング
- [ ] ユーザー別貸出履歴
- [ ] 月別貸出統計

## 受け入れ条件
- [ ] 人気書籍TOP10が取得できること
- [ ] 月別の貸出数が集計できること
- [ ] ユーザーランキングが表示できること" -Labels "enhancement,Phase3,backend,database"

# Issue #24
Create-Issue -Title "通知機能" -Body "## 目的
非同期処理の理解

## 作業内容
- [ ] 返却期限通知
- [ ] 予約完了通知
- [ ] メール送信機能（モック実装）
- [ ] 通知履歴管理

## 受け入れ条件
- [ ] 返却期限前日に通知が送信されること（ログ）
- [ ] 予約書籍が利用可能時に通知されること
- [ ] 通知履歴が記録されること" -Labels "enhancement,Phase3,backend"

# Issue #25
Create-Issue -Title "ファイルアップロード" -Body "## 目的
ファイル処理の理解

## 作業内容
- [ ] 書籍画像アップロード
- [ ] CSV インポート/エクスポート
- [ ] ファイル管理API
- [ ] ファイルサイズ制限

## 受け入れ条件
- [ ] 書籍画像がアップロードできること
- [ ] CSV で書籍データを一括登録できること
- [ ] CSV で書籍データをエクスポートできること" -Labels "enhancement,Phase3,backend"

# Issue #26
Create-Issue -Title "検索機能の高度化" -Body "## 目的
全文検索と高度な検索機能

## 作業内容
- [ ] 全文検索機能実装
- [ ] ファセット検索
- [ ] 検索履歴の保存
- [ ] 検索結果のソート機能

## 受け入れ条件
- [ ] キーワードでの全文検索ができること
- [ ] 出版年、カテゴリでの絞り込みができること
- [ ] 関連度順、新着順でソートできること" -Labels "enhancement,Phase3,backend,database"

# Issue #27
Create-Issue -Title "キャッシュ実装（基本）" -Body "## 目的
キャッシュの基本理解

## 作業内容
- [ ] Spring Cache 設定
- [ ] 書籍情報のキャッシュ
- [ ] キャッシュクリア機能
- [ ] キャッシュ統計

## 受け入れ条件
- [ ] 頻繁にアクセスされるデータがキャッシュされること
- [ ] 更新時にキャッシュがクリアされること
- [ ] キャッシュヒット率が確認できること" -Labels "enhancement,Phase3,performance"

# Issue #28
Create-Issue -Title "バッチ処理実装" -Body "## 目的
定期処理の実装

## 作業内容
- [ ] 延滞通知バッチ
- [ ] 予約期限切れ処理
- [ ] 統計情報集計バッチ
- [ ] Spring Scheduler 設定

## 受け入れ条件
- [ ] 毎日定時に延滞チェックが実行されること
- [ ] 予約期限切れが自動処理されること
- [ ] バッチ実行履歴が記録されること" -Labels "enhancement,Phase3,backend"

# Issue #29
Create-Issue -Title "監査ログ実装" -Body "## 目的
監査証跡の記録

## 作業内容
- [ ] 操作ログの記録
- [ ] Spring AOP での自動記録
- [ ] ログ検索API
- [ ] 重要操作の追跡

## 受け入れ条件
- [ ] CRUD 操作がログに記録されること
- [ ] ログイン/ログアウトが記録されること
- [ ] ユーザー別、日付別でログ検索できること" -Labels "enhancement,Phase3,security,backend"

# Issue #30
Create-Issue -Title "データバックアップ・リストア" -Body "## 目的
データ保護の実装

## 作業内容
- [ ] データエクスポート機能
- [ ] データインポート機能
- [ ] バックアップスケジュール設定
- [ ] リストア手順書作成

## 受け入れ条件
- [ ] 全データをJSON/CSVでエクスポートできること
- [ ] エクスポートデータから復元できること
- [ ] バックアップ手順書が作成されていること" -Labels "enhancement,Phase3,database"

Write-Host ""
Write-Host "Phase 4: 高度なバックエンド機能・統合 (Issue #31-40)" -ForegroundColor Cyan
Write-Host "----------------------------------------" -ForegroundColor Gray

# Issue #31
Create-Issue -Title "API 統合テスト設計" -Body "## 目的
E2E テストの理解

## 作業内容
- [ ] 統合テスト環境構築
- [ ] API シナリオテスト作成
- [ ] Talend API Tester での手動テスト手順書作成
- [ ] H2 Database を使用したテスト環境

## 受け入れ条件
- [ ] 主要なユースケースの統合テストが作成されていること
- [ ] テストデータの初期化が自動化されていること
- [ ] CI で統合テストが実行できること" -Labels "enhancement,Phase4,testing"

# Issue #32
Create-Issue -Title "パフォーマンステスト・Gradle最適化" -Body "## 目的
性能を意識した開発・ビルド最適化

## 作業内容
- [ ] JMeter を使用した負荷テスト
- [ ] データベースクエリ最適化
- [ ] N+1 問題の検出・解決
- [ ] Gradle ビルドキャッシュ活用
- [ ] 並列ビルド設定
- [ ] プロファイルベースビルド

## 受け入れ条件
- [ ] 100件同時アクセスに耐えられること
- [ ] N+1 問題が解決されていること
- [ ] ビルド時間が30%短縮されること" -Labels "enhancement,Phase4,performance,testing"

# Issue #33
Create-Issue -Title "デプロイメント設定・DB最適化" -Body "## 目的
本番環境・データベース最適化への理解

## 作業内容
- [ ] アプリケーションのJAR化
- [ ] 環境別設定管理（dev/prod）
- [ ] MySQL パフォーマンス設定
- [ ] データベースインデックス設計
- [ ] MySQL特有の最適化（クエリキャッシュ、バッファプール等）

## 受け入れ条件
- [ ] 実行可能JARが作成できること
- [ ] 環境変数で設定を切り替えられること
- [ ] 適切なインデックスが設定されていること" -Labels "enhancement,Phase4,database,performance"

# Issue #34
Create-Issue -Title "モニタリング・ログ強化" -Body "## 目的
運用監視の理解

## 作業内容
- [ ] Actuator を使用したヘルスチェック
- [ ] メトリクス収集設定
- [ ] 構造化ログ実装
- [ ] ログローテーション設定

## 受け入れ条件
- [ ] /actuator/health でヘルスチェックができること
- [ ] アプリケーションメトリクスが取得できること
- [ ] ログがJSON形式で出力されること" -Labels "enhancement,Phase4,backend"

# Issue #35
Create-Issue -Title "セキュリティ強化" -Body "## 目的
セキュリティベストプラクティス

## 作業内容
- [ ] OWASP Top 10 対策
- [ ] セキュリティヘッダー設定
- [ ] SQL インジェクション対策の確認
- [ ] XSS 対策

## 受け入れ条件
- [ ] セキュリティヘッダーが設定されていること
- [ ] SQL インジェクションが防げていること
- [ ] パスワードが暗号化されて保存されること" -Labels "enhancement,Phase4,security"

# Issue #36
Create-Issue -Title "API バージョニング" -Body "## 目的
API 設計の発展

## 作業内容
- [ ] API バージョン管理戦略
- [ ] 後方互換性の維持
- [ ] 廃止予定 API の管理
- [ ] バージョン別ドキュメント

## 受け入れ条件
- [ ] /api/v1/ と /api/v2/ が共存できること
- [ ] 古いバージョンのAPIが動作すること
- [ ] バージョン別のSwagger UIが表示されること" -Labels "enhancement,Phase4,api"

# Issue #37
Create-Issue -Title "大量データ処理・DB最適化" -Body "## 目的
MySQL 特有の機能・スケーラビリティの理解

## 作業内容
- [ ] MySQL 特有機能活用（JSON型、Generated Columns等）
- [ ] バッチ処理実装
- [ ] ページング最適化（OFFSET/LIMIT最適化）
- [ ] パーティショニング設計
- [ ] EXPLAIN を使用したクエリ分析
- [ ] インデックスヒントの活用

## 受け入れ条件
- [ ] 10万件のデータで検索が1秒以内に完了すること
- [ ] バッチ処理で1万件を5分以内に処理できること
- [ ] EXPLAIN で実行計画が最適化されていること" -Labels "enhancement,Phase4,database,performance"

# Issue #38
Create-Issue -Title "外部 API 連携" -Body "## 目的
システム間連携の理解

## 作業内容
- [ ] 外部書籍情報API との連携（モック）
- [ ] RestTemplate/WebClient の使用
- [ ] 回復性パターン（Circuit Breaker）実装
- [ ] API レート制限対応

## 受け入れ条件
- [ ] 外部APIからデータ取得ができること
- [ ] 外部API障害時もシステムが停止しないこと
- [ ] リトライ処理が実装されていること" -Labels "enhancement,Phase4,api,backend"

# Issue #39
Create-Issue -Title "高度なキャッシュ戦略" -Body "## 目的
パフォーマンス最適化

## 作業内容
- [ ] 多層キャッシュの実装
- [ ] キャッシュ戦略設計（TTL、LRU）
- [ ] キャッシュ無効化パターン
- [ ] キャッシュウォーミング

## 受け入れ条件
- [ ] 適切なキャッシュ戦略が実装されていること
- [ ] キャッシュヒット率が80%以上であること
- [ ] キャッシュ更新が適切に行われること" -Labels "enhancement,Phase4,performance"

# Issue #40
Create-Issue -Title "最終的なリファクタリング" -Body "## 目的
コード品質の向上

## 作業内容
- [ ] コードレビュー実施
- [ ] 技術的負債の解消
- [ ] 設計パターンの適用
- [ ] ドキュメント整備

## 受け入れ条件
- [ ] 重複コードが除去されていること
- [ ] 適切な設計パターンが適用されていること
- [ ] すべての public メソッドに Javadoc があること
- [ ] README が最新化されていること" -Labels "enhancement,Phase4"

Write-Host ""
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "Issue作成完了！" -ForegroundColor Green
Write-Host "----------------------------------------" -ForegroundColor Gray
Write-Host "✅ 作成成功: $created" -ForegroundColor Green
Write-Host "❌ 作成失敗: $failed" -ForegroundColor Red
Write-Host "========================================" -ForegroundColor Cyan

if ($created -gt 0) {
    Write-Host ""
    Write-Host "作成されたIssueは以下で確認できます:" -ForegroundColor Yellow
    Write-Host "https://github.com/$Repository/issues" -ForegroundColor Cyan
}