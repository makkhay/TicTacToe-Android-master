package com.makkhay.tictactoe;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtPlayer1, txtPlayer2, txtScore;

    private TextView txtPlayer;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    private static String namePlayer1, namePlayer2;
    private int[] tablePlayer = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int scorePlayer1 = 0,
            scorePlayer2 = 0;

    // Active Player, true means player one and false means player 2
    private boolean isActivePlayer = true;

    private final static String COLOR_PLAYER_1 = "#2196f3";
    private final static String COLOR_PLAYER_2 = "#f50057";

    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundleData = getIntent().getExtras();
        namePlayer1 = bundleData.getString("namePlayer1");
        namePlayer2 = bundleData.getString("namePlayer2");

        initViews();
        addListenerToButton();
    }

    public void initViews() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        txtScore = (TextView) findViewById(R.id.txtScore);
        txtPlayer1 = (TextView) findViewById(R.id.txtPlayer1);
        txtPlayer2 = (TextView) findViewById(R.id.txtPlayer2);
        txtPlayer = (TextView) findViewById(R.id.txtPlayer);

        txtPlayer.setText(namePlayer1);
        txtPlayer1.setText(namePlayer1);
        txtPlayer2.setText(namePlayer2);
    }

    public void addListenerToButton() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1: {
                if(tablePlayer[0] != 0) {
                    return;
                }
                tablePlayer[0]= isActivePlayer ? 1 : 2;
//                if(isActivePlayer){
//                    tablePlayer[0] = 1;
//                }else {
//                    tablePlayer[0] = 2;
//                }

            } break;
            case R.id.btn2: {
                if(tablePlayer[1] != 0) {
                    return;
                }
                tablePlayer[1]= isActivePlayer ? 1 : 2;
            } break;
            case R.id.btn3: {
                if(tablePlayer[2] != 0) {
                    return;
                }
                tablePlayer[2]= isActivePlayer ? 1 : 2;
            } break;
            case R.id.btn4: {
                if(tablePlayer[3] != 0) {
                    return;
                }
                tablePlayer[3]= isActivePlayer ? 1 : 2;
            } break;
            case R.id.btn5: {
                if(tablePlayer[4] != 0) {
                    return;
                }
                tablePlayer[4]= isActivePlayer ? 1 : 2;
            } break;
            case R.id.btn6: {
                if(tablePlayer[5] != 0) {
                    return;
                }
                tablePlayer[5]= isActivePlayer ? 1 : 2;
            } break;
            case R.id.btn7: {
                if(tablePlayer[6] != 0) {
                    return;
                }
                tablePlayer[6]= isActivePlayer ? 1 : 2;
            } break;
            case R.id.btn8: {
                if(tablePlayer[7] != 0) {
                    return;
                }
                tablePlayer[7]= isActivePlayer ? 1 : 2;
            } break;
            case R.id.btn9: {
                if(tablePlayer[8] != 0) {
                    return;
                }
                tablePlayer[8]= isActivePlayer ? 1 : 2;
            } break;
        }
        changeText((Button) v);
        checkWinner();
    }

    private void changeText(Button selectedBtn) {

        if(isActivePlayer) {
            selectedBtn.setText("X");
            selectedBtn.setBackgroundColor(Color.parseColor(COLOR_PLAYER_1));
            txtPlayer.setText(namePlayer2);
            txtPlayer.setTextColor(Color.parseColor(COLOR_PLAYER_2));
        } else {
            selectedBtn.setText("O");
            selectedBtn.setBackgroundColor(Color.parseColor(COLOR_PLAYER_2));
            txtPlayer.setText(namePlayer1);
            txtPlayer.setTextColor(Color.parseColor(COLOR_PLAYER_1));
        }

        // will alternate with true and false
        isActivePlayer = !isActivePlayer;

    }

    private void checkWinner() {
        /**
         * Player 1 will display x, which is also denoted by true, we are assigning a value of 1 if a grid is pressed or selected
         * Player 2 will display O, which is also denoted by false, we are assigning a value of 2 if a grid is selected
         *
         *
         * The first line of algorithm down below is;  we are comparing the  value of 1st and 2nd grid, and 2nd and 4rd grid.
         * If both cases are true then the winner is declared.
         */
        // winning possibilities are 0,1,2 ; 3,4,5; 6,7,8; 0,3,6; 1, 4, 7;  2,5,8; 0, 4, 8; 2,4,6
        if(((tablePlayer[0] == tablePlayer[1]) && (tablePlayer[1] == tablePlayer[2])) && (tablePlayer[2] != 0) ||
            (tablePlayer[3] == tablePlayer[4]) && (tablePlayer[4] == tablePlayer[5]) && (tablePlayer[5] != 0) ||
            (tablePlayer[6] == tablePlayer[7] && (tablePlayer[7] == tablePlayer[8])) && (tablePlayer[8] != 0) ||
            (tablePlayer[0] == tablePlayer[3] && (tablePlayer[3] == tablePlayer[6])) && (tablePlayer[6] != 0) ||
            (tablePlayer[1] == tablePlayer[4] && (tablePlayer[4] == tablePlayer[7])) && (tablePlayer[7] != 0) ||
            (tablePlayer[2] == tablePlayer[5] && (tablePlayer[5] == tablePlayer[8])) && (tablePlayer[8] != 0) ||
            (tablePlayer[0] == tablePlayer[4] && (tablePlayer[4] == tablePlayer[8])) && (tablePlayer[8] != 0) ||
            (tablePlayer[2] == tablePlayer[4] && (tablePlayer[4] == tablePlayer[6]) && (tablePlayer[6] != 0))
                ) {

            if(!isActivePlayer)
                scorePlayer1++;
            else
                scorePlayer2++;
            txtScore.setText(scorePlayer1 + " - " + scorePlayer2);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("The Winner is : " + (!isActivePlayer ? namePlayer1 : namePlayer2) + "!")
            .setMessage("Do you want to play again ?")
            .setCancelable(false)
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    clear();
                }
            })
            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 500 milliseconds
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(500,VibrationEffect.DEFAULT_AMPLITUDE));
            }else{
                //deprecated in API 26
                v.vibrate(500);
            }

            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }

        // if all  buttons are pressed and a winner is not detected then draw.
        for(int item : tablePlayer) {
            if(item == 0)
                return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Draw")
                .setMessage("do you want to play again ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        clear();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onClear(View view) {
        clear();
    }

    public void onReset(View view) {
        clear();
        txtScore.setText("0 - 0");
        scorePlayer1 = 0;
        scorePlayer2 = 0;
    }

    public void onBack(View view) {
        Intent intent = new Intent(this, LoginToGameActivity.class);
        startActivity(intent);
    }

    public void clear() {
        btn1.setText(null);
        btn2.setText(null);
        btn3.setText(null);
        btn4.setText(null);
        btn5.setText(null);
        btn6.setText(null);
        btn7.setText(null);
        btn8.setText(null);
        btn9.setText(null);

        btn1.setBackgroundColor(Color.parseColor("#ffffff"));
        btn2.setBackgroundColor(Color.parseColor("#ffffff"));
        btn3.setBackgroundColor(Color.parseColor("#ffffff"));
        btn4.setBackgroundColor(Color.parseColor("#ffffff"));
        btn5.setBackgroundColor(Color.parseColor("#ffffff"));
        btn6.setBackgroundColor(Color.parseColor("#ffffff"));
        btn7.setBackgroundColor(Color.parseColor("#ffffff"));
        btn8.setBackgroundColor(Color.parseColor("#ffffff"));
        btn9.setBackgroundColor(Color.parseColor("#ffffff"));

        for(int i = 0; i < tablePlayer.length; i++)
            tablePlayer[i] = 0;
        txtPlayer.setText(namePlayer1);
        txtPlayer.setTextColor(Color.parseColor(COLOR_PLAYER_1));

        isActivePlayer = true;
    }

}
