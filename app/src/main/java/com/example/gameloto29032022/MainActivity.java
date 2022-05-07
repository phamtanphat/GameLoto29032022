package com.example.gameloto29032022;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mTvOutput, mTvHistory;
    Button mBtnReset, mBtnPlay;
    ArrayList<Integer> mArrNumbers;
    Random mRandom;
    String mTextResult = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvHistory = findViewById(R.id.textViewHistory);
        mTvOutput = findViewById(R.id.textViewOutput);
        mBtnReset = findViewById(R.id.buttonReset);
        mBtnPlay = findViewById(R.id.buttonPlay);

        //Khai báo
        mArrNumbers = new ArrayList<>();
        mRandom = new Random();

        //Thêm số vào mảng
        for (int i = 1; i <= 100; i++) {
            mArrNumbers.add(i);
        }

        mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = mRandom.nextInt(mArrNumbers.size());
                int value = mArrNumbers.get(index);
                mTvOutput.setText(value + "");
                mTextResult = value + " - " + mTextResult;
                mTvHistory.setText(mTextResult);
            }
        });

    }
}
