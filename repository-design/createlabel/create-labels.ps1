# create-labels.ps1
# GitHub ラベル一括作成スクリプト
# 使用方法: .\create-labels.ps1 -Owner "username" -Repo "repository-name"

param(
    [Parameter(Mandatory=$true)]
    [string]$Owner,
    [Parameter(Mandatory=$true)]
    [string]$Repo
)

$Repository = "$Owner/$Repo"

Write-Host "========================================" -ForegroundColor Cyan
Write-Host "GitHub ラベル一括作成スクリプト" -ForegroundColor Cyan
Write-Host "リポジトリ: $Repository" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# ラベル定義
$labels = @(
    # Phase ラベル
    @{
        Name = "Phase1"
        Description = "Phase 1: 環境構築・基盤"
        Color = "0e8a16"  # 緑
    },
    @{
        Name = "Phase2"
        Description = "Phase 2: 機能拡張"
        Color = "fbca04"  # 黄
    },
    @{
        Name = "Phase3"
        Description = "Phase 3: 高度な機能"
        Color = "d93f0b"  # オレンジ
    },
    @{
        Name = "Phase4"
        Description = "Phase 4: 統合・最適化"
        Color = "5319e7"  # 紫
    },
    
    # 種別ラベル
    @{
        Name = "enhancement"
        Description = "新機能や改善"
        Color = "a2eeef"  # 水色
    },
    @{
        Name = "bug"
        Description = "バグ・不具合"
        Color = "d73a4a"  # 赤
    },
    @{
        Name = "documentation"
        Description = "ドキュメント関連"
        Color = "0075ca"  # 青
    },
    @{
        Name = "question"
        Description = "質問・相談"
        Color = "d876e3"  # 薄紫
    },
    
    # 技術カテゴリラベル
    @{
        Name = "backend"
        Description = "バックエンド関連"
        Color = "1d76db"  # 濃い青
    },
    @{
        Name = "database"
        Description = "データベース関連"
        Color = "006b75"  # ティール
    },
    @{
        Name = "api"
        Description = "API関連"
        Color = "7057ff"  # 青紫
    },
    @{
        Name = "security"
        Description = "セキュリティ関連"
        Color = "d73a4a"  # 赤
    },
    @{
        Name = "testing"
        Description = "テスト関連"
        Color = "0075ca"  # 青
    },
    @{
        Name = "performance"
        Description = "パフォーマンス関連"
        Color = "f9d0c4"  # ピンク
    },
    
    # 状態ラベル
    @{
        Name = "in progress"
        Description = "作業中"
        Color = "ffd33d"  # 明るい黄色
    },
    @{
        Name = "review"
        Description = "レビュー中"
        Color = "0e8a16"  # 緑
    },
    @{
        Name = "blocked"
        Description = "ブロック中"
        Color = "e11d21"  # 赤
    },
    @{
        Name = "done"
        Description = "完了"
        Color = "0e8a16"  # 緑
    },
    
    # 優先度ラベル
    @{
        Name = "priority:high"
        Description = "優先度：高"
        Color = "b60205"  # 濃い赤
    },
    @{
        Name = "priority:medium"
        Description = "優先度：中"
        Color = "fbca04"  # 黄
    },
    @{
        Name = "priority:low"
        Description = "優先度：低"
        Color = "0e8a16"  # 緑
    },
    
    # 難易度ラベル
    @{
        Name = "difficulty:easy"
        Description = "難易度：易"
        Color = "7057ff"  # 青紫
    },
    @{
        Name = "difficulty:medium"
        Description = "難易度：中"
        Color = "fbca04"  # 黄
    },
    @{
        Name = "difficulty:hard"
        Description = "難易度：難"
        Color = "e11d21"  # 赤
    },
    
    # その他
    @{
        Name = "good first issue"
        Description = "初心者向けの課題"
        Color = "7057ff"  # 青紫
    },
    @{
        Name = "help wanted"
        Description = "助けが必要"
        Color = "008672"  # 緑
    },
    @{
        Name = "wontfix"
        Description = "修正しない"
        Color = "ffffff"  # 白
    },
    @{
        Name = "duplicate"
        Description = "重複"
        Color = "cfd3d7"  # グレー
    },
    @{
        Name = "invalid"
        Description = "無効"
        Color = "e11d21"  # 赤
    }
)

# 既存ラベルの取得
Write-Host "既存のラベルを確認中..." -ForegroundColor Yellow
$existingLabelsJson = gh label list --repo $Repository --json name --limit 100 2>$null

if ($LASTEXITCODE -ne 0) {
    Write-Host "エラー: リポジトリにアクセスできません。認証状態とリポジトリ名を確認してください。" -ForegroundColor Red
    Write-Host "ヒント: 'gh auth status' で認証状態を確認できます。" -ForegroundColor Yellow
    exit 1
}

$existingLabels = @()
if ($existingLabelsJson) {
    $existingLabels = $existingLabelsJson | ConvertFrom-Json | ForEach-Object { $_.name }
    Write-Host "既存のラベル数: $($existingLabels.Count)" -ForegroundColor Cyan
}

# 統計情報
$created = 0
$skipped = 0
$failed = 0

Write-Host ""
Write-Host "ラベル作成を開始します..." -ForegroundColor Green
Write-Host "----------------------------------------" -ForegroundColor Gray

foreach ($label in $labels) {
    $name = $label.Name
    $description = $label.Description
    $color = $label.Color
    
    # 既存ラベルのチェック
    if ($existingLabels -contains $name) {
        Write-Host "⏭️  スキップ: '$name' (既に存在)" -ForegroundColor Yellow
        $skipped++
        continue
    }
    
    # ラベル作成
    Write-Host "🏷️  作成中: '$name'" -NoNewline
    
    try {
        $result = gh label create `
            --repo $Repository `
            $name `
            --description "$description" `
            --color $color `
            --force 2>&1
        
        if ($LASTEXITCODE -eq 0) {
            Write-Host " ✅" -ForegroundColor Green
            Write-Host "    説明: $description" -ForegroundColor Gray
            Write-Host "    色: #$color" -ForegroundColor Gray
            $created++
        } else {
            Write-Host " ❌" -ForegroundColor Red
            Write-Host "    エラー: $result" -ForegroundColor Red
            $failed++
        }
    } catch {
        Write-Host " ❌" -ForegroundColor Red
        Write-Host "    エラー: $_" -ForegroundColor Red
        $failed++
    }
    
    # API制限対策
    Start-Sleep -Milliseconds 500
}

Write-Host ""
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "ラベル作成完了！" -ForegroundColor Green
Write-Host "----------------------------------------" -ForegroundColor Gray
Write-Host "✅ 作成: $created" -ForegroundColor Green
Write-Host "⏭️  スキップ: $skipped" -ForegroundColor Yellow
Write-Host "❌ 失敗: $failed" -ForegroundColor Red
Write-Host "========================================" -ForegroundColor Cyan

# 作成後のラベル一覧表示
Write-Host ""
Write-Host "現在のラベル一覧を表示しますか？ (Y/N): " -NoNewline -ForegroundColor Cyan
$showList = Read-Host

if ($showList -eq 'Y' -or $showList -eq 'y') {
    Write-Host ""
    Write-Host "現在のラベル一覧:" -ForegroundColor Green
    Write-Host "----------------------------------------" -ForegroundColor Gray
    gh label list --repo $Repository --sort name --limit 100
}

Write-Host ""
Write-Host "スクリプト実行完了！" -ForegroundColor Green