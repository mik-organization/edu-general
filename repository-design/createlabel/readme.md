# GitHub ラベル一括作成・管理ガイド

## 概要
このガイドでは、PowerShellスクリプトを使用してGitHubリポジトリのラベルを一括作成・管理する方法を説明します。

## 前提条件
- Windows PowerShell 5.1以上 または PowerShell Core 7.0以上
- GitHub CLI がインストール済み
- GitHubアカウントへの認証済み（`gh auth login`実行済み）
- 対象リポジトリへの書き込み権限

---

## 1. セットアップ

### 1.1 GitHub CLI の確認
```powershell
# バージョン確認
gh --version

# 認証状態確認
gh auth status
```

### 1.2 スクリプトファイルの保存
1. 任意のフォルダを作成（例：`C:\GitHubScripts`）
2. `create-labels.ps1` を保存
3. オプション：`delete-all-labels.ps1` を保存（既存ラベル削除用）

---

## 2. ラベル一括作成

### 2.1 基本的な使用方法
```powershell
# スクリプトのあるフォルダに移動
cd C:\GitHubScripts

# ラベル作成実行
.\create-labels.ps1 -Owner "yourusername" -Repo "library-management-system"
```

### 2.2 実行例
```powershell
# 例：ユーザー名が "tanaka" でリポジトリ名が "library-system" の場合
.\create-labels.ps1 -Owner "tanaka" -Repo "library-system"
```

### 2.3 作成されるラベル一覧

#### Phase ラベル（4個）
| ラベル名 | 説明 | 色 |
|---------|------|-----|
| Phase1 | Phase 1: 環境構築・基盤 | 🟢 緑 |
| Phase2 | Phase 2: 機能拡張 | 🟡 黄 |
| Phase3 | Phase 3: 高度な機能 | 🟠 オレンジ |
| Phase4 | Phase 4: 統合・最適化 | 🟣 紫 |

#### 種別ラベル（4個）
| ラベル名 | 説明 | 色 |
|---------|------|-----|
| enhancement | 新機能や改善 | 🔵 水色 |
| bug | バグ・不具合 | 🔴 赤 |
| documentation | ドキュメント関連 | 🔵 青 |
| question | 質問・相談 | 🟣 薄紫 |

#### 技術カテゴリラベル（6個）
| ラベル名 | 説明 | 色 |
|---------|------|-----|
| backend | バックエンド関連 | 🔵 濃い青 |
| database | データベース関連 | 🟢 ティール |
| api | API関連 | 🟣 青紫 |
| security | セキュリティ関連 | 🔴 赤 |
| testing | テスト関連 | 🔵 青 |
| performance | パフォーマンス関連 | 🩷 ピンク |

#### 状態ラベル（4個）
| ラベル名 | 説明 | 色 |
|---------|------|-----|
| in progress | 作業中 | 🟡 明るい黄色 |
| review | レビュー中 | 🟢 緑 |
| blocked | ブロック中 | 🔴 赤 |
| done | 完了 | 🟢 緑 |

#### 優先度ラベル（3個）
| ラベル名 | 説明 | 色 |
|---------|------|-----|
| priority:high | 優先度：高 | 🔴 濃い赤 |
| priority:medium | 優先度：中 | 🟡 黄 |
| priority:low | 優先度：低 | 🟢 緑 |

#### 難易度ラベル（3個）
| ラベル名 | 説明 | 色 |
|---------|------|-----|
| difficulty:easy | 難易度：易 | 🟣 青紫 |
| difficulty:medium | 難易度：中 | 🟡 黄 |
| difficulty:hard | 難易度：難 | 🔴 赤 |

#### その他（5個）
| ラベル名 | 説明 | 色 |
|---------|------|-----|
| good first issue | 初心者向けの課題 | 🟣 青紫 |
| help wanted | 助けが必要 | 🟢 緑 |
| wontfix | 修正しない | ⚪ 白 |
| duplicate | 重複 | 🔘 グレー |
| invalid | 無効 | 🔴 赤 |

**合計：29個のラベル**

---

## 3. 既存ラベルの削除（オプション）

### 3.1 全ラベル削除
デフォルトラベルを含むすべてのラベルを削除したい場合：

```powershell
# 確認付きで削除
.\delete-all-labels.ps1 -Owner "yourusername" -Repo "library-management-system"

# 確認なしで削除（危険！）
.\delete-all-labels.ps1 -Owner "yourusername" -Repo "library-management-system" -Force
```

### 3.2 特定ラベルの削除
```powershell
# 個別に削除
gh label delete --repo yourusername/library-management-system "label-name" --yes
```

---

## 4. ラベルの確認と管理

### 4.1 現在のラベル一覧表示
```powershell
# すべてのラベルを表示
gh label list --repo yourusername/library-management-system

# 名前順でソート
gh label list --repo yourusername/library-management-system --sort name

# 特定のラベルを検索
gh label list --repo yourusername/library-management-system --search "Phase"
```

### 4.2 ラベルの編集
```powershell
# ラベル名の変更
gh label edit --repo yourusername/library-management-system "old-name" --name "new-name"

# 説明の変更
gh label edit --repo yourusername/library-management-system "label-name" --description "新しい説明"

# 色の変更
gh label edit --repo yourusername/library-management-system "label-name" --color "FF0000"
```

---

## 5. トラブルシューティング

### 5.1 実行ポリシーエラー
```powershell
# エラー: スクリプトの実行がブロックされている場合
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser

# または一時的に許可
Set-ExecutionPolicy -ExecutionPolicy Bypass -Scope Process
```

### 5.2 認証エラー
```powershell
# エラー: authentication required
gh auth login

# トークンを使用した認証
gh auth login --with-token < token.txt
```

### 5.3 権限エラー
```powershell
# エラー: Resource not accessible
# 解決：リポジトリの設定を確認
gh repo view yourusername/library-management-system --web
```

### 5.4 API制限エラー
```powershell
# エラー: API rate limit exceeded
# 解決：レート制限の確認
gh api rate_limit

# 1時間待つか、Personal Access Token を使用
```

---

## 6. カスタマイズ

### 6.1 ラベルの追加・変更
`create-labels.ps1` の `$labels` 配列に新しいラベルを追加：

```powershell
@{
    Name = "カスタムラベル"
    Description = "カスタムラベルの説明"
    Color = "FF00FF"  # 16進数カラーコード（#なし）
}
```

### 6.2 色の選び方
- GitHubのカラーピッカー：https://github.com/settings/appearance
- 16進数カラーコード（#を除く6文字）
- 例：`FF0000`（赤）、`00FF00`（緑）、`0000FF`（青）

---

## 7. ベストプラクティス

### 7.1 ラベル命名規則
- **短く明確に**：`bug` より具体的な `bug:api` など
- **グループ化**：`priority:high`, `priority:low` のようにコロンで分類
- **一貫性**：チーム内で統一した命名規則を使用

### 7.2 ラベルの使い分け
```powershell
# Issue作成時に複数ラベルを設定
gh issue create --repo yourusername/library-management-system \
  --title "新機能の実装" \
  --label "enhancement,Phase1,backend,priority:high"
```

### 7.3 定期的な整理
```powershell
# 使用されていないラベルの確認
gh label list --repo yourusername/library-management-system --json name,issues | 
  ConvertFrom-Json | 
  Where-Object { $_.issues.totalCount -eq 0 }
```

---

## 8. 活用例

### 8.1 研修進捗の可視化
```powershell
# Phase1 の Issue を確認
gh issue list --repo yourusername/library-management-system --label "Phase1"

# 高優先度のタスク確認
gh issue list --repo yourusername/library-management-system --label "priority:high"

# 作業中のタスク確認
gh issue list --repo yourusername/library-management-system --label "in progress"
```

### 8.2 レポート生成
```powershell
# Phase別の進捗確認
@("Phase1", "Phase2", "Phase3", "Phase4") | ForEach-Object {
    $phase = $_
    $issues = gh issue list --repo yourusername/library-management-system --label $phase --json state | ConvertFrom-Json
    $open = ($issues | Where-Object { $_.state -eq "OPEN" }).Count
    $closed = ($issues | Where-Object { $_.state -eq "CLOSED" }).Count
    Write-Host "$phase : Open=$open, Closed=$closed"
}
```

---

## まとめ
このスクリプトを使用することで、29個のラベルを一度に作成でき、研修プロジェクトの Issue 管理が効率的に行えます。ラベルは Issue の分類、フィルタリング、進捗管理に重要な役割を果たします。