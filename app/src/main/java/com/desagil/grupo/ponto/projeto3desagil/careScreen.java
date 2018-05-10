package com.desagil.grupo.ponto.projeto3desagil;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class careScreen extends AppCompatActivity {

    public void sendSMS(String phoneNo, String msg) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_screen);

        final Button painButton = (Button)findViewById(R.id.painButton);
        final Button thirstButton = (Button)findViewById(R.id.thirstButton);
        final Button dirtyButton = (Button)findViewById(R.id.dirtyButton);
        final Button hungryButton = (Button)findViewById(R.id.hungryButton);
        final Button backButton = (Button)findViewById(R.id.backButton);

        painButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permissions = new String[1];
                permissions[0] = Manifest.permission.SEND_SMS;

                // Esse método vai pedir as permissões para o usuário. Quando o usuário
                // responder, será chamado o método onRequestPermissionsResult abaixo.
                ActivityCompat.requestPermissions(careScreen.this, permissions, 0);

                sendSMS("5511998136972", painButton.getText().toString());
            }
        });

        thirstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permissions = new String[1];
                permissions[0] = Manifest.permission.SEND_SMS;

                // Esse método vai pedir as permissões para o usuário. Quando o usuário
                // responder, será chamado o método onRequestPermissionsResult abaixo.
                ActivityCompat.requestPermissions(careScreen.this, permissions, 0);

                sendSMS("5511998136972", thirstButton.getText().toString());
            }
        });

        dirtyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permissions = new String[1];
                permissions[0] = Manifest.permission.SEND_SMS;

                // Esse método vai pedir as permissões para o usuário. Quando o usuário
                // responder, será chamado o método onRequestPermissionsResult abaixo.
                ActivityCompat.requestPermissions(careScreen.this, permissions, 0);

                sendSMS("5511998136972", dirtyButton.getText().toString());
            }
        });

        hungryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permissions = new String[1];
                permissions[0] = Manifest.permission.SEND_SMS;

                // Esse método vai pedir as permissões para o usuário. Quando o usuário
                // responder, será chamado o método onRequestPermissionsResult abaixo.
                ActivityCompat.requestPermissions(careScreen.this, permissions, 0);

                sendSMS("5511998136972", hungryButton.getText().toString());
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(careScreen.this, MainActivity.class));
            }
        });

    }
}
