package com.desagil.grupo.ponto.fabioferrao;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Morse extends AppCompatActivity {

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
        setContentView(R.layout.activity_morse);


        final EditText textMsg = (EditText) findViewById(R.id.edit_example);
        final EditText NumMsg = (EditText) findViewById(R.id.editNum_example);
        final TextView DictDot = (TextView) findViewById(R.id.textViewDot);
        final TextView DictLine = (TextView) findViewById(R.id.textViewLine);
        final String[] text_msg = {""};
        final String[] text_letter = {""};
        final Translator Tradutor = new Translator();

        final boolean[] flagNum = {false};

        ImageButton buttonMorse = (ImageButton) findViewById(R.id.button_Morse);
        ImageButton button1 = (ImageButton) findViewById(R.id.button_1);
        ImageButton button2 = (ImageButton) findViewById(R.id.button_2);

        DictDot.setText("e");
        DictLine.setText("t");


        buttonMorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_letter[0] += ".";
                char[] dicts = Tradutor.childs(text_letter[0]);
                DictDot.setText(Character.toString(dicts[0]));
                DictLine.setText(Character.toString(dicts[1]));
                if (flagNum[0]) NumMsg.setText(text_msg[0] + text_letter[0]);
                else textMsg.setText(text_msg[0] + text_letter[0]);

            }
        });

        buttonMorse.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                text_letter[0]+= "_";
                char[] dicts = Tradutor.childs(text_letter[0]);
                DictDot.setText(Character.toString(dicts[0]));
                DictLine.setText(Character.toString(dicts[1]));
                if(flagNum[0]) NumMsg.setText(text_msg[0] + text_letter[0]);
                else textMsg.setText(text_msg[0] + text_letter[0]);
                return true;

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text_letter[0].length() == 0) {
                    if (text_msg[0].length() > 0) {
                        text_msg[0] = text_msg[0].substring(0, text_msg[0].length() - 1);
                    }
                }
                text_letter[0] = "";
                char[] dicts = Tradutor.childs(text_letter[0]);
                DictDot.setText(Character.toString(dicts[0]));
                DictLine.setText(Character.toString(dicts[1]));
                if(flagNum[0]) NumMsg.setText(text_msg[0] + text_letter[0]);
                else textMsg.setText(text_msg[0] + text_letter[0]);

            }
        });

        button1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(flagNum[0]){
                    flagNum[0] = false;
                    text_letter[0] = "";
                    NumMsg.setText(text_msg[0] + text_letter[0]);
                    text_msg[0] = textMsg.getText().toString();
                    char[] dicts = Tradutor.childs(text_letter[0]);
                    DictDot.setText(Character.toString(dicts[0]));
                    DictLine.setText(Character.toString(dicts[1]));

                } else{
                    startActivity(new Intent(Morse.this, MainActivity.class));
                }
                return true;

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text_letter[0].equals("")){
                    text_msg[0] += " ";

                } else{
                    text_msg[0] += Tradutor.morseToChar(text_letter[0]);
                    text_letter[0] = "";

                }
                char[] dicts = Tradutor.childs(text_letter[0]);
                DictDot.setText(Character.toString(dicts[0]));
                DictLine.setText(Character.toString(dicts[1]));
                if(flagNum[0]){
                    char last = text_msg[0].charAt(text_msg[0].length()-1);
                    if(!Character.isDigit(last)) text_msg[0] = text_msg[0].substring(0, text_msg[0].length() - 1);
                    NumMsg.setText(text_msg[0] + text_letter[0]);
                }
                else textMsg.setText(text_msg[0] + text_letter[0]);
            }
        });

        button2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(!flagNum[0]){
                    flagNum[0] = true;
                    text_letter[0] = "";
                    textMsg.setText(text_msg[0] + text_letter[0]);
                    text_msg[0] = NumMsg.getText().toString();
                    char[] dicts = Tradutor.childs(text_letter[0]);
                    DictDot.setText(Character.toString(dicts[0]));
                    DictLine.setText(Character.toString(dicts[1]));

                } else {

//                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + NumMsg.getText().toString()));
//                    intent.putExtra("sms_body", textMsg.getText().toString());
//                    startActivity(intent);

                    String[] permissions = new String[1];
                    permissions[0] = Manifest.permission.SEND_SMS;

                    // Esse método vai pedir as permissões para o usuário. Quando o usuário
                    // responder, será chamado o método onRequestPermissionsResult abaixo.
                    ActivityCompat.requestPermissions(Morse.this, permissions, 0);

                    sendSMS(NumMsg.getText().toString(),textMsg.getText().toString());

//                    SmsManager manager = SmsManager.getDefault();
//                    manager.sendTextMessage(NumMsg.getText().toString(), null, textMsg.getText().toString(), null, null);
                }
                return true;
            }
        });
    }
}