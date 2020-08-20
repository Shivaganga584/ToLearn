package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //0=yellow , 1 = red

    int activePlayer = 0;
    //2 means un-played
    int[] gameStart = {2,2,2,2,2,2,2,2,2};

    int[][] winningPositions = {{0,1,2} ,{3,4,5},{6,7,8} ,{0,3,6} ,{1,4,7},{2,5,8},{2,4,6},{0,4,8} };

    public void dropIn(View view){

        ImageView counter = (ImageView) view;

        System.out.println(counter.getTag().toString());
        counter.setTranslationY(-1000f);

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameStart[tappedCounter] == 2) {

            gameStart[tappedCounter] = activePlayer;

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1000f).setDuration(300);

            for(int[] winningPositions : winningPositions){

                if(gameStart[winningPositions[0]] == gameStart[winningPositions[1]] &&
                        gameStart[winningPositions[1]] == gameStart[winningPositions[2]] &&
                        gameStart[winningPositions[0]] !=2){

                    String winner ="Red";

                    if(gameStart[winningPositions[0]] == 0 ){

                        winner ="Yellow";

                    }

                    //someone has won

                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);

                    winnerMessage.setText("The winner is"+"\n"+winner+"!!");
                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);

                }

            }
        }
    }

    /*public void playAgain(View view){

        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);
        activePlayer = 0;
        //2 means un-played

        for(int i = 0;i<gameStart.length;i++){
            gameStart[i] = 2;
        }

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for(int i = 0;i<gridLayout.getChildCount();i++){

            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }

    }*/
    public void playAgain(View view){
        Button playAgainButton = findViewById(R.id.playAgainButton);
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void resetGame(){

        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);
        ImageView image = (ImageView) findViewById(R.id.imageView9);
        image.setImageResource(0);
        ImageView image1 = (ImageView) findViewById(R.id.imageView8);
        image1.setImageResource(0);
        ImageView image2 = (ImageView) findViewById(R.id.imageView7);
        image2.setImageResource(0);
        ImageView image3 = (ImageView) findViewById(R.id.imageView6);
        image3.setImageResource(0);
        ImageView image4 = (ImageView) findViewById(R.id.imageView5);
        image4.setImageResource(0);
        ImageView image5 = (ImageView) findViewById(R.id.imageView4);
        image5.setImageResource(0);
        ImageView image6 = (ImageView) findViewById(R.id.imageView3);
        image6.setImageResource(0);
        ImageView image7 = (ImageView) findViewById(R.id.imageView2);
        image7.setImageResource(0);
        ImageView image8 = (ImageView) findViewById(R.id.imageView);
        image8.setImageResource(0);

        activePlayer = 0;
        for(int i = 0;i<gameStart.length;i++){
            gameStart[i] = 2;

        }

    }


}
