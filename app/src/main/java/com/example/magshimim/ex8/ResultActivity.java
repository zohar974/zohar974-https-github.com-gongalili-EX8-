package com.example.magshimim.ex8;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by magshimim on 02/02/2018.
 */

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);
        String far = getIntent().getStringExtra("far");
        String cel = getIntent().getStringExtra("cel");
        String check = getIntent().getStringExtra("check");
        String returnValue;
        TextView editText = (TextView) findViewById(R.id.answer);


        Intent i = new Intent();
        if(check.compareTo("rch") == 0)
        {
            Double Ifar = Double.parseDouble(far);
            Double Icel= Double.parseDouble (cel);

            if(Ifar == Icel*(9.0/5.0) + 32.0)
            {
                editText.setText("Bravo! the temperature " + cel + " ℃, is indeed " + far + "℉");

            }
            else
            {
                editText.setText("Oops! your answer is wrong, you may try again");
            }
        }
        else
        {
            if(cel.length() > 0)
            {
                Double Icel= Double.parseDouble(cel);
                editText.setText("the temperature " + cel + " ℃, is convert " + (Icel*(9.0/5.0) + 32.0) + "℉");
                i.putExtra("back",""+ ((Icel*(9.0/5.0) + 32.0)));
                i.putExtra("empty","far");
                setResult(RESULT_OK, i);
            }
            else
            {
                Double Ifar = Double.parseDouble(far);
                editText.setText("the temperature " + far + " ℉, is convert " + ((Ifar-32.0)*(5.0/9.0)) + "℃");
                i.putExtra("back", ""+((Ifar-32.0)*(5.0/9.0)));
                i.putExtra("empty","cel");
                setResult(RESULT_OK, i);
            }
        }

    }
    public void goBack(View view)
    {
        finish();
    }
}

