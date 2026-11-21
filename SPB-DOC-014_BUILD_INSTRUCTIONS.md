# SPB-DOC-014 — BUILD INSTRUCTIONS
## محليًا
- JDK 17.
- Android SDK Platform 35 وBuild Tools مناسبة.
- افتح جذر المشروع في Android Studio أو شغّل `./gradlew assembleDebug`.
- Windows: `gradlew.bat assembleDebug`.
- الناتج: `app/build/outputs/apk/debug/app-debug.apk`.

## سحابيًا
- ارفع المشروع إلى مستودع خاص.
- اربط Codemagic يدويًا بنطاق مستودع واحد.
- راجع الخطة والرصيد ونوع الآلة قبل البناء.
- استخدم `codemagic.yaml`.
- نزّل artifact من صفحة البناء.

## استكشاف الأعطال
- SDK not found: راجع إعداد Android SDK في بيئة البناء.
- JDK mismatch: اختر JDK 17.
- dependency resolution: راجع اتصال الشبكة وGoogle/Maven repositories.
- Gradle bootstrap: تحقق من تنزيل Gradle وفك الضغط.
لا تضع local.properties أو ملفات أسرار في Git.
