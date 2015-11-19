package com.example.sqliteexampleem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {
     EditText edtNames,edtAge,edtCountry;
     RadioButton rbMale;
     Button bRegister,bView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edtNames = (EditText)findViewById(R.id.etRNames);
		edtAge = (EditText)findViewById(R.id.etAge);
		edtCountry = (EditText)findViewById(R.id.etONation);
		rbMale = (RadioButton)findViewById(R.id.rMale);
		bRegister = (Button)findViewById(R.id.bRegister);
		bView = (Button)findViewById(R.id.bView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
    public void register(View v){
    	String names = edtNames.getText().toString();
    			String age = edtAge.getText().toString();
    			String origin = edtCountry.getText().toString();
    			String gender = rbMale.isChecked() ? "Male" : "Female";
    			Database db = new Database(this);
    			if(!names.equals("") && !age.equals("") && !origin.equals("") ){
    				db.save(names, origin, age, gender);
    				Toast.makeText(this, "# "+db.count(), Toast.LENGTH_LONG).show();
    				edtNames.setText("");
    				edtAge.setText("");
    				
    			}else{
    				Toast.makeText(this, "Empty Fields", Toast.LENGTH_LONG).show();
    			}
    }
    public void view(View v){
    	Intent i = new Intent(this, MainrActivity.class);
    	startActivity(i);
    }
}
