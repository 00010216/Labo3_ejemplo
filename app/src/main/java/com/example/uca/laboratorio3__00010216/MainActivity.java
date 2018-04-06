package com.example.uca.laboratorio3__00010216;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edit = findViewById(R.id.etxt1);
        Button but = findViewById(R.id.btn_send);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain"); //tipo de info que se enviara
                sendIntent.putExtra(Intent.EXTRA_TEXT, edit.getText().toString()); //convertir info de edit text a string
                Intent chooser = Intent.createChooser(sendIntent,"Pregunta");

                if (sendIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(chooser); //sendIntent
                }
            }
        });
    }
}
