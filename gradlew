#!/usr/bin/env sh
set -eu
VERSION="8.9"
BASE="${GRADLE_USER_HOME:-$HOME/.gradle}/spider-bootstrap"
DIST="$BASE/gradle-$VERSION"
ARCHIVE="$BASE/gradle-$VERSION-bin.zip"
mkdir -p "$BASE"
if [ ! -x "$DIST/bin/gradle" ]; then
  if [ ! -f "$ARCHIVE" ]; then
    echo "Downloading Gradle $VERSION distribution..."
    if command -v curl >/dev/null 2>&1; then
      curl -fL "https://services.gradle.org/distributions/gradle-$VERSION-bin.zip" -o "$ARCHIVE"
    elif command -v wget >/dev/null 2>&1; then
      wget -O "$ARCHIVE" "https://services.gradle.org/distributions/gradle-$VERSION-bin.zip"
    else
      echo "curl or wget is required to bootstrap Gradle." >&2; exit 2
    fi
  fi
  if command -v unzip >/dev/null 2>&1; then
    unzip -q -o "$ARCHIVE" -d "$BASE"
  else
    echo "unzip is required to unpack Gradle." >&2; exit 2
  fi
fi
exec "$DIST/bin/gradle" "$@"
