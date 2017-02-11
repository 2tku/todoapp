package com.example.thuattq1.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by thuattq1 on 2/10/2017.
 */

@Database(name = TodoDB.NAME, version = TodoDB.VERSION)
public class TodoDB extends AbstractDB {
    public static final String NAME = "TodoDataBase";
    public static final int VERSION = 1;
}
