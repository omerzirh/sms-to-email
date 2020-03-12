package com.example.smsthesavior1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView mAdress;

    public Button btBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdress = findViewById(R.id.emailTextView);
        btBack = findViewById(R.id.backButton);

        SharedPreferences result = getSharedPreferences("SaveData",MODE_PRIVATE);

        String mail = result.getString("Value","Data not found");
        mAdress.setText("Sending to: "+mail);

        //Sending mail
        Bundle extras = getIntent().getExtras();

                if(extras!=null){
            String adress = extras.getString("from");
            String smsMessage = extras.getString("message");
            JavaMailAPI javaMailAPI = new JavaMailAPI(this,mail,adress,smsMessage);
            javaMailAPI.execute();

        }
               //go back to 1st activity
                btBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
    }


}
