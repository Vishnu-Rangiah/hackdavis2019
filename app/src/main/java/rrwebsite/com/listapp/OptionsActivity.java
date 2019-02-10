package rrwebsite.com.listapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        Button menu = (Button) findViewById(R.id.menubutton);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //still have to Options activity ready
                Intent startIntentMenu = new Intent(getApplicationContext(),ListActivity.class);
                startActivity(startIntentMenu);
            }
        });

        Button filter = (Button) findViewById(R.id.filterButton);

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //still have to Options activity ready
                EditText options = (EditText) findViewById(R.id.optionsEditText);
                String chosenOption = options.getText().toString();
                Intent startIntentfil = new Intent(getApplicationContext(),ListActivity.class);
                startIntentfil.putExtra("YOURSTRING",chosenOption);
                startActivity(startIntentfil);
            }
        });


    }
}
