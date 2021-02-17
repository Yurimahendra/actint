package com.example.actint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "Acitivity Lifecycle";
    int request_code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Pada Event onCreate()");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG,"Pada Event onStart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG, "Pada Event onResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG, "Pada event onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG, "Pada event onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG, "Pada event onRestart()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "Pada event onDestroy()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Log.i(TAG, "Pada Event onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        Log.i(TAG, "Pada event onRestoreInstanceState()");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // inlfate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_state_change, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //handle action bar item click here. the action bar will
        //automation handle clikcs on the home/up button, so long
        //as you specify a parent activity in android manifest.xml

        int id = item.getItemId();

        //noininspection simplifiableifStatement
        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickEvent(View view){
        Intent i = new Intent(".OtherActivity");
      //  Intent ii = new Intent(".AnOtherActivity");
        startActivity(i);
       // startActivity(ii);

    }

    public void onClickEventAnOther(View view){
        Intent i = new Intent(".AnOtherActivity");
        startActivityForResult(i, request_code);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == request_code) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
            }
        }else if (requestCode == 2) {
            if (resultCode == RESULT_OK){
                //get the result using getIntExtra()
                Toast.makeText(this, Integer.toString(data.getIntExtra("age 3", 0)),
                        Toast.LENGTH_SHORT).show();
                // get the result using getData()
                Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onClickIntentEvent(View view){
        Intent i = new Intent(".IntentObjekActivity");
        //using putExxtra() to add new name/value pairs
        i.putExtra("str 1", "This is a string");
        i.putExtra("age 1", 25);
        //using a bundle object to add new name/value pairs
        Bundle extras = new Bundle();
        extras.putString("str 2", "This is another string");
        extras.putInt("age 2 ", 35);
        //attached the bundle objek to the intent objek
        i.putExtras(extras);
        //start the activity to get a result back
        startActivityForResult(i, 2);

    }

    public void onClickMapsEvent(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-6.851433, 109.146020"));
        startActivity(i);
    }

    public void onClickCallEvent(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+6282225491137"));
        startActivity(i);
    }

    public void onClickBrowserEvent(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://anoboy.tube/"));
        startActivity(i);
    }
}