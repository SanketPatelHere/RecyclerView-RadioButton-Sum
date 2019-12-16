package com.example.checkboxrandomsum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<Pojo> lst;
    ArrayList<String> finalList;
    MyListener listener;
    int lastSelectedPosition = -1;
    boolean rowSelectedFlag;
    RadioButton lastCheckedBtn;
    int lastCheckedPos;
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
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Pojo dp = lst.get(position);
        holder.r1.setText((position+1)+"");
        holder.r1.setTag((position+1)+"");

        //holder.r1.setChecked(lastSelectedPosition == position); //true
        //holder.r1.setChecked(true);
        holder.r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rowSelectedFlag = true;
                holder.r1.setChecked(true);
                listener.onClick(position+"");
                int clickPos = (Integer.parseInt(holder.r1.getTag()+"")) ;
                if(holder.r1.isChecked())
                {
                    //holder.r1.setChecked(false);
                    if(lastCheckedBtn!=null)
                    {

                        if(lastCheckedBtn==holder.r1)
                        {

                            //notifyItemRangeChanged(0, lst.size());

                        }
                        else
                        {
                            //holder.r1.setChecked(false);

                            lastCheckedBtn.setChecked(false);
                            //notifyItemRangeChanged(0, lst.size());

                        }
                    }
                }
                else
                {
                    lastCheckedBtn = null;
                }
                lastCheckedBtn = holder.r1;
                lastCheckedPos = clickPos;
                Toast.makeText(MyAdapter.this.context, "Selected = "+clickPos, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lst.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RadioButton r1;
        public MyViewHolder(View itemView) {
            super(itemView);
            r1 = (RadioButton)itemView.findViewById(R.id.radioButton);
            finalList = new ArrayList<>();
           /*r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    //notifyDataSetChanged();
                    //Toast.makeText(MyAdapter.this.context, "checked = "+r1.getText(), Toast.LENGTH_SHORT).show();
                    finalList.add(r1.getText()+"");
                    //listener.onClick(r1.getText()+"");
                    listener.onClick(r1.getText()+"", finalList);
                }
            });*/
            /*r1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //lastSelectedPosition = getAdapterPosition();
                    //notifyDataSetChanged();
                    //Toast.makeText(MyAdapter.this.context, "checked = "+r1.getText(), Toast.LENGTH_SHORT).show();
                    listener.onClick(r1.getText()+"");

                }
            });*/

        }
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
