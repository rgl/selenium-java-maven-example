# syntax=docker.io/docker/dockerfile:1.17

# see https://github.com/devcontainers/images/tree/main/src/java
FROM mcr.microsoft.com/devcontainers/java:21-bookworm

RUN <<'EOF'
#!/usr/bin/bash
set -euxo pipefail
# ensure /etc/profile is called at the top of the file, when running in a
# login shell.
sed -i '0,/esac/s/esac/&\n\nsource \/etc\/profile/' /home/vscode/.bashrc
EOF
COPY .devcontainer/inputrc /etc/inputrc
COPY .devcontainer/login.sh /etc/profile.d/login.sh
