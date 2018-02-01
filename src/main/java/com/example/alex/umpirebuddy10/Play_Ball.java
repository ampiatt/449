package com.example.alex.umpirebuddy10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.support.v7.app.AlertDialog;

public class Play_Ball extends AppCompatActivity {

    private int bCount, sCount;
    private Button Strike;
    private Button Ball;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play__ball);
        bCount = 0;
        sCount = 0;

        resetDisplay(bCount, sCount);

        Strike = (Button) findViewById(R.id.strikeButton);
        Ball = (Button) findViewById(R.id.ballButton);
    }

    public void strikeClicked(View v) {
        if (sCount < 2) {
            //increment strike count
            sCount++;

            //udpate display to show new strike count
            resetDisplay(bCount, sCount);
        }
        else if (sCount == 2) {
            //create message box
            AlertDialog.Builder strikeMessage = new AlertDialog.Builder(this);
            strikeMessage.setTitle("Strike Out!");
            strikeMessage.setMessage("OUT!!");
            strikeMessage.setPositiveButton("OK", null);

            //display message box
            AlertDialog dialog = strikeMessage.create();
            dialog.show();

            //reset counters
            sCount = 0;
            bCount = 0;
            resetDisplay(bCount, sCount);
        }
    }

    public void ballClicked(View v) {
        if (bCount < 3) {
            //increment a ball
            bCount++;

            resetDisplay(bCount, sCount);
        }
        else if (bCount == 3) {
            //build walk message
            AlertDialog.Builder walkMessage = new AlertDialog.Builder(this);
            walkMessage.setTitle("Walk!!");
            walkMessage.setMessage("Batter walks!");
            walkMessage.setPositiveButton("OK", null);

            //show message box
            AlertDialog dialog = walkMessage.create();
            dialog.show();

            //reset counters
            sCount = 0;
            bCount = 0;
            resetDisplay(bCount, sCount);
        }
    }

    protected void resetDisplay(int ball, int strike) {
        String sBCount = "Ball Count: " + String.valueOf(ball) + "\nStrike Count: " + String.valueOf(strike);
        TextView display=(TextView)findViewById(R.id.textView);
        display.setText(sBCount);
    }
}
