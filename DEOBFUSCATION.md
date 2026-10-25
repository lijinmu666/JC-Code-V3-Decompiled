# JC Code V3 源代码去混淆

运行 `python3 deobfuscate.py`，或查看 Actions 的 **Deobfuscate source** 工作流。
生成结果自动提交至 `readable/sources/`，涵盖全部 DEX 中 JADX 能还原的类。

- `LocalAdbBridge`：本地 ADB 文件命令桥。
- `AdbConnectionManager`：ADB 连接与配对管理。
- `CloudGateClient`：云控 HTTPS、域名解析、响应时间戳与 HMAC 校验。
- 已确认功能的方法和字段使用 `deobfuscation.tiny` 中的语义名称，调用引用由 JADX 统一解析。
- 其余短标识符由 JADX 自动生成别名；这些名字不代表已确认业务含义。
- `readable/automatic.jobf` 保留自动映射，`semantic.tiny` 保留人工映射。
- `readable/report.json` 和 `jadx.log` 记录生成数量及反编译错误。生成成功不代表所有方法都正确还原。

没有原作者的 mapping 文件，无法恢复被删除的原始类名、变量名、注释。
本版本是可读性还原，Java 仍是阅读参考，构建继续使用原 Smali。
原生 SO 的 C/C++ 源码尚未还原。签名校验、云控和反 Hook 行为均保留。
