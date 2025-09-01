# １．実装時
- [ ] ローカルブランチがissueに対応しているか確認
## issue着手(javaコーディング)
- [ ] 変数名のルールに従っているか
 【[ルール確認](https://www.javadrive.jp/start/var/index3.html#google_vignette)】
- [ ] 余計な入力はないか（括弧や冗長な入力）
- [ ] 直前宣言できているか
【[直前宣言確認](https://gihyo.jp/dev/serial/01/code/000302)】
## ドキュメント作成


# ２．実装後
- [ ] 動作確認
- [ ] 再度issueに対応しているbranchか確認
- [ ] windiffで変更点確認
- [ ] gitコマンドで成果物提出  


### 補足
### ブランチの準備
- [ ] issueに対するリモートブランチの作成
- [ ] issueに対するローカルブランチの作成  
  　
  ・git checkout -b newBranchName
  　　ブランチ作成し現ブランチ変更
  ・git checkout -b newBranchName origin/リモートbranch
　　ブランチ作成し追跡するブランチ設定後、現ブランチ変更
  ・git branch -u origin/リモートブランチ名
  　　追跡するブランチ変更
・git fetch origin branchName

  ・（git push --set-upstream origin リモートブランチ）
　　
- [ ] ローカルにpull  
  ・（ローカル pull origin リモート）
### プルリクエスト作成
- [ ] 設定作成
  Reviewers（確認者）Assignees（担当者（自分））
  Labels（対応するラベル選択）Projects（対応するプロジェクト選択）
  Development（関連するissue選択）
- [ ] コメントへの解答漏れ無いか