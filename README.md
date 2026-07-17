# Guess Number Game

一个“三端统一”的猜数字游戏平台实验项目，包含 Java Swing 桌面客户端、浏览器前端、微信小程序和 Spring Boot 服务端，用于练习跨端交互、WebSocket 同步、用户登录与游戏记录管理。

## 组成

- **Java 桌面端**：Swing 游戏界面，通过 WebSocket 与服务端交换数据。
- **Web 端**：原生 HTML、CSS 和 JavaScript 实现游戏页面。
- **微信小程序**：包含游戏、历史记录与日志页面。
- **服务端**：Spring Boot、WebSocket、Spring Security、Thymeleaf、JPA 与 MySQL。
- **项目文档**：需求、架构与部署资料集中在 `实训《猜数字》/` 下。

## 目录结构

```text
GuessNumberGame/
`-- 实训《猜数字》/
    |-- untitled/                  # Java Swing 客户端（Maven）
    |-- web1/                      # 静态 Web 客户端
    |-- web_service/game-server/   # Spring Boot 服务端
    |-- wx/                        # 微信小程序
    `-- 📚《三端统一猜数字游戏平台》项目文档目录骨架.md
```

## 环境要求

- JDK 22 与 Maven 3.9（桌面客户端）
- 与 Spring Boot 3.2 兼容的 JDK 和 Maven（服务端）
- MySQL（服务端持久化）
- 微信开发者工具（小程序端）
- 现代浏览器（Web 端）

## 构建

桌面客户端：

```powershell
cd '实训《猜数字》\untitled'
mvn clean package
```

服务端：

```powershell
cd '实训《猜数字》\web_service\game-server'
mvn spring-boot:run
```

启动前需检查服务端的 `application.properties`，配置本地数据库和端口；再让各客户端使用对应的 HTTP/WebSocket 地址。

## 注意事项

- 不要提交数据库密码、部署凭证或真实访问令牌。
- 仓库包含 `target/`、编译后的 `.class`、JAR 和日志等可再生成产物，后续应通过 `.gitignore` 清理。
- 当前 Maven 配置中存在重复或不完整依赖项，首次构建前需要校正依赖声明。

## 状态

教学与实训项目。多端代码和服务端骨架已存在，但构建配置、凭证管理和部署流程仍需整理后才能稳定复现。
