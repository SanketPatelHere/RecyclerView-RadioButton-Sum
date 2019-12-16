package com.example.checkboxrandomsum;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Main2Activity2 extends AppCompatActivity {
    RadioGroup radioGroup;
    RecyclerView rv;
    TextView tvAnswer;
    ArrayList<Pojo> lst;
    MyAdapter adapter;
    MyListener listener;
    int sum = 0;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        //radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        rv = (RecyclerView) findViewById(R.id.rv);
        tvAnswer = (TextView) findViewById(R.id.tvAnswer);
        lst = new ArrayList<>();

        int buttons = 50;

        for(int i=1;i<=buttons;i++)
        {
            lst.add(new Pojo(i));
        }

        listener = new MyListener() {
            @Override
            public void onClick(String position) {
                Toast.makeText(Main2Activity2.this, "Click = "+position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onClick(String position, ArrayList<String> finalList) {
                Toast.makeText(Main2Activity2.this, "Click all = "+position+", "+finalList, Toast.LENGTH_SHORT).show();
                for (int i=0; i<finalList.size(); i++){
                    sum += Integer.parseInt(finalList.get(i));
                }
                tvAnswer.setText("Answer = "+sum);
            }

            @Override
            public void onClick(View v, int position) {

            }
        };
        //adapter = new MyAdapter(this, lst);
        adapter = new MyAdapter(this, lst, listener);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();
        rv.setAdapter(adapter);





        /*for(int i=1; i<=buttons; i++)
        {
            RadioButton rbn = new RadioButton(this);
            rbn.setId(View.generateViewId());
            rbn.setText("RadioButton"+i);
            radioGroup.addView(rbn);
        }*/
    }
}
