# delete-all-labels.ps1
# 既存のラベルをすべて削除するスクリプト（危険！慎重に使用してください）
# 使用方法: .\delete-all-labels.ps1 -Owner "username" -Repo "repository-name"

param(
    [Parameter(Mandatory=$true)]
    [string]$Owner,
    [Parameter(Mandatory=$true)]
    [string]$Repo,
    [switch]$Force  # 確認なしで削除
)

$Repository = "$Owner/$Repo"

Write-Host "========================================" -ForegroundColor Red
Write-Host "⚠️  警告: ラベル一括削除スクリプト" -ForegroundColor Red
Write-Host "リポジトリ: $Repository" -ForegroundColor Yellow
Write-Host "========================================" -ForegroundColor Red
Write-Host ""

# 既存ラベルの取得
Write-Host "既存のラベルを取得中..." -ForegroundColor Yellow
$labelsJson = gh label list --repo $Repository --json name --limit 100 2>$null

if ($LASTEXITCODE -ne 0) {
    Write-Host "エラー: リポジトリにアクセスできません。" -ForegroundColor Red
    exit 1
}

$labels = $labelsJson | ConvertFrom-Json

if ($labels.Count -eq 0) {
    Write-Host "削除するラベルがありません。" -ForegroundColor Green
    exit 0
}

Write-Host "削除対象のラベル数: $($labels.Count)" -ForegroundColor Yellow
Write-Host ""

# 確認
if (-not $Force) {
    Write-Host "以下のラベルが削除されます:" -ForegroundColor Yellow
    foreach ($label in $labels) {
        Write-Host "  - $($label.name)" -ForegroundColor Gray
    }
    Write-Host ""
    Write-Host "本当にすべてのラベルを削除しますか？ (yes/no): " -NoNewline -ForegroundColor Red
    $confirmation = Read-Host
    
    if ($confirmation -ne 'yes') {
        Write-Host "削除をキャンセルしました。" -ForegroundColor Green
        exit 0
    }
}

# ラベル削除実行
$deleted = 0
$failed = 0

Write-Host ""
Write-Host "ラベル削除を開始します..." -ForegroundColor Yellow

foreach ($label in $labels) {
    $name = $label.name
    Write-Host "🗑️  削除中: '$name'" -NoNewline
    
    try {
        gh label delete --repo $Repository $name --yes 2>&1 | Out-Null
        
        if ($LASTEXITCODE -eq 0) {
            Write-Host " ✅" -ForegroundColor Green
            $deleted++
        } else {
            Write-Host " ❌" -ForegroundColor Red
            $failed++
        }
    } catch {
        Write-Host " ❌" -ForegroundColor Red
        $failed++
    }
    
    Start-Sleep -Milliseconds 500
}

Write-Host ""
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "削除完了！" -ForegroundColor Green
Write-Host "✅ 削除成功: $deleted" -ForegroundColor Green
Write-Host "❌ 削除失敗: $failed" -ForegroundColor Red
Write-Host "========================================" -ForegroundColor Cyan