package com.example.diceroller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button rollButton = findViewById(R.id.button);
        rollButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                rollDice();
            }
        });
        // Do a dice roll when the app starts
        rollDice();
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private void rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        Dice dice = new Dice(6);
        int diceRoll = dice.roll();

        // Create new Dice object with 6 sides and roll the dice
        ImageView diceImage = findViewById(R.id.imageView);

        // Determine which drawable resource ID to use based on the dice roll
        int drawableResource;
        switch (diceRoll) {
            case 1:
                drawableResource = R.drawable.dice_1;
                break;
            case 2:
                drawableResource = R.drawable.dice_2;
                break;
            case 3:
                drawableResource = R.drawable.dice_3;
                break;
            case 4:
                drawableResource = R.drawable.dice_4;
                break;
            case 5:
                drawableResource = R.drawable.dice_5;
                break;
            default:
                drawableResource = R.drawable.dice_5;
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource);

        // Update the content description
        diceImage.setContentDescription(String.valueOf(diceRoll));
    }
}

class Dice {
    int numSides;

    public Dice(int numSides) {
        this.numSides = numSides;
    }

    public int roll() {
        Random random = new Random();
        int res = random.nextInt(numSides);
        return res + 1;

    }
}


