package com.android.launcher3.util;

import android.content.Context;

import com.android.launcher3.LauncherProvider;

/**
 * An extension of LauncherProvider backed up by in-memory database.
 */
public class TestLauncherProvider extends LauncherProvider {

    @Override
    public boolean onCreate() {
        return true;
    }

    @Override
    protected synchronized void createDbIfNotExists() {
        if (mOpenHelper == null) {
            mOpenHelper = new MyDatabaseHelper(getContext(), this);
        }
    }

    @Override
    protected void notifyListeners() { }

    private static class MyDatabaseHelper extends DatabaseHelper {
        public MyDatabaseHelper(Context context, LauncherProvider provider) {
            super(context, provider, null);
        }

        @Override
        protected long getDefaultUserSerial() {
            return 0;
        }

        @Override
        protected void onEmptyDbCreated() { }
    }
}