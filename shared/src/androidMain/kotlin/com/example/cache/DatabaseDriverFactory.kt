package com.example.cache

import DEFAULT_CACHE_SIZE
import android.content.Context
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            AppDatabase.Schema,
            context,
            "test.db",
            factory = FrameworkSQLiteOpenHelperFactory(),
            callback = AndroidSqliteDriver.Callback(AppDatabase.Schema),
            cacheSize = DEFAULT_CACHE_SIZE,
            useNoBackupDirectory = false,
            windowSizeBytes = null
        )
    }
}