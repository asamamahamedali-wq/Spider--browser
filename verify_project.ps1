$ErrorActionPreference = "Stop"
$required = @(
 "settings.gradle.kts",
 "build.gradle.kts",
 "app/build.gradle.kts",
 "app/src/main/AndroidManifest.xml",
 "app/src/main/java/com/osama/spiderbrowser/MainActivity.kt",
 "codemagic.yaml"
)
foreach ($file in $required) {
  if (!(Test-Path $file)) { throw "Missing required file: $file" }
}
Write-Output "Project structure checks passed."
