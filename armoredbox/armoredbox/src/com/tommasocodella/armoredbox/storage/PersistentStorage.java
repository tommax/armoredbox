package com.tommasocodella.armoredbox.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PersistentStorage extends SQLiteOpenHelper{

	private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "ArmoredBoxPersistentStorage";
    
    public static final String PASSWORD_TABLE = "password";
    
	public PersistentStorage(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS " + PASSWORD_TABLE + "(passwordID INTEGER PRIMARY KEY AUTOINCREMENT, passwordName VARCHAR(1024), passwordValue TEXT);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}