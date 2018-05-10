package com.desagil.grupo.ponto.projeto3desagil;

import android.support.v7.app.AppCompatActivity;
import java.lang.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class smsToNumber extends AppCompatActivity {

    public class MainActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sms_to_number);

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
        }
    }
}