package com.example.gameloto29032022;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView mTvOutput, mTvHistory;
    Button mBtnReset, mBtnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvHistory = findViewById(R.id.textViewHistory);
        mTvOutput = findViewById(R.id.textViewOutput);
        mBtnReset = findViewById(R.id.buttonReset);
        mBtnPlay = findViewById(R.id.buttonPlay);

        // ArrayList
        ArrayList<String> arr = new ArrayList<>();

        // thêm
        arr.add("A"); // 0
        arr.add("B"); // 1
        arr.add("C"); // 2

        // xóa
        arr.remove(0);

        // cập nhật
        arr.set(0 , "d");
    }
}