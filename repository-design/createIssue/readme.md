# GitHub Issue 一括作成ガイド

このガイドでは、図書館管理システムの研修用Issue（全40件）をGitHubリポジトリに一括作成する方法を説明します。

## 前提条件

- GitHubアカウントを持っていること
- 対象リポジトリへの書き込み権限があること
- Windows 10/11 または macOS/Linux環境

---

## 方法1: GitHub CLI を使用した一括作成

### 1.1 GitHub CLI のインストール

#### Windows
```powershell
# 方法1: winget を使用
winget install GitHub.cli

# 方法2: Chocolatey を使用
choco install gh

# 方法3: 公式サイトからダウンロード
# https://cli.github.com/ からインストーラーをダウンロード
```

#### macOS
```bash
# Homebrew を使用
brew install gh
```

#### Linux (Ubuntu/Debian)
```bash
# apt を使用
curl -fsSL https://cli.github.com/packages/githubcli-archive-keyring.gpg | sudo dd of=/usr/share/keyrings/githubcli-archive-keyring.gpg
echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/githubcli-archive-keyring.gpg] https://cli.github.com/packages stable main" | sudo tee /etc/apt/sources.list.d/github-cli.list > /dev/null
sudo apt update
sudo apt install gh
```

### 1.2 GitHub CLI の認証設定

```bash
# 認証開始
gh auth login

# 以下の質問に答える：
# ? What account do you want to log into? GitHub.com
# ? What is your preferred protocol for Git operations? HTTPS
# ? Authenticate Git with your GitHub credentials? Yes
# ? How would you like to authenticate GitHub CLI? Login with a web browser

# ブラウザが開くので、表示されたコードを入力して認証
```

### 1.3 認証の確認

```bash
# 認証状態の確認
gh auth status

# 正常な出力例：
# ✓ Logged in to github.com as username
```

### 1.4 リポジトリの準備

```bash
# リポジトリのクローン（まだの場合）
git clone https://github.com/yourusername/library-management-system.git
cd library-management-system

# または、既存のディレクトリで作業
cd /path/to/library-management-system
```

### 1.5 ラベルの事前作成

```bash
# Phase ラベルの作成
gh label create "Phase1" --description "Phase 1: 環境構築・基盤" --color "0e8a16"
gh label create "Phase2" --description "Phase 2: 機能拡張" --color "fbca04"
gh label create "Phase3" --description "Phase 3: 高度な機能" --color "d93f0b"
gh label create "Phase4" --description "Phase 4: 統合・最適化" --color "5319e7"

# その他の便利なラベル
gh label create "backend" --description "バックエンド関連" --color "1d76db"
gh label create "database" --description "データベース関連" --color "006b75"
gh label create "security" --description "セキュリティ関連" --color "d73a4a"
gh label create "testing" --description "テスト関連" --color "0075ca"
```

---

## 方法2: PowerShell スクリプトを使用（Windows）

### 2.1 スクリプトファイルの作成

1. テキストエディタを開く（メモ帳、VSCode等）
2. `create-all-issues.ps1` という名前で以下の内容を保存

```powershell
# create-all-issues.ps1
param(
    [Parameter(Mandatory=$true)]
    [string]$Owner,  # GitHubユーザー名
    [Parameter(Mandatory=$true)]
    [string]$Repo    # リポジトリ名
)

$Repository = "$Owner/$Repo"
Write-Host "リポジトリ $Repository にIssueを作成します..." -ForegroundColor Green

# Issue作成関数
function Create-GitHubIssue {
    param(
        [string]$Title,
        [string]$Body,
        [string[]]$Labels
    )
    
    $labelArgs = $Labels | ForEach-Object { "--label `"$_`"" }
    $labelString = $labelArgs -join " "
    
    $cmd = "gh issue create --repo $Repository --title `"$Title`" --body `"$Body`" $labelString"
    
    Write-Host "作成中: $Title" -ForegroundColor Yellow
    Invoke-Expression $cmd
    Start-Sleep -Seconds 2  # API制限対策
}

# Phase 1 Issues
Create-GitHubIssue -Title "プロジェクト初期設定・Eclipse環境構築" -Body @"
## 目的
Eclipse + Spring Boot + Gradle の基本環境理解

## 作業内容
- [ ] Spring Boot プロジェクト作成
- [ ] Eclipse への Gradle プロジェクトインポート
- [ ] application.yml 設定
- [ ] README.md 作成

## 受け入れ条件
- [ ] Spring Boot アプリケーションが起動すること
- [ ] README.md に基本的な説明が記載されていること
"@ -Labels @("enhancement", "Phase1")

# 他のIssueも同様に追加...

Write-Host "すべてのIssueの作成が完了しました！" -ForegroundColor Green
```

### 2.2 PowerShell 実行ポリシーの設定

```powershell
# 実行ポリシーの確認
Get-ExecutionPolicy

# 実行ポリシーの変更（必要な場合）
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser

# 確認メッセージが出たら Y を入力
```

### 2.3 スクリプトの実行

```powershell
# スクリプトのあるディレクトリに移動
cd C:\path\to\script

# スクリプト実行
.\create-all-issues.ps1 -Owner "yourusername" -Repo "library-management-system"
```

---

## 方法3: Bash スクリプトを使用（Mac/Linux/Git Bash）

### 3.1 スクリプトファイルの作成

```bash
# create-all-issues.sh を作成
nano create-all-issues.sh
# または
vim create-all-issues.sh
```

### 3.2 スクリプト内容

```bash
#!/bin/bash

