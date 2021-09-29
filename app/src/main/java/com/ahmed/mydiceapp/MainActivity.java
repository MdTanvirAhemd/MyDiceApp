package com.ahmed.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView diceImage1 = findViewById(R.id.imgDice1);
        ImageView diceImage2 = findViewById(R.id.imgDice2);

        int [] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};


        Button btnRoll = findViewById(R.id.btnRollTheDice);
        MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);
        btnRoll.setOnClickListener(v -> {
            Random rndObject = new Random();

            int myRandomNumber = rndObject.nextInt(6);

             diceImage1.setImageResource(diceImages[myRandomNumber]);

            myRandomNumber = rndObject.nextInt(6);
            diceImage2.setImageResource(diceImages[myRandomNumber]);

            YoYo.with(Techniques.Shake)
                    .duration(700)
                    .repeat(0)
                    .playOn(diceImage1);
            YoYo.with(Techniques.Shake)
                    .duration(700)
                    .repeat(0)
                    .playOn(diceImage2);

            mp.start();

        });

    }
}