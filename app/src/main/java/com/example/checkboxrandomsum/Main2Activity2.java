package com.example.checkboxrandomsum;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main2Activity2 extends AppCompatActivity {
    RadioGroup radioGroup;
    RecyclerView rv;
    TextView tvAnswer;
    ArrayList<Pojo> lst;
    ArrayList<String> hashSet;
    ArrayList<String> finalList2;
    ArrayList<Pojo> newlst;
    MyAdapter adapter;
    MyListener listener;
    Button btnClear;

    int sum = 0;
    int n = 1, m = 1;
    TextView tvList;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        //radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        newlst = new ArrayList();

        tvAnswer = (TextView) findViewById(R.id.tvAnswer);
        tvList = (TextView) findViewById(R.id.tvList);
        lst = new ArrayList<>();
        btnClear = (Button)findViewById(R.id.btnClear);

        int buttons = 50;

        for(int i=1;i<=buttons;i++)
        {
            lst.add(new Pojo(i));
        }

       /* listener = new MyListener() {
            @Override
            public void onClick(String position) {
                Toast.makeText(Main2Activity2.this, "Click = "+position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onClick(String position, ArrayList<String> finalList) {
                Toast.makeText(Main2Activity2.this, "Click all = "+position+", "+finalList, Toast.LENGTH_SHORT).show();
                int sum = 0;
                finalList2 = new ArrayList<>();
                hashSet = new ArrayList<>();
                hashSet.addAll(finalList);
                finalList.clear();
                finalList.addAll(hashSet);
                finalList2 = finalList;
                for (int i=0; i<finalList.size(); i++){
                    sum += Integer.parseInt(finalList.get(i));
                }
                Log.i("My zzzz finalList2 = ",finalList2+"");
                tvAnswer.setText("Answer = "+sum);
                tvList.setText(finalList2+"");
            }

            @Override
            public void onClick(String position, int sum) {
                Toast.makeText(Main2Activity2.this, "Click all2 = "+position+", "+sum, Toast.LENGTH_SHORT).show();
                tvAnswer.setText("Answer = "+sum);

            }

            @Override
            public void onClick(View v, int position) {

            }
        };*/
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //adapter = new MyAdapter(this, lst);
        if(adapter == null) {
            //adapter = new MyAdapter(this, lst, listener);
            adapter = new MyAdapter(this, lst);
            rv.setAdapter(adapter);
        }else{
            adapter.notifyDataSetChanged();
        }

        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.MyListener() {
                    @Override public void onItemClick(View view, int position) {
                        Toast.makeText(Main2Activity2.this, "position = "+(position+1), Toast.LENGTH_SHORT).show();

                        ///////////////////////////
                        Pojo p1 = lst.get(position);
                        p1.setSelected(!p1.getSelected());

                            if(!newlst.contains(p1.getSelected()))
                            {
                                newlst.add(p1);
                            }



                        Iterator<Pojo> iter = newlst.iterator();
                        while (iter.hasNext()) {
                            Pojo p11 = iter.next();
                            if (!p11.getSelected()) {
                                iter.remove();
                            }
                        }
                        int sum = 0;
                        Log.i("My newlst = ",newlst.toString()+"");
                        for (int i=0; i<newlst.size(); i++){
                            sum += newlst.get(i).getI();
                        }
                        tvAnswer.setText("Answer = "+sum);
                        tvList.setText(newlst+"");







    }
                })
        );




        /*for(int i=1; i<=buttons; i++)
        {
            RadioButton rbn = new RadioButton(this);
            rbn.setId(View.generateViewId());
            rbn.setText("RadioButton"+i);
            radioGroup.addView(rbn);
        }*/
    }
}
