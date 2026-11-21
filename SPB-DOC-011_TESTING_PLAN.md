# SPB-DOC-011 — TESTING PLAN
## أنواع الاختبار
- Static: تنسيق، lint، فحص الأسرار، dependency review.
- Unit: منطق حالات التنزيل والتوجيه والتخزين.
- Integration: repositories مع قواعد البيانات وواجهات Android.
- UI: اتجاه RTL/LTR، حالات فارغة وخطأ وتحميل.
- Device: أحجام شاشات وإصدارات Android المستهدفة.
- Security: WebView، TLS، الصلاحيات، تسرب البيانات.
- Regression: إعادة الاختبارات بعد كل تغيير.

## PH-00
1. فحص وجود ملفات Gradle والManifest.
2. بناء assembleDebug.
3. التحقق من وجود APK.
4. تثبيت APK على جهاز/محاكي.
5. تشغيل التطبيق والتحقق من شاشة PH-00.
6. تسجيل إصدار JDK/Gradle/SDK ونتيجة البناء وSHA-256.

لا يُسجل الاختبار ناجحًا إلا مع سجل أو دليل فعلي.
