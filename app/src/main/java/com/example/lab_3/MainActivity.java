package com.example.lab_3;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private TextView teamScoreRoyalTextView;
    private TextView teamScoreKingTextView;

    private int incrementBy;
    private int teamRoyalScore;
    private int teamKingScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamRoyalScore = 0;
        teamKingScore = 0;

        //finding all the views by ids, refer to the xml page for the ids,
        //the names are self explanatory
        RadioGroup radioGroup = findViewById(R.id.radio_group);

        teamScoreRoyalTextView = findViewById(R.id.team_score_Royal);
        teamScoreKingTextView = findViewById(R.id.team_score_King);

        teamScoreKingTextView.setText(Integer.toString(teamKingScore));
        teamScoreRoyalTextView.setText(Integer.toString(teamRoyalScore));

        Button upButtonRed = findViewById(R.id.buttonUp_Royal);
        Button downButtonRed = findViewById(R.id.buttonDown_Royal);
        Button upButtonBlue = findViewById(R.id.buttonUp_King);
        Button downButtonBlue = findViewById(R.id.buttonDown_King);

        //setting onClickListeners for these vie
        radioGroup.setOnCheckedChangeListener(this);
        upButtonRed.setOnClickListener(this);
        downButtonRed.setOnClickListener(this);
        upButtonBlue.setOnClickListener(this);
        downButtonBlue.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        switch (i){
            case 1:
                incrementBy = 1;
                break;
            case 2:
                incrementBy = 2;
                break;
            case 3:
                incrementBy = 3;
                break;
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        //according to the buttons clicked the respective functions are performed
        switch (id){
            case R.id.buttonUp_King:
                teamKingScore += incrementBy;
                teamScoreKingTextView.setText(Integer.toString(teamKingScore));
                break;
            case R.id.buttonDown_King:
                teamKingScore -= incrementBy;
                teamScoreKingTextView.setText(Integer.toString(teamKingScore));
                break;
            case R.id.buttonUp_Royal:
                teamRoyalScore += incrementBy;
                teamScoreRoyalTextView.setText(Integer.toString(teamRoyalScore));
                break;
            case R.id.buttonDown_Royal:
                teamRoyalScore -= incrementBy;
                teamScoreRoyalTextView.setText(Integer.toString(teamRoyalScore));
                break;
        }
    }
}