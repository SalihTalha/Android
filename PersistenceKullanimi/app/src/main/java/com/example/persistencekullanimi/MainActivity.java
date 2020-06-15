package com.example.persistencekullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int say;
    TextView tv;
    Button bArtir, bAzalt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if( savedInstanceState != null){
            say = savedInstanceState.getInt("mesaj");
        }
        say = 0;
        tv = (TextView) findViewById(R.id.sayac);
        bArtir = (Button) findViewById(R.id.buton);
        bAzalt = (Button) findViewById(R.id.butoff);

        bArtir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                say++;
                tv.setText(String.valueOf(say));
            }
        });

        bAzalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(say != 0){
                    say--;
                    tv.setText(String.valueOf(say));
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle Outstate){
        super.onSaveInstanceState(Outstate);
        Outstate.putInt("mesaj", say);
    }


}