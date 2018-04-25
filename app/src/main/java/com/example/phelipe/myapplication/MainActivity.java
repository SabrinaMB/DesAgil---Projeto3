package com.example.phelipe.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText textMsg = (EditText) findViewById(R.id.edit_example);
        final String[] text_msg = {""};
        final String[] text_letter = {""};

        Button buttonDot = (Button) findViewById(R.id.dot_button);
        Button buttonLine = (Button) findViewById(R.id.button_example);
        Button buttonSpace = (Button) findViewById(R.id.space_button);
        Button buttonDelete = (Button) findViewById(R.id.backspace_button);


        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_letter[0] += ".";
            }
        });

        buttonLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_letter[0] += "_";
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_letter[0] = "";
                if(text_msg[0].length() > 0) {
                    text_msg[0] = text_msg[0].substring(0, text_msg[0].length() - 1);
                }
                textMsg.setText(text_msg[0]);
            }
        });

        buttonSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text_letter[0].equals("")){
                    text_msg[0] += " ";
                    textMsg.setText(text_msg[0]);
                } else{
                    switch (text_letter[0]) {
                        case "._":
                            text_msg[0] += "a";
                            break;
                        case "_...":
                            text_msg[0] += "b";
                            break;
                        case "_._.":
                            text_msg[0] += "c";
                            break;
                        case "_..":
                            text_msg[0] += "d";
                            break;
                        case ".":
                            text_msg[0] += "e";
                            break;
                        case ".._.":
                            text_msg[0] += "f";
                            break;
                        case "__.":
                            text_msg[0] += "g";
                            break;
                        case "....":
                            text_msg[0] += "h";
                            break;
                        case "..":
                            text_msg[0] += "i";
                            break;
                        case ".___":
                            text_msg[0] += "j";
                            break;
                        case "_._":
                            text_msg[0] += "k";
                            break;
                        case "._..":
                            text_msg[0] += "l";
                            break;
                        case "__":
                            text_msg[0] += "m";
                            break;
                        case "_.":
                            text_msg[0] += "n";
                            break;
                        case "___":
                            text_msg[0] += "o";
                            break;
                        case ".__.":
                            text_msg[0] += "p";
                            break;
                        case "__._":
                            text_msg[0] += "q";
                            break;
                        case "._.":
                            text_msg[0] += "r";
                            break;
                        case "...":
                            text_msg[0] += "s";
                            break;
                        case "_":
                            text_msg[0] += "t";
                            break;
                        case ".._":
                            text_msg[0] += "u";
                            break;
                        case "..._":
                            text_msg[0] += "v";
                            break;
                        case ".__":
                            text_msg[0] += "w";
                            break;
                        case "_.._":
                            text_msg[0] += "x";
                            break;
                        case "_.__":
                            text_msg[0] += "y";
                            break;
                        case "__..":
                            text_msg[0] += "z";
                            break;
                        case "_____":
                            text_msg[0] += "0";
                            break;
                        case ".____":
                            text_msg[0] += "1";
                            break;
                        case "..___":
                            text_msg[0] += "2";
                            break;
                        case "...__":
                            text_msg[0] += "3";
                            break;
                        case "...._":
                            text_msg[0] += "4";
                            break;
                        case ".....":
                            text_msg[0] += "5";
                            break;
                        case "_....":
                            text_msg[0] += "6";
                            break;
                        case "__...":
                            text_msg[0] += "7";
                            break;
                        case "___..":
                            text_msg[0] += "8";
                            break;
                        case "____.":
                            text_msg[0] += "9";
                            break;
                        default:
                            break;
                    }
                }
                text_letter[0] = "";
                textMsg.setText(text_msg[0]);
            }
        });
    }
}