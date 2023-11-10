# 本間研修メモ
## Powershellで環境変数

1. Pathの表示

```powershell:powershell
$ENV:Path
```

さらに、Splitメソッド を使って、出力結果を見やすく表示
```powershell:powershell
$ENV:Path.Split(";")
```
2. 環境変数に新しいパスを追加する
- 先頭に追加
```powershell:powershell
$ENV:Path="追加したいパス;"+$ENV:Path
```
- 末尾に追加（これが使いやすそう）
```powershell:powershell
$ENV:Path+=";追加したいパス"
```
今は使わなそうだけど念のため、パスの削除と置換
3. Replaceメソッドを使って、置換や一削除
```powershell:powershell
Set-Item ENV:Path $ENV:Path.Replace("置換前のパス;", "置換後のパス;")
```
```powershell:powershell
Set-Item ENV:Path $ENV:Path.Replace("削除したいパス;", "")
```
---
## Powershellでjavaを実行

[参考サイト](https://programming-tips.jp/archives/s/24/index.html)

webサイトから openjdk をインストールして、Powershellでコンパイルして”Hello, world!”と表示させる
ますは`New-Item Main.java`と入力して"Main.java"という名前のファイルを作成して、`code .\Main.java`と入力してvscodeに以下貼り付け。

```java:Main.java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
```
（↑ ファイル名とシンタックスハイライトが入らない。なんで？）

次に、Powershellから、`javac Main.java`と入力して、コンパイルされた .class 実行形式のファイルを作成
最後に、`java Main`と入力して実行（拡張子の .class は除く）

`Hello, world!`