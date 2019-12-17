package com.example.checkboxrandomsum;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<Pojo> lst;
    ArrayList<String> finalList;
    ArrayList<String> finalList2;
    HashSet<String> hashSet;
    MyListener listener;
    int lastSelectedPosition = -1;
    boolean rowSelectedFlag;
    RadioButton lastCheckedBtn;
    int lastCheckedPos, lastCheckedPosition;

    RadioButton lastCheckedRadio;
    int mCheckedPostion;
    int i = 1;
    int n = 1, m = 1;
    int sum = 0;
    public MyAdapter(Context context, ArrayList lst)
    {
        this.context = context;
        this.lst = lst;
    }
    public MyAdapter(Context context, ArrayList lst, MyListener listener)
    {
        this.context = context;
        this.lst = lst;
        this.listener = listener;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cv_layout, parent, false);
        MyViewHolder vvv = new MyViewHolder(v);
        //vvv.setIsRecyclable(false);
        //return new MyViewHolder(v);
        return vvv;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RadioButton r1;
        RelativeLayout layoutContainer;
        public MyViewHolder(View itemView) {
            super(itemView);
            r1 = (RadioButton)itemView.findViewById(R.id.radioButton);
            layoutContainer = (RelativeLayout)itemView.findViewById(R.id.layoutContainer);
            lastSelectedPosition = getAdapterPosition();

            //boolean checked = r1.isChecked();
            //Log.i("My getAdapterPosition ",getAdapterPosition()+"");
            finalList = new ArrayList<>();
            hashSet = new HashSet<>();
            r1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //lastSelectedPosition = getAdapterPosition();
                    //notifyDataSetChanged();
                    //Toast.makeText(MyAdapter.this.context, "checked = "+r1.getText(), Toast.LENGTH_SHORT).show();
                    //listener.onClick(r1.getText()+"");

                    /*finalList = new ArrayList<>();
                    finalList.add(r1.getText()+"");
                    listener.onClick(r1.getText()+"", finalList);

                    boolean checked = ((RadioButton)v).isChecked();
                    Log.i("My checked = ",checked+"");
                    Log.i("My getTag = ",r1.getTag().toString());
                    switch (v.getId())
                    {
                        case R.id.radioButton:
                            if(checked)
                            {
                                Log.i("My already checked",checked+"");

                                if(i==1)
                                {
                                    r1.setChecked(true);
                                    Log.i("My i1 = ",i+"");
                                    i=0;
                                }
                                else
                                {
                                    r1.setChecked(false);
                                    Log.i("My i2 = ",i+"");
                                    i=1;
                                }
                            }
                            else
                            {
                                Log.i("My not checked",checked+"");
                            }


                    }*/



                    ///////////////////////////
                    rowSelectedFlag = true;
                    finalList2 = new ArrayList<>();

                    //r1.setChecked(true);
                    int sum2 = 0;
                    int clickPos = (Integer.parseInt(r1.getTag()+""));
                    if(r1.isChecked()) //always true
                    {
                        Log.i("My cccc",r1.isChecked()+"");
                        //if(lastCheckedBtn!=null)
                        {
                            if(lastCheckedBtn==r1) //already checked => false
                            {
                                Log.i("My aaa",lastCheckedBtn+", "+r1);
                                if(n==1)  //same = first time remove
                                {
                                    Log.i("Myy removeeeeeeee = ",n+"");
                                    r1.setChecked(false);
                                    Log.i("My aaaa = ", r1.getText() + "");
                                    finalList.remove(r1.getText() + "");
                                    //finalList.remove(finalList.size()-1);
                                    sum -= Integer.parseInt(r1.getTag().toString());
                                    Log.i("My -sum = ", sum + "");
                                    n=0;
                                    //sum -= Integer.parseInt(r1.getTag().toString());
                                /*for (int i=0; i<finalList.size(); i++){
                                    sum -= Integer.parseInt(finalList.get(i));
                                }*/
                                }
                                else  //same = second time add
                                {
                                    Log.i("Myy remove+adddddddd = ",n+"");
                                    r1.setChecked(true);
                                    finalList.add(r1.getText()+"");
                                    n=1;
                                }
                            }
                            else //unchecked => true
                            {
                                        Log.i("Myy adddddddddddddd = ",n+"");
                                        Log.i("My bbb", lastCheckedBtn + ", " + r1);
                                        if(r1.isChecked()==true && n==0)
                                        {
                                            Log.i("Myy again remove",n+"");
                                            r1.setChecked(false);
                                            finalList.remove(r1.getText() + "");
                                        }
                                        else {

                                            r1.setChecked(true);
                                            Log.i("My bbbb = ", r1.getText() + "");
                                            finalList.add(r1.getText() + "");
                                            sum += Integer.parseInt(r1.getTag().toString());
                                            Log.i("My +sum = ", sum + "");
                                    /*for (int i=0; i<finalList.size(); i++){
                                        sum += Integer.parseInt(finalList.get(i));
                                    }*/
                                        }

                            }
                            /*for (int i=0; i<finalList.size(); i++){
                                Log.i("My finalList",finalList+"");
                            }*/
                            HashSet<String> set = new HashSet<>(finalList);
                            finalList.clear();
                            finalList.addAll(set);
                            Log.i("My first finalList",finalList+"");
                            notifyDataSetChanged();
                            //listener.onClick(r1.getText()+"", finalList);
                        }
                    }
                    /*else
                    {
                        Log.i("My lastCheckedBtn nulll",r1.isChecked()+"");
                        lastCheckedBtn = null;
                    }*/
                    lastCheckedBtn = r1;
                    lastCheckedPos = clickPos;
                    Log.i("My lastCheckedBtn = ",lastCheckedBtn+"");
                    Log.i("My lastCheckedPos = ",lastCheckedPos+"");
                    ///////////////////////////
                }
            });

            /*r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Toast.makeText(MyAdapter.this.context, "l = "+finalList, Toast.LENGTH_SHORT).show();
                    Log.i("My changed = ",finalList+"");
                }
            });*/

        }
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Pojo dp = lst.get(position);
        holder.r1.setText((position+1)+"");
        holder.r1.setTag((position+1)+"");
        //holder.setIsRecyclable(false);
        if(lst.get(position).getSelected()==true)
        {
            holder.r1.setChecked(true);
        }
        else
        {
            holder.r1.setChecked(false);
        }


    }

    @Override
    public int getItemCount() {
        return lst.size();
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }  //view holder is not reusable = for new item = because it different type
    // = so not bound for new items



    @Override
    public long getItemId(int position) {
        return position;
    }


}
