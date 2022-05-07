package com.example.gameloto29032022;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        addNumberInArray();

        // Unit test
        // Case 1 : Các giá trị không được trùng
        // Case 2 : Nếu như hết số random thì thông báo
        // Case 3 (option) : Hiển thị không bị dư dấu -
        // Case 4 : Button reset sẽ xóa lịch sử , out put và thêm lại tất cả số
        mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mArrNumbers.size() > 0){
                    int index = mRandom.nextInt(mArrNumbers.size());
                    int value = mArrNumbers.get(index);
                    mTvOutput.setText(value + "");
                    if (mArrNumbers.size() == 100){
                        mTextResult += value ;
                    }else{
                        mTextResult = value + " - " + mTextResult;
                    }
                    mTvHistory.setText(mTextResult);
                    mArrNumbers.remove(index);
                }else{
                    Toast.makeText(MainActivity.this, "Kết thúc!!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mArrNumbers.size() > 0){
                    mArrNumbers.clear();
                }
                addNumberInArray();
                mTextResult = "";
                mTvOutput.setText("");
                mTvHistory.setText("");

            }
        });
    }

    private void addNumberInArray(){
        for (int i = 1; i <= 100; i++) {
            mArrNumbers.add(i);
        }

    }
}
