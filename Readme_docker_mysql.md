# Docker MySQL環境構築ガイド

## 概要
DockerでMySQL環境を作成し、初期化時に指定したDDL/DMLを自動実行する方法を説明します。

## プロジェクト構造
```
project/
├── docker-compose.yml
└── sql/
    ├── 01_create_tables.sql
    ├── 02_insert_data.sql
    └── 03_additional_setup.sql
```

## docker-compose.yml + ボリュームマウント

### docker-compose.yml
```yaml
version: '3.8'

services:
  mysql:
    image: mysql:8.0
    container_name: mysql_dev
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: mikdb
      MYSQL_USER: mik
      MYSQL_PASSWORD: mik
    ports:
      - "3306:3306"
    volumes:
      # 初期化SQLファイルをマウント
      - ./sql:/docker-entrypoint-initdb.d
      # データ永続化（オプション）
      - mysql_data:/var/lib/mysql
    command: --default-authentication-plugin=mysql_native_password

volumes:
  mysql_data:
```

### SQLファイル例

**sql/01_create_tables.sql**
```sql
-- データベースの選択
USE mikdb;

-- ユーザーテーブル作成
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 商品テーブル作成
CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

**sql/02_insert_data.sql**
```sql
-- テストユーザーデータ挿入
USE mikdb;

INSERT INTO users (username, email) VALUES 
('admin', 'admin@example.com'),
('user1', 'user1@example.com'),
('user2', 'user2@example.com');

-- テスト商品データ挿入
INSERT INTO products (name, price, description) VALUES 
('ノートPC', 89800.00, '高性能ノートパソコン'),
('マウス', 2980.00, 'ワイヤレスマウス'),
('キーボード', 8900.00, 'メカニカルキーボード');
```

## 複数ファイルの実行順序制御

SQLファイルは **アルファベット順** で実行されるため、ファイル名に番号を付けることで順序を制御できます：

```
sql/
├── 001_create_database.sql
├── 002_create_tables.sql
├── 003_create_indexes.sql
├── 004_insert_master_data.sql
├── 005_insert_test_data.sql
└── 999_final_setup.sql
```

## 実行手順

### 1. プロジェクトディレクトリ作成
```bash
mkdir mysql-docker-project
cd mysql-docker-project
```

### 2. ディレクトリ構造作成
```bash
mkdir sql
```

### 3. ファイル作成
- `docker-compose.yml`を作成
- `sql/`ディレクトリにSQLファイルを配置

### 4. 環境起動
```bash
# バックグラウンドで起動
docker-compose up -d

# ログ確認
docker-compose logs mysql
```

### 5. 接続確認
```bash
# MySQLに接続
docker exec -it mysql_dev mysql -u appuser -p myapp

# または
mysql -h localhost -P 3306 -u appuser -p myapp
```

## 高度な設定例

### 環境変数ファイル使用
**.env**
```env
MYSQL_ROOT_PASSWORD=your_secure_password
MYSQL_DATABASE=production_db
MYSQL_USER=app_user
MYSQL_PASSWORD=app_secure_password
```

### docker-compose.yml（環境変数使用）
```yaml
version: '3.8'

services:
  mysql:
    image: mysql:8.0
    container_name: mysql_dev
    env_file:
      - .env
    ports:
      - "3306:3306"
    volumes:
      - ./sql:/docker-entrypoint-initdb.d
      - mysql_data:/var/lib/mysql
    restart: unless-stopped

volumes:
  mysql_data:
```

## トラブルシューティング

### よくある問題と解決法

1. **SQLファイルが実行されない**
   ```bash
   # ボリュームを削除して再作成
   docker-compose down -v
   docker-compose up -d
   ```

2. **文字化け対策**
   ```yaml
   command: >
     --default-authentication-plugin=mysql_native_password
     --character-set-server=utf8mb4
     --collation-server=utf8mb4_unicode_ci
   ```

3. **ログ確認**
   ```bash
   # 初期化ログ確認
   docker-compose logs mysql | grep "docker-entrypoint-initdb.d"
   ```

## 便利なコマンド

```bash
# 環境の停止・削除
docker-compose down

# データも含めて完全削除
docker-compose down -v

# 環境の再構築
docker-compose up -d --force-recreate

# MySQLコンテナ内でシェル実行
docker exec -it mysql_dev bash
```

## セキュリティ考慮事項

- **本番環境では強力なパスワードを使用**
- **.env**ファイルを**.gitignore**に追加
- **必要最小限の権限でユーザーを作成**

```sql
-- 権限制限例
GRANT SELECT, INSERT, UPDATE, DELETE ON myapp.* TO 'appuser'@'%';
FLUSH PRIVILEGES;
```