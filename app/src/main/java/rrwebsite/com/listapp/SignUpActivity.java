package rrwebsite.com.listapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button cont = (Button) findViewById(R.id.continueButton);

        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //still have to Options activity ready
                Intent startIntentCont = new Intent(getApplicationContext(),PersonalInfoActivity.class);
                startActivity(startIntentCont);
            }
        });



    }
}
