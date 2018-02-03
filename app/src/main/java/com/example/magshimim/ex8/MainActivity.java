package com.example.magshimim.ex8;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import javax.xml.transform.Result;

public class MainActivity extends Activity {
    EditText field1;
    EditText field2;
    Button go;
    final int CHECK = 1;
    RadioButton rCa;
    RadioButton rCh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        field1 = (EditText)findViewById(R.id.input1);
        field2 = (EditText)findViewById(R.id.input2);
        rCa = (RadioButton) findViewById(R.id.calc);
        rCh = (RadioButton) findViewById(R.id.right);
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
                if(rCa != null && rCa.isChecked() && field1.getText().toString().length() >0)
                {
                    field2.setEnabled(false);
                    go.setEnabled(true);
                }
                else if(rCa != null && rCa.isChecked() && field1.getText().toString().length() == 0)
                {
                    field2.setEnabled(true);
                    go.setEnabled(false);
                }
                else if(rCh != null && rCh.isChecked()  && field1.getText().toString().length() >0 && field2.getText().toString().length() >0)
                {
                    go.setEnabled(true);
                }
                else if(rCh != null && rCh.isChecked()  && (field1.getText().toString().length() ==0 || field2.getText().toString().length() ==0))
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
                if(rCa != null && rCa.isChecked() && field2.getText().toString().length() >0)
                {
                    field1.setEnabled(false);
                    go.setEnabled(true);
                }
                else if(rCa != null && rCa.isChecked() && field1.getText().toString().length() == 0)
                {
                    field1.setEnabled(true);
                    go.setEnabled(false);
                }
                else if(rCh != null && rCh.isChecked()  && field1.getText().toString().length() >0 && field2.getText().toString().length() >0)
                {
                    go.setEnabled(true);
                }
                else if(rCh != null && rCh.isChecked()  && (field1.getText().toString().length() ==0 || field2.getText().toString().length() ==0))
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
    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, ResultActivity.class);
        EditText editText1 = (EditText) findViewById(R.id.input1);
        EditText editText2 = (EditText) findViewById(R.id.input2);
        if(editText1.getText() != null) {
            String val1 = editText1.getText().toString();
            intent.putExtra("far", val1);
        }
        else
        {
            intent.putExtra("far", "");
        }
        if(editText1.getText() != null) {
            String val2 = editText2.getText().toString();
            intent.putExtra("cel", val2);
        }
        else
        {
            intent.putExtra("cel", "");
        }




        if(rCh.isChecked())
        {
            intent.putExtra("check", "rch");
        }
        else
        {
            intent.putExtra("check", "rca");
        }
        startActivityForResult(intent, CHECK);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(!rCh.isChecked()) {
            EditText editText;
            if (data.getStringExtra("empty").compareTo("cel") == 0) {
                editText = (EditText) findViewById(R.id.input2);
            } else {
                editText = (EditText) findViewById(R.id.input1);
            }

            if (requestCode == CHECK) {
                editText.setText(data.getStringExtra("back"));
            }
        }

    }
}
