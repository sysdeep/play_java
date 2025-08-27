# Play Java

## LSP

### JDT

download from https://download.eclipse.org/jdtls/snapshots/?d
extract

NOTE - required java 21
try run

```bash
JAVA_HOME=/opt/jdk-22.0.1/ ./bin/jdtls
```

### Helix

./config/helix/languages.toml

```toml
[[language]]
name = "java"
scope = "source.java"
injection-regex = "java"
file-types = ["java"]
roots = ["build.xml", "pom.xml", "settings.gradle", "settings.gradle.kts"]

language-servers = ["myjava-lsp"]
indent = { tab-width = 4, unit = "    " }



[language-server.myjava-lsp]
command = "/home/igor/Temp/jdt/bin/jdtls"
# args = ["--stdio"]
# config = { provideFormatter = true }
environment = { "JAVA_HOME" = "/opt/jdk-22.0.1/" }
```
