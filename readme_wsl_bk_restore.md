# WSL バックアップ・復元手順

## 1. WSL状態確認

### ディストリビューション一覧確認
```powershell
wsl --list --verbose
```

### 実行中のWSLを停止
```powershell
# 全て停止
wsl --shutdown

# 特定のディストリビューションのみ停止
wsl --terminate Ubuntu
```

## 2. バックアップ取得

### 圧縮バックアップ（推奨）
```powershell
# 一時ファイルとして出力後、圧縮
wsl --export Ubuntu "ubuntu-backup.tar"
Compress-Archive -Path "ubuntu-backup.tar" -DestinationPath "ubuntu-backup-$date.zip"
Remove-Item "ubuntu-backup.tar"
```

## 3. 復元手順

### 既存環境への復元（上書き）
```powershell
# 1. 既存ディストリビューション削除
wsl --unregister Ubuntu

# 2. バックアップから復元
wsl --import Ubuntu "C:\WSL\Ubuntu" "C:\WSL-Backup\ubuntu-backup-20240220.tar"

# 3. デフォルトユーザー設定（必要に応じて）
ubuntu config --default-user your-username
```

### 新環境として復元
```powershell
# 異なる名前で復元
wsl --import Ubuntu-Backup "C:\WSL\Ubuntu-Backup" "C:\WSL-Backup\ubuntu-backup-20240220.tar"
```

### 圧縮ファイルからの復元
```powershell
# ZIPファイルを展開してから復元
Expand-Archive -Path "C:\WSL-Backup\ubuntu-backup-20240220.zip" -DestinationPath "C:\temp"
wsl --import Ubuntu "C:\WSL\Ubuntu" "C:\temp\ubuntu-backup.tar"
Remove-Item "C:\temp\ubuntu-backup.tar"
```

## 4. 復元後の確認

```powershell
# ディストリビューション確認
wsl --list --verbose

# WSL起動テスト
wsl -d Ubuntu
```

**確証度：97%** - 公式のwslコマンドを使用した標準的な手順です。
