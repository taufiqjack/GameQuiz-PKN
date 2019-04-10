package com.cahyonoz.quiz_pkn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private QuestionBank mQuestionLibrary = new QuestionBank();
    private TextView scoreView;   // Untuk menampilkan skor saat ini
    private TextView questionView;  //menampilkan jawaban
    private Button btnChoice1; // jawaban 1
    private Button btnChoice2; // jawaban 2
    private Button btnChoice3; //jawaban 3
    private Button btnChoice4; //jawaban 4

    private String mAnswer;  // untuk cek jawaban benar atau tidaknya
    private int mScore = 0;  // current total score
    private int mQuestionNumber = 0; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        scoreView = (TextView)findViewById(R.id.score);
        questionView = (TextView)findViewById(R.id.question);
        btnChoice1 = (Button)findViewById(R.id.choice1);
        btnChoice2 = (Button)findViewById(R.id.choice2);
        btnChoice3 = (Button)findViewById(R.id.choice3);
        btnChoice4 = (Button)findViewById(R.id.choice4);
        updateQuestion();

        updateScore(mScore);
    }

    private void updateQuestion(){
        //
        if(mQuestionNumber<mQuestionLibrary.getLength() ){


            questionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            btnChoice1.setText(mQuestionLibrary.getChoice(mQuestionNumber, 1));
            btnChoice2.setText(mQuestionLibrary.getChoice(mQuestionNumber, 2));
            btnChoice3.setText(mQuestionLibrary.getChoice(mQuestionNumber, 3));
            btnChoice4.setText(mQuestionLibrary.getChoice(mQuestionNumber,4));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }
        else {
            Toast.makeText(MainActivity.this, "Pertanyaan telah berakhir!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, HighScore.class);
            intent.putExtra("score", mScore); // pass the current score to the second screen
            startActivity(intent);
        }
    }

    private void updateScore(int point) {
        scoreView.setText("" + mScore+"/"+mQuestionLibrary.getLength());
    }

    public void onClick(View view) {
        // logic untuk button jawaban dlm 1 method
        Button answer = (Button) view;
        // jika jawaban benar, score bertambah
        if (answer.getText() == mAnswer){
            mScore = mScore + 1;
            Toast.makeText(MainActivity.this, "Benar!", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(MainActivity.this, "Salah!", Toast.LENGTH_SHORT).show();

        updateScore(mScore);
        updateQuestion();
    }
}
