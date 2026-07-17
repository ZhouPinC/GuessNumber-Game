# 🎮 GuessNumberGame — 三端统一猜数字游戏平台

一个跨平台猜数字游戏，支持 **Web 端、Java 桌面端、微信小程序端** 三端同步体验，后端采用 Spring Boot + MySQL + WebSocket 实时通信。

## ✨ 功能亮点

### 核心玩法
- 🔢 **猜数字模式**：无限次数猜测，系统提示"偏大"/"偏小"
- ⚡ **挑战模式**：自定义最大尝试次数，限时挑战
- 🎯 **自定义区间**：支持设置任意数值范围（含负数）
- 📊 **难度评估**：自动计算理论最优次数，评定游戏难度
- 📜 **历史记录**：保存每次游戏的猜测过程

### 后台管理
- 📈 游戏数据统计（总次数、用户数、平均分）
- 🔍 按结果筛选游戏记录（胜利/失败/放弃）
- 🌐 WebSocket 实时同步游戏数据
- 🗑️ 清空记录管理

### 三端同步
- 🌍 **Web 端**：HTML5 + CSS3 + JavaScript 原生实现
- 🖥️ **Java 桌面端**：Swing GUI + WebSocket 客户端
- 📱 **微信小程序**：原生小程序框架

## 🏗️ 技术架构

| 层级 | 技术 |
|------|------|
| 后端框架 | Spring Boot 3.2.0 |
| 数据库 | MySQL 8.0 + Spring Data JPA |
| 实时通信 | WebSocket |
| 安全认证 | Spring Security + BCrypt |
| 模板引擎 | Thymeleaf |
| Web 前端 | 原生 HTML5 + CSS3 + JavaScript (ES6) |
| 桌面端 | Java Swing + WebSocket Client |
| 小程序端 | 原生微信小程序框架 |

## 📁 项目结构

```
GuessNumberGame/
├── 实训《猜数字》/
│   ├── web1/               # Web 前端（index.html / script.js / style.css）
│   ├── untitled/           # Java 桌面端 + Spring Boot 后端
│   │   ├── src/            # 后端源码
│   │   └── pom.xml         # Maven 配置
│   ├── web_service/
│   │   └── game-server/    # 独立部署的游戏服务
│   └── wx/                 # 微信小程序源码
│       ├── pages/          # 小程序页面
│       ├── utils/          # 工具函数
│       └── app.js/json/wxss
├── 项目改进说明.md          # 详细改进记录
├── 部署信息和访问凭证.md     # 部署文档
└── 📚《三端统一猜数字游戏平台》项目文档目录骨架.md
```

## 🚀 快速开始

### 后端

```bash
cd "实训《猜数字》/web_service/game-server"
mvn clean package -DskipTests
java -jar target/game-server-0.0.1-SNAPSHOT.jar
```

服务默认监听 `8080` 端口，WebSocket 地址为 `ws://localhost:8080/gameSync`。

### Web 前端

直接用浏览器打开 `实训《猜数字》/web1/index.html` 即可。

### Java 桌面端

```bash
cd "实训《猜数字》/untitled"
mvn clean package
java -jar target/untitled-1.0.jar
```

### 微信小程序

在微信开发者工具中导入 `实训《猜数字》/wx` 目录。

## 📖 更多文档

- [项目改进说明](./项目改进说明.md) — 安全加固、部署流程、三端对比、优化建议
- [部署信息和访问凭证](./部署信息和访问凭证.md) — 公网地址、数据库配置、快速体验指南
- [项目文档目录骨架](./实训《猜数字》/📚《三端统一猜数字游戏平台》项目文档目录骨架.md)

## ⚠️ 安全提示

- 首次部署后请立即修改默认管理员密码（`admin/admin123`）
- 生产环境建议配置 HTTPS + Nginx 反向代理
- 不提交含真实凭据的配置文件