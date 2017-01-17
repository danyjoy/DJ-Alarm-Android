package com.djsoft.djalarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;

public class DJA_STOP_ALARM extends AppCompatActivity {
    private int firstVal;
    private int secondVal;
    private TextView problemText;
    private TextView errMsg;
    private EditText entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_alarm);

        //define major UI attributes
        problemText = (TextView) findViewById(R.id.mathProblem);
        errMsg = (TextView) findViewById(R.id.errorMsg);
        entry = (EditText) findViewById(R.id.answerEntry);

        //setup the UI
        errMsg.setText("Enter answer to stop alarm");
        errMsg.setTextSize(30);
        setProblem();
    }

    private void setProblem()
    {
        firstVal = (int)(Math.random() * 50);
        secondVal = (int)(Math.random() * 50);
        problemText.setText(firstVal + " + " + secondVal);
    }

    public void okButtonClick(View view)
    {
        if (Integer.parseInt(String.valueOf(entry.getText())) == (firstVal + secondVal))
        {
            System.out.println("Correct!");
            DJA_ALARM_SERVICE.alarmLoop.interrupt();

            //bring up the main activity
            startActivity(new Intent(this, DJA_MAIN.class));
            finish();
        } else {
            errMsg.setText("Incorrect answer!");
        }
    }
}
