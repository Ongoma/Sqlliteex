package com.example.sqliteexampleem;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MainrActivity extends Activity {
ListView list;
CustomAdapter adapter;
ArrayList<Refugee> data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainr);
		list = (ListView)findViewById(R.id.listView1);
		Database db = new Database(this);
		data = db.fetch();
		adapter = new CustomAdapter(this,data);
		list.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mainr, menu);
		return true;
	}

}
