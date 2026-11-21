# SPB-DOC-007 — DATA DESIGN
## كيانات مقترحة
- BrowserTab(id, url, title, lastActiveAt, isPrivate)
- Bookmark(id, url, title, createdAt, folderId)
- HistoryEntry(id, url, title, visitedAt)
- DownloadTask(id, url, fileName, mimeType, totalBytes, downloadedBytes, status, createdAt, updatedAt, supportsRange)
- AppPreference(key, value)
- AiConsent(scope, grantedAt, expiresAt)

## ضوابط
- لا تخزين كلمات مرور المواقع.
- بيانات التصفح الخاص في الذاكرة فقط افتراضيًا، وتُزال عند إغلاق الجلسة.
- سياسة الاحتفاظ بالسجل قابلة للتحكم.
- لا تسجل محتوى الصفحات في سجلات الأعطال.
- تخزين ملفات التنزيل وفق Storage Access Framework/واجهات Android الحديثة المناسبة.
