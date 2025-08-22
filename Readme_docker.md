# Ubuntu Docker インストールガイド

## 概要
このガイドでは、Ubuntu上にDockerを公式リポジトリからインストールする手順を説明します。

## 前提条件
- Ubuntu 20.04 LTS以降
- sudo権限を持つユーザー
- インターネット接続

## インストール手順

### 1. システムの更新
```bash
sudo apt update
sudo apt upgrade -y
```

### 2. 必要なパッケージのインストール
```bash
sudo apt install -y \
    ca-certificates \
    curl \
    gnupg \
    lsb-release
```

### 3. DockerのGPGキーを追加
```bash
sudo mkdir -m 0755 -p /etc/apt/keyrings
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg
```

### 4. Dockerリポジトリを追加
```bash
echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu \
  $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
```

### 5. パッケージリストの更新とDockerのインストール
```bash
sudo apt update
sudo apt install -y docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
```

### 6. Dockerサービスの開始と自動起動設定
```bash
sudo systemctl start docker
sudo systemctl enable docker
```

### 7. 現在のユーザーをdockerグループに追加
sudoを使わずにDockerコマンドを実行できるようにします：
```bash
sudo usermod -aG docker $USER
```

### 8. グループ変更の反映
以下のいずれかを実行してください：

**オプション A: 新しいシェルセッションを開始**
```bash
newgrp docker
```

**オプション B: ログアウト・ログインする**

## インストール確認

### Dockerのバージョン確認
```bash
docker --version
docker compose version
```

### テスト実行
```bash
docker run hello-world
```

正常にインストールされていれば、Hello Worldメッセージが表示されます。

## よく使用するDockerコマンド

### 基本コマンド
```bash
# コンテナ一覧表示
docker ps

# イメージ一覧表示
docker images

# コンテナの停止
docker stop <コンテナID>

# コンテナの削除
docker rm <コンテナID>

# イメージの削除
docker rmi <イメージID>
```

### システム情報
```bash
# Dockerシステム情報
docker system info

# ディスク使用量確認
docker system df
```

## トラブルシューティング

### 権限エラーが発生する場合
```bash
# dockerグループに追加されているか確認
groups $USER

# Dockerサービスの状態確認
sudo systemctl status docker
```

### Dockerサービスが起動しない場合
```bash
# サービスログの確認
sudo journalctl -u docker.service

# サービスの再起動
sudo systemctl restart docker
```

## アンインストール（必要な場合）
```bash
# Dockerパッケージの削除
sudo apt purge docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin

# 設定ファイルとデータの削除
sudo rm -rf /var/lib/docker
sudo rm -rf /var/lib/containerd
```

## 参考リンク
- [Docker公式ドキュメント](https://docs.docker.com/engine/install/ubuntu/)
- [Docker Hub](https://hub.docker.com/)