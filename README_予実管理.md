下記のエラー

[man-hour ≡]python .\manHour\scripts\update_summary.py
予定工数ファイルが見つかりません


# 設定
- manHour/scripts
  

# コマンド、エイリアス
- 予定工数追加、更新
``` 
plantask -command add -id TASK-001 -name "要件定義" -category "分析" -assignee "yamada" -hours 24 -start "2025-03-24" -end "2025-03-28"
```

- 予定工数削除
```
plantask -command delete -id TASK-001
```

- 予定タスク一覧表示
```
plantask
```

- 今日の作業を記録（担当者を指定）
```
logtime -task TASK-001 -hours 2.5 -assignee yamada -notes "API実装"
```

- 特定の日付の作業を記録
```
logtime -task TASK-002 -hours 3.0 -assignee tanaka -date 2025-03-20 -notes "DB設計"
```

```
logtime -task TASK-001 -Hours 2.5 -Notes "APIの実装"
```

- 作業実績一覧表示
```
logtime -list
```

# 予実のindex.html表示URL
- https://mik-organization.github.io/[リポジトリ名]/

# powershell PROFILE設定
## 予定工数登録
```
function plantask {
    param (
        [Parameter(Mandatory=$false)]
        [string]$command,
        
        [Parameter(Mandatory=$false)]
        [string]$id,
        
        [Parameter(Mandatory=$false)]
        [string]$name,
        
        [Parameter(Mandatory=$false)]
        [string]$category,
        
        [Parameter(Mandatory=$false)]
        [string]$assignee,
        
        [Parameter(Mandatory=$false)]
        [string]$hours,
        
        [Parameter(Mandatory=$false)]
        [string]$start,
        
        [Parameter(Mandatory=$false)]
        [string]$end
    )
    
    # スクリプトのパスを実際の場所に変更してください
    $scriptPath = "C:\Users\USER\Documents\work\git\mik\edu-tanaka\manHour\scripts\planned_task.py"
    
    if ($command -eq "add") {
        if (!$id -or !$name -or !$category -or !$assignee -or !$hours -or !$start -or !$end) {
            Write-Host "追加するには全てのパラメータが必要です"
            Write-Host "使用法: plantask -command add -id TASK-001 -name '要件定義' -category '分析' -assignee 'yamada' -hours 24 -start '2025-03-24' -end '2025-03-28'"
            return
        }
        python $scriptPath add --id $id --name $name --category $category --assignee $assignee --hours $hours --start $start --end $end
    } 
    elseif ($command -eq "delete") {
        if (!$id) {
            Write-Host "削除するにはタスクIDが必要です"
            Write-Host "使用法: plantask -command delete -id TASK-001"
            return
        }
        python $scriptPath delete --id $id
    } 
    elseif ($command -eq "list" -or !$command) {
        python $scriptPath list
    } 
    else {
        Write-Host "使用法:"
        Write-Host "  タスク追加: plantask -command add -id TASK-001 -name '要件定義' -category '分析' -assignee 'yamada' -hours 24 -start '2025-03-24' -end '2025-03-28'"
        Write-Host "  タスク削除: plantask -command delete -id TASK-001"
        Write-Host "  タスク一覧: plantask -command list （または単に plantask）"
    }
}
```

## 作業実績登録
```
function logtime {
    param (
        [Parameter(Mandatory=$false)]
        [string]$task,
        
        [Parameter(Mandatory=$false)]
        [string]$hours,
        
        [Parameter(Mandatory=$false)]
        [string]$notes = "",
        
        [Parameter(Mandatory=$false)]
        [switch]$list
    )
    
    $scriptPath = "C:\Users\USER\Documents\work\git\mik\edu-tanaka\manHour\scripts\log_time.py" # 例: "C:\Projects\time-tracking\scripts\log_time.py"
    
    if ($list) {
        python $scriptPath --list
    } elseif ($task -and $hours) {
        python $scriptPath --task $task --hours $hours --notes $notes
    } else {
        Write-Host "使用法: logtime -task #1 -hours 2.5 [-notes 'メモ']"
        Write-Host "タスク一覧の表示: logtime -list"
    }
}
```