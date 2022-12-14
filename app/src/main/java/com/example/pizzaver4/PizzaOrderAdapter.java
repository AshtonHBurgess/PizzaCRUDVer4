package com.example.pizzaver4;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PizzaOrderAdapter extends RecyclerView.Adapter<PizzaOrderAdapter.MyViewHolder> {


    Activity activity;
    //add animation objects here
    Animation translate_anim;

   private Context context;
    private ArrayList order_id, order_date,
            order_cname,order_phone,
            order_address, order_pname,
            order_sizenum,order_top1num,
            order_top2num,order_top3num,
            order_top4num,
            order_top5num,order_top6num;

//int position;
    //constructor
    //MainActivity.this,order_id,order_date,order_cname,
    // order_phone,order_address, order_pname,order_sizenum,
    // order_top1num, order_top2num, order_top3num
PizzaOrderAdapter(Activity activity,Context context, ArrayList order_id,ArrayList order_date,ArrayList order_cname,
                  ArrayList order_phone,ArrayList order_address, ArrayList order_pname,
                  ArrayList order_sizenum,ArrayList order_top1num,ArrayList order_top2num,
                  ArrayList order_top3num, ArrayList order_top4num,ArrayList order_top5num,
                  ArrayList order_top6num){
//making them accessible to the whole class
    this.context = context;
this.activity=activity;
    this.context = context;
    this.order_id = order_id;
    this.order_date = order_date;
    this.order_cname = order_cname;
    this.order_phone = order_phone;
    this.order_address = order_address;
    this.order_pname = order_pname;
    this.order_sizenum = order_sizenum;
    this.order_top1num = order_top1num;
    this.order_top2num = order_top2num;
    this.order_top3num = order_top3num;
    this.order_top4num = order_top4num;
    this.order_top5num = order_top5num;
    this.order_top6num = order_top6num;



}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from((context));
        View view = inflater.inflate(R.layout.pizza_row,parent,false);//store in view object
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
//    this.position=position;

    holder.order_id_text.setText(String.valueOf(order_id.get(position)));
        holder.order_cname_text.setText(String.valueOf(order_cname.get(position)));
        holder.order_pname_text.setText(String.valueOf(order_pname.get(position)));
        holder.order_phone_text.setText(String.valueOf(order_phone.get(position)));
        String sizest = String.valueOf(order_sizenum.get(position));
        String sizeChar="";
        if(sizest.equals("1")) {sizeChar="S";}
        else if(sizest.equals("2")){sizeChar="M";}
        else if(sizest.equals("3")){sizeChar="L";}
        else if(sizest.equals("4")){sizeChar="XL";}
        holder.order_size_text.setText(sizeChar);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //navigating from main activity to update onclick
Intent intent = new Intent(context, updatePizza.class);
intent.putExtra("id",String.valueOf(order_id.get(position)));
                intent.putExtra("id",String.valueOf(order_id.get(position)));
                intent.putExtra("date",String.valueOf(order_date.get(position)));
                intent.putExtra("cname",String.valueOf(order_cname.get(position)));
                intent.putExtra("phone",String.valueOf(order_phone.get(position)));
                intent.putExtra("address",String.valueOf(order_address.get(position)));
                intent.putExtra("pname",String.valueOf(order_pname.get(position)));
                intent.putExtra("size",String.valueOf(order_sizenum.get(position)));
                intent.putExtra("top1",String.valueOf(order_top1num.get(position)));
                intent.putExtra("top2",String.valueOf(order_top2num.get(position)));
                intent.putExtra("top3",String.valueOf(order_top3num.get(position)));

                intent.putExtra("top4",String.valueOf(order_top4num.get(position)));
                intent.putExtra("top5",String.valueOf(order_top5num.get(position)));
                intent.putExtra("top6",String.valueOf(order_top6num.get(position)));
//context.startActivity(intent);
                activity.startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public int getItemCount() {
    return order_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


    TextView order_id_text, order_cname_text, order_pname_text, order_size_text,order_phone_text;
    LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            order_id_text=itemView.findViewById(R.id.order_id_text);
            order_cname_text=itemView.findViewById(R.id.order_cname_text);
            order_pname_text=itemView.findViewById(R.id.order_pname_text);
            order_size_text=itemView.findViewById(R.id.order_size_text);
            mainLayout= itemView.findViewById(R.id.mainLayout);
            order_phone_text=itemView.findViewById(R.id.order_phone);
            //set animation for pizza recyclerView
            translate_anim = AnimationUtils.loadAnimation(context,R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);

        }
    }
}
