package com.example.actint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class IntentObjekActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_objek);

        //get the data passed inn using getStringExtra()
        Toast.makeText(this, getIntent().getStringExtra("str 1"),
                Toast.LENGTH_SHORT).show();
        //get the data passed in using getIntExtra()
        Toast.makeText(this, Integer.toString(getIntent().getIntExtra("age 1", 0)),
                Toast.LENGTH_SHORT).show();
        //get the bundle objek passed in
        Bundle bundle = getIntent().getExtras();
        //get the data using getString
        Toast.makeText(this, bundle.getString("str 2"), Toast.LENGTH_SHORT).show();
        //get the data using getInt
        Toast.makeText(this, Integer.toString(bundle.getInt("age 2")),
                Toast.LENGTH_SHORT).show();
    }

    public void onClickBackEvent(View view){
        //use an intent object to return data
        Intent i = new Intent();
        //use putExtra method to return some value
        i.putExtra("age 3", 45);
        //use setData() method to return some value
        i.setData(Uri.parse("Something passed back to the main activity"));
        //set the resulrt with ok and the intent objek
        setResult(RESULT_OK, i);
        //destroy the ccurent activity
        finish();
    }
}