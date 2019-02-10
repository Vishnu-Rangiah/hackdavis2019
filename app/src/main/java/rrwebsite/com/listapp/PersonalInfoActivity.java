package rrwebsite.com.listapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PersonalInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);


        Button sub = (Button) findViewById(R.id.submitButton);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //still have to Options activity ready
                Intent startIntentsub = new Intent(getApplicationContext(),OptionsActivity.class);
                startActivity(startIntentsub);
            }
        });


    }
}
