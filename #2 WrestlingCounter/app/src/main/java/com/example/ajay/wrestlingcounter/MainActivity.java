package com.example.ajay.wrestlingcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ajay.wrestlingcounter.R;

public class MainActivity extends AppCompatActivity {

    int player1_score = 0;
    int player2_score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Display 2 points for Player 1
     */
    public void takedown_clicked_for_p1(View view)
    {
        player1_score = player1_score + 2;
        displayForPlayer1(player1_score);
    }
    /**
     * Display 1 points for Player 1
     */
    public void escape_clicked_for_p1(View view){
        player1_score = player1_score + 1;
        displayForPlayer1(player1_score);
    }

    /**
     * Display 2 points for Player 1
     */
    public void reversal_clicked_for_p1(View view){
        player1_score = player1_score + 2;
        displayForPlayer1(player1_score);
    }


    /**
     * Display 1 points for Player 1
     */
    public void penalty_clicked_for_p1(View view){
        player1_score = player1_score + 1;
        displayForPlayer1(player1_score);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForPlayer1(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_1_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Display 2 points for Player 2
     */
    public void takedown_clicked_for_p2(View view){
        player2_score = player2_score + 2;
        displayForPlayer2(player2_score);
    }

    /**
     * Display 1 points for Player 2
     */
    public void escape_clicked_for_p2(View view){
        player2_score = player2_score + 1;
        displayForPlayer2(player2_score);
    }

    /**
     * Display 2 points for Player 2
     */
    public void reversal_clicked_for_p2(View view){
        player2_score = player2_score + 2;
        displayForPlayer2(player2_score);
    }


    /**
     * Display 1 points for Player 2
     */
    public void penalty_clicked_for_p2(View view){
        player2_score = player2_score + 1;
        displayForPlayer2(player2_score);
    }
    /**
     * Displays the given score for Player 2.
     */
    public void displayForPlayer2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_2_score);
        scoreView.setText(String.valueOf(score));
    }

    public void reset_Clicked(View view){
        player1_score = 0;
        player2_score = 0;
        displayForPlayer1(player1_score);
        displayForPlayer2(player2_score);
    }
}