# 引数チェック
if [ $# -ne 1 ]; then
    echo "使用方法: $0 <owner/repo>"
    echo "例: $0 yourusername/library-management-system"
    exit 1
fi

REPO=$1
echo "リポジトリ $REPO にIssueを作成開始..."

# Issue作成関数
create_issue() {
    local title=$1
    local body=$2
    local labels=$3
    
    echo "作成中: $title"
    gh issue create --repo "$REPO" \
        --title "$title" \
        --body "$body" \
        --label "$labels"
    
    sleep 2  # API制限対策
}

# Phase 1 Issues
create_issue "プロジェクト初期設定・Eclipse環境構築" \
"## 目的
Eclipse + Spring Boot + Gradle の基本環境理解

## 作業内容
- [ ] Spring Boot プロジェクト作成
- [ ] Eclipse への Gradle プロジェクトインポート
- [ ] application.yml 設定
- [ ] README.md 作成

## 受け入れ条件
- [ ] Spring Boot アプリケーションが起動すること
- [ ] README.md に基本的な説明が記載されていること" \
"enhancement,Phase1"

# 他のIssueも同様に追加...

echo "すべてのIssueの作成が完了しました！"
```

### 3.3 実行権限の付与

```bash
# 実行権限を付与
chmod +x create-all-issues.sh
```

### 3.4 スクリプトの実行

```bash
# スクリプト実行
./create-all-issues.sh yourusername/library-management-system
```

---

## 方法4: GitHub Web UI から手動作成

### 4.1 Issue テンプレートの作成

1. リポジトリの `.github/ISSUE_TEMPLATE/` ディレクトリを作成
2. 各Phase用のテンプレートファイルを作成

#### `.github/ISSUE_TEMPLATE/phase1-feature.md`
```markdown
---
name: Phase 1 機能
about: Phase 1の基本機能実装用テンプレート
title: ''
labels: 'enhancement, Phase1'
assignees: ''
---

## 目的
[学習目的を記載]

## 作業内容
- [ ] タスク1
- [ ] タスク2
- [ ] タスク3

## 受け入れ条件
- [ ] 条件1
- [ ] 条件2
- [ ] 条件3

## 参考資料
- [リンク1]
- [リンク2]
```

### 4.2 Web UIからの作成手順

1. GitHubでリポジトリを開く
2. "Issues" タブをクリック
3. "New issue" ボタンをクリック
4. テンプレートを選択（設定済みの場合）
5. タイトルと本文を入力
6. ラベルを選択
7. "Submit new issue" をクリック

---

## トラブルシューティング

### よくあるエラーと対処法

#### 1. 認証エラー
```bash
# エラー: gh: authentication required
# 解決方法
gh auth login
```

#### 2. 権限エラー
```bash
# エラー: GraphQL error: Resource not accessible by integration
# 解決方法: リポジトリへの書き込み権限を確認
gh repo view --web
```

#### 3. API レート制限
```bash
# エラー: API rate limit exceeded
# 解決方法: 1時間待つか、Personal Access Token を使用
gh auth login --with-token < token.txt
```

#### 4. ラベルが存在しない
```bash
# エラー: label 'Phase1' does not exist
# 解決方法: ラベルを事前に作成
gh label create "Phase1" --color "0e8a16"
```

### デバッグモード

```bash
# 詳細なログを表示
GH_DEBUG=1 gh issue create --repo owner/repo --title "Test"

# API呼び出しの確認
gh api repos/owner/repo/issues
```

---

## Issue作成後の管理

### GitHub Projects での管理

#### 1. Project の作成
```bash
# CLI でプロジェクト作成
gh project create --title "図書館管理システム研修" --body "研修進捗管理"

# または Web UI から
# リポジトリ → Projects → New project
```

#### 2. カラムの設定
- To Do（未着手）
- In Progress（作業中）
- In Review（レビュー中）
- Done（完了）

#### 3. 自動化の設定
1. Project settings → Workflows
2. "Item added to project" → Status を "To Do" に設定
3. "Pull request merged" → Status を "Done" に設定

### マイルストーンの設定

```bash
# Phase ごとのマイルストーン作成
gh api repos/owner/repo/milestones \
  --method POST \
  --field title="Phase 1: 環境構築・基盤" \
  --field description="基本的な開発環境と基盤機能" \
  --field due_on="2024-02-29T23:59:59Z"

# Issue にマイルストーンを設定
gh issue edit 1 --milestone "Phase 1: 環境構築・基盤"
```

---

## ベストプラクティス

### 1. Issue の管理

- **定期的な更新**: 進捗をコメントで記録
- **関連付け**: PR と Issue を紐付ける（`Closes #1` など）
- **ラベル活用**: 状態や優先度を明示

### 2. チーム開発時の運用

```bash
# Assignee の設定
gh issue edit 1 --add-assignee "@username"

# 優先度ラベルの追加
gh issue edit 1 --add-label "priority:high"

# 進捗コメントの追加
gh issue comment 1 --body "本日、データベース設定まで完了しました。"
```

### 3. 進捗の可視化

```bash
# Open な Issue の確認
gh issue list --label "Phase1"

# 自分にアサインされた Issue
gh issue list --assignee "@me"

# 今週締切の Issue
gh issue list --milestone "Phase 1"
```

---

## 参考リンク

- [GitHub CLI 公式ドキュメント](https://cli.github.com/manual/)
- [GitHub Issues ドキュメント](https://docs.github.com/en/issues)
- [GitHub Projects ドキュメント](https://docs.github.com/en/issues/planning-and-tracking-with-projects)
- [GitHub API ドキュメント](https://docs.github.com/en/rest)

---

## サポート

問題が発生した場合は、以下の順序で対処してください：

1. このガイドのトラブルシューティングセクションを確認
2. `gh issue create --help` でヘルプを確認
3. GitHub CLI の Issue ページで既知の問題を検索
4. メンターまたは管理者に相談