package com.example.actint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AnOtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an_other);
    }

    public void onClickBtnName(View view){
        Intent data = new Intent();
        //get the editText view data
        EditText editName = (EditText) findViewById(R.id.editName);
        //set the data to pass back
        data.setData(Uri.parse(editName.getText().toString()));
        setResult(RESULT_OK, data);
        //close activity
        finish();
    }


}