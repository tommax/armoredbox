package com.tommasocodella.armoredbox;


import com.tommasocodella.armoredbox.storage.PersistentStorage;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class ArmoredBoxListActivity extends ListActivity {
	
	private PersistentStorage armoredBoxPersistentStorage 	= null;
	private SQLiteDatabase armoredBoxDB 					= null;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        armoredBoxPersistentStorage = new PersistentStorage(this);
        armoredBoxDB = armoredBoxPersistentStorage.getWritableDatabase();
        
        Cursor c = armoredBoxDB.query(PersistentStorage.PASSWORD_TABLE, new String[]{"passwordName"}, null, null, null, null, null);
        
        CursorAdapter ds = new SimpleCursorAdapter(this,R.layout.passwordlist,c,new String[]{"passwordName"},new int[]{R.id.first});
        
        setListAdapter(ds);
    }
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.armoredboxmenu, menu);
        menu.removeItem(R.id.listAll);
        return true;
    }
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
	        case R.id.addItem:
	        	startActivity(new Intent(this, ArmoredboxAddItemActivity.class));
	            return true;
	        case R.id.reloadList:
	        	
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
        }
    }
}
