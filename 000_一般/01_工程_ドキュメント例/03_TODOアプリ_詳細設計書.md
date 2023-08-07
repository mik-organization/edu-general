# TODOアプリ - 詳細設計書
## 1. イントロダクション
詳細設計書では、基本設計書で定義されたシステムコンポーネントの詳細な動作とインターフェースについて述べます。

## 2. フロントエンド詳細設計
フロントエンドでは、以下の画面と機能が実装されます：

### メイン画面
* タスク一覧表示
  * タスクオブジェクトの一覧を取得し、画面に表示する
  * タスクの優先度に応じて、適切なスタイルを適用する
  * タスクの期限が近づいた場合、ユーザーに警告を表示する
* タスクフィルタリングとソート
  * ユーザーがタスクを優先度や期限でフィルタリング・ソートできるUIを提供する

### タスク追加画面
* タスク追加フォーム
  * ユーザーがタスクのタイトル、説明、優先度、期限を入力できるフォームを表示する
  * 入力値にバリデーションをかけ、適切なエラーメッセージを表示する

### タスク編集画面
* タスク編集フォーム
  * ユーザーが既存のタスクの内容を編集できるフォームを表示する
  * 編集後の内容にバリデーションをかけ、適切なエラーメッセージを表示する

## 3. バックエンド詳細設計
バックエンドでは、以下のAPIエンドポイントとデータベース操作が実装されます：

### APIエンドポイント
* /tasks API
```typescript
// タスクの一覧取得
GET /tasks

// タスクの追加
POST /tasks
Request Body:
{
  title: string;
  description: string;
  priority: 'low' | 'medium' | 'high';
  deadline: Date | null;
}

// タスクの編集
PUT /tasks/{id}
Request Body:
{
  title: string;
  description: string;
  priority: 'low' | 'medium' | 'high';
  deadline: Date | null;
  isCompleted: boolean;
}

// タスクの削除
DELETE /tasks/{id}

```

## 4. データベース詳細設計
データベースには、基本設計書で定義されたタスクの属性を持つテーブルが作成されます。
### タスクテーブル
* テーブル定義

| 論理名| 物理名 | データ型 | 制約  |
|-|-|-|--|
| ID | id | INTEGER | PRIMARY KEY |
| タイトル | title | VARCHAR(255) | NOT NULL |
| 説明 | description| TEXT |                  |
| 優先度 ('low', 'medium', 'high') | priority | ENUM('low', 'medium', 'high') | NOT NULL |
| 期限 (日時) | deadline | DATETIME |                  |
| 完了状態 (true: 完了, false: 未完了) | isCompleted| BOOLEAN | NOT NULL |

* DDL
```sql
CREATE TABLE tasks (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  description TEXT,
  priority ENUM('low', 'medium', 'high') NOT NULL,
  deadline DATETIME,
  isCompleted BOOLEAN NOT NULL DEFAULT false
);
COMMENT ON COLUMN tasks.id IS 'ID';
COMMENT ON COLUMN tasks.title IS 'タイトル';
COMMENT ON COLUMN tasks.description IS '説明';
COMMENT ON COLUMN tasks.priority IS '優先度 (low, medium, high)';
COMMENT ON COLUMN tasks.deadline IS '期限 (日時)';
COMMENT ON COLUMN tasks.isCompleted IS '完了状態 (true: 完了, false: 未完了)';
```

## 5. セキュリティ考慮
ユーザーのプライバシーとデータの安全性を保護するため、適切なセキュリティ対策が講じられます。