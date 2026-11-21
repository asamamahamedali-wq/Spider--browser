#!/usr/bin/env sh
set -eu
test -f settings.gradle.kts
test -f build.gradle.kts
test -f app/build.gradle.kts
test -f app/src/main/AndroidManifest.xml
test -f app/src/main/java/com/osama/spiderbrowser/MainActivity.kt
test -f codemagic.yaml
echo "Project structure checks passed."
