package com.example.checkboxrandomsum;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tvRandom;
    Button btnNext;
    CheckBox chk1, chk2, chk3, chk4,chk5;
    Button btnSum;
    TextView tvAnswer;
    ArrayList<String> lst;
    Random r;
    int min = 0;
    int max = 100;
    int r1 = 0;
    int choice1 = 0, choice2 = 0, choice3 = 0, choice4 = 0, choice5 = 0;
    int answer = 0;
    int finalanswer = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvRandom = (TextView)findViewById(R.id.tvRandom);
        btnNext = (Button) findViewById(R.id.btnNext);

        chk1 = (CheckBox) findViewById(R.id.chk1);
        chk2 = (CheckBox) findViewById(R.id.chk2);
        chk3 = (CheckBox) findViewById(R.id.chk3);
        chk4 = (CheckBox) findViewById(R.id.chk4);
        chk5 = (CheckBox) findViewById(R.id.chk5);

        btnSum = (Button) findViewById(R.id.btnSum);
        tvAnswer = (TextView) findViewById(R.id.tvAnswer);
        lst = new ArrayList<>();
         //new Random().nextInt((100-0)+1+0);  //100+1 = 101 = upto 0 to 100
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tvRandom.setText("Random Number = "+String.valueOf(r1));
                r1 = new Random().nextInt((max - min) + 1) + min;
                tvRandom.setText("Random Number = "+r1);
            }
        });

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*for(String s : lst)
                {
                    tvAnswer.setText("list = "+tvAnswer.getText().toString()+", "+s);
                }*/

                //tvAnswer.setText("Answer = "+answer);
                finalanswer = answer + r1;
                tvAnswer.setText("Answer = "+finalanswer);
            }
        });

    }

    public void onCheckboxClicked(View view)
    {
        boolean checked = ((CheckBox)view).isChecked();
        /*switch (view.getId())
        {
            case R.id.chk1:
                lst.add(chk1.getTag().toString());
                break;
            case R.id.chk2:
                lst.add(chk2.getTag().toString());
                break;
            case R.id.chk3:
                lst.add(chk3.getTag().toString());
                break;
        }*/
        if(chk1.isChecked())
        {
            choice1 = 1;
            answer = choice1;
            lst.add(answer+"");
        }
        if(chk2.isChecked())
        {
            choice2 = 2;
            answer = choice2;
            lst.add(answer+"");
        }
        if(chk3.isChecked())
        {
            choice3 = 3;
            answer = choice3;
            lst.add(answer+"");
        }
        if(chk4.isChecked())
        {
            choice4 = 4;
            answer = choice4;
            lst.add(answer+"");
        }
        if(chk5.isChecked())
        {
            choice5 = 5;
            answer = choice5;
            lst.add(answer+"");
        }
        if(chk1.isChecked() && chk2.isChecked())
        {
            answer = 3;
            lst.add(answer+"");
        }
        if(chk2.isChecked() && chk3.isChecked())
        {
            answer = 5;
            lst.add(answer+"");
        }
        if(chk1.isChecked() && chk3.isChecked())
        {
            answer = 4;
            lst.add(answer+"");
        }
        if(chk1.isChecked() && chk4.isChecked())
        {
            answer = 5;
            lst.add(answer+"");
        }
        if(chk1.isChecked() && chk5.isChecked())
        {
            answer = 6;
            lst.add(answer+"");
        }
        if(chk2.isChecked() && chk4.isChecked())
        {
            answer = 6;
            lst.add(answer+"");
        }
        if(chk2.isChecked() && chk5.isChecked())
        {
            answer = 7;
            lst.add(answer+"");
        }
        if(chk3.isChecked() && chk4.isChecked())
        {
            answer = 7;
            lst.add(answer+"");
        }
        if(chk3.isChecked() && chk5.isChecked())
        {
            answer = 8;
            lst.add(answer+"");
        }
        if(chk1.isChecked() && chk2.isChecked() && chk3.isChecked())
        {
            answer = 6;
            lst.add(answer+"");
        }
        if(chk1.isChecked() && chk2.isChecked() && chk4.isChecked())
        {
            answer = 7;
            lst.add(answer+"");
        }
        if(chk1.isChecked() && chk2.isChecked() && chk5.isChecked())
        {
            answer = 8;
            lst.add(answer+"");
        }
        if(chk1.isChecked() && chk3.isChecked() && chk4.isChecked())
        {
            answer = 8;
            lst.add(answer+"");
        }
        if(chk1.isChecked() && chk3.isChecked() && chk5.isChecked())
        {
            answer = 9;
            lst.add(answer+"");
        }
        if(chk2.isChecked() && chk3.isChecked() && chk4.isChecked())
        {
            answer = 9;
            lst.add(answer+"");
        }
        if(chk1.isChecked() && chk2.isChecked() && chk5.isChecked())
        {
            answer = 8;
            lst.add(answer+"");
        }
        if(chk1.isChecked() && chk2.isChecked() && chk3.isChecked() && chk4.isChecked())
        {
            answer = 10;
            lst.add(answer+"");
        }
        if(chk1.isChecked() && chk2.isChecked() && chk3.isChecked() && chk5.isChecked())
        {
            answer = 11;
            lst.add(answer+"");
        }
        if(chk1.isChecked() && chk2.isChecked() && chk4.isChecked() && chk5.isChecked())
        {
            answer = 12;
            lst.add(answer+"");
        }
        if(chk2.isChecked() && chk3.isChecked() && chk4.isChecked() && chk5.isChecked())
        {
            answer = 14;
            lst.add(answer+"");
        }
        if(chk1.isChecked() && chk2.isChecked() && chk3.isChecked() && chk4.isChecked() && chk5.isChecked())
        {
            answer = 15;
            lst.add(answer+"");
        }
    }

}
