package com.example.magshimim.ex8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText field1;
    EditText field2;
    Button go;
    RadioButton rCa;
    RadioButton rCh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        field1 = (EditText)findViewById(R.id.input1);
        field2 = (EditText)findViewById(R.id.input2);
        rCa = (RadioButton) findViewById(R.id.calc);
        rCh = (RadioButton) findViewById(R.id.check);
        go = (Button) findViewById(R.id.bGo);
        go.setEnabled(false);
        field1.setEnabled(false);
        field2.setEnabled(false);
        field1.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(rCa.isChecked() && field1.getText().toString().length() >0)
                {
                    field2.setEnabled(false);
                    go.setEnabled(true);
                }
                else if(rCa.isChecked() && field1.getText().toString().length() == 0)
                {
                    field2.setEnabled(true);
                    go.setEnabled(false);
                }
                else if(rCh.isChecked()  && field1.getText().toString().length() >0 && field2.getText().toString().length() >0)
                {
                    go.setEnabled(true);
                }
                else if(rCh.isChecked()  && (field1.getText().toString().length() ==0 || field2.getText().toString().length() ==0))
                {
                    go.setEnabled(false);
                }
                else
                {
                    go.setEnabled(false);
                }
            }
        });

        field2.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(rCa.isChecked() && field2.getText().toString().length() >0)
                {
                    field1.setEnabled(false);
                    go.setEnabled(true);
                }
                else if(rCa.isChecked() && field1.getText().toString().length() == 0)
                {
                    field1.setEnabled(true);
                    go.setEnabled(false);
                }
                else if(rCh.isChecked()  && field1.getText().toString().length() >0 && field2.getText().toString().length() >0)
                {
                    go.setEnabled(true);
                }
                else if(rCh.isChecked()  && (field1.getText().toString().length() ==0 || field2.getText().toString().length() ==0))
                {
                    go.setEnabled(false);
                }
                else
                {
                    go.setEnabled(false);
                }
            }
        });

    }

    public void onRadioButtonClicked(View view) {
// Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        if(checked) {
            field1.setEnabled(true);
            field2.setEnabled(true);
        }
        else
        {
            field1.setEnabled(false);
            field2.setEnabled(false);
        }
    }

}
