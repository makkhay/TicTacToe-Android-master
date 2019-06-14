package com.makkhay.tictactoe;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginToGameActivity extends AppCompatActivity {

    private EditText mPlayerOneET, mPlayerTwoET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_to_game);

        mPlayerOneET = (EditText) findViewById(R.id.nameplayer1);
        mPlayerTwoET = (EditText) findViewById(R.id.nameplayer2);
    }

    public void onPlay(View view) {
        if(mPlayerOneET.getText() == null || mPlayerOneET.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please type the name of Player 1", Toast.LENGTH_SHORT).show();
            return;
        }
        if(mPlayerTwoET.getText() == null || mPlayerTwoET.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please type the name of Player 2", Toast.LENGTH_SHORT).show();
            return;
        }

        // Send data from one activity to another
        Bundle bundle = new Bundle();
        bundle.putString("mPlayerOneET", mPlayerOneET.getText().toString().trim());
        bundle.putString("mPlayerTwoET", mPlayerTwoET.getText().toString().trim());
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void onExit(View view) {
        finish();
    }
}
