package com.example.pizzaver4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.regex.*;

public class AddPizza extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_LANG = "key_lang";


    EditText cname;
    EditText phone;
    EditText address;
    EditText pname;
    TextView size;
    TextView sizenum;
    Button sizeup;
    TextView sizedown;
    TextView top1;
    TextView top1num;
    Button top1up;
    Button top1down;
    TextView top2;
    TextView top2num;
    Button top2up;
    Button top2down;
    TextView top3;
    TextView top3num;
    Button top3up;
    Button top3down;

    TextView top4;
    TextView top4num;
    Button top4up;
    Button top4down;
    TextView top5;
    TextView top5num;
    Button top5up;
    Button top5down;
    TextView top6;
    TextView top6num;
    Button top6up;
    Button top6down;
    TextView topMax;
    Button addbutton;

    int max=3,min=0,  sizemin=1,sizemax=4;
    int topCount = 0,sizeCount=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pizza);

        cname = findViewById(R.id.cname);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        pname = findViewById(R.id.pname);

        size = findViewById(R.id.size2);
        sizenum = findViewById(R.id.sizenum);
        sizeup = findViewById(R.id.sizeup);
        sizedown = findViewById(R.id.sizedown);

        top1 = findViewById(R.id.top1);
        top1num = findViewById(R.id.top1num);
        top1up = findViewById(R.id.top1up);
        top1down = findViewById(R.id.top1down);
        top2 = findViewById(R.id.top2);
        top2num = findViewById(R.id.top2num);
        top2up = findViewById(R.id.top2up);
        top2down = findViewById(R.id.top2down);
        top3 = findViewById(R.id.top3);
        top3num = findViewById(R.id.top3num);
        top3up = findViewById(R.id.top3up);
        top3down = findViewById(R.id.top3down);

        top4 = findViewById(R.id.top4);
        top4num = findViewById(R.id.top4num);
        top4up = findViewById(R.id.top4up);
        top4down = findViewById(R.id.top4down);
        top5 = findViewById(R.id.top5);
        top5num = findViewById(R.id.top5num);
        top5up = findViewById(R.id.top5up);
        top5down = findViewById(R.id.top5down);
        top6 = findViewById(R.id.top6);
        top6num = findViewById(R.id.top6num);
        top6up = findViewById(R.id.top6up);
        top6down = findViewById(R.id.top6down);


        addbutton = findViewById(R.id.addbutton);
        topMax = findViewById(R.id.topMax);

        //change language  En Fr
        String[] english_list = getResources().getStringArray(R.array.english_list);
        String[] french_list = getResources().getStringArray(R.array.french_list);
        String topMaxtxt="Toppings (Max 3):",addtxt="ADD", updatetxt="UPDATE", deletetxt="DELETE",nopizzatxt="No Pizza\\'s",sizetxt="Size: S(1) M(2)  L(3) XL(4)",top1txt="Extra Cheese:",top2txt="Pepperoni:",top3txt="Bacon:",top4txt="Pineapple:",top5txt="Sausage:",top6txt="Olives:",cnametxt="Customer Name...",phonetxt="Phone Number...",addresstxt="Adress...",pnametxt="Pizza Name...";
        sharedPreferences =getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        String key_lang = sharedPreferences.getString(KEY_LANG,null);
        if(key_lang != null){
            if(key_lang.equals("en")){

                addtxt=english_list[0];
                updatetxt =english_list[1];
                deletetxt =english_list[2];
                nopizzatxt=english_list[3];
                sizetxt=english_list[4];
                top1txt=english_list[5];
                top2txt=english_list[6];
                top3txt=english_list[7];
                cnametxt=english_list[8];
                phonetxt=english_list[9];
                addresstxt=english_list[10];
                pnametxt=english_list[11];
                top4txt=english_list[12];
                top5txt=english_list[13];
                top6txt=english_list[14];
                topMaxtxt=english_list[15];
            }
            else if(key_lang.equals("fr")){
                addtxt=french_list[0];
                updatetxt =french_list[1];
                deletetxt =french_list[2];
                nopizzatxt=french_list[3];
                sizetxt=french_list[4];
                top1txt=french_list[5];
                top2txt=french_list[6];
                top3txt=french_list[7];
                cnametxt=french_list[8];
                phonetxt=french_list[9];
                addresstxt=french_list[10];
                pnametxt=french_list[11];
                top4txt=french_list[12];
                top5txt=french_list[13];
                top6txt=french_list[14];
                topMaxtxt=french_list[15];
            }
        }
        cname.setHint(cnametxt);
        phone.setHint(phonetxt);
        address.setHint(addresstxt);
        pname.setHint(pnametxt);
        size.setText(sizetxt);
        top1.setText(top1txt);
        top2.setText(top2txt);
        top3.setText(top3txt);

        top4.setText(top4txt);
        top5.setText(top5txt);
        top6.setText(top6txt);
        addbutton.setText(addtxt);

        topMax.setText(topMaxtxt);




sizeup.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String newSize = sizenum.getText().toString();
        sizeCount = Integer.parseInt(newSize);
        if(sizeCount>=sizemin && sizeCount< sizemax){
            sizeCount++;
             newSize = String.valueOf(sizeCount);
            sizenum.setText(newSize);
        }

    }
});

        sizedown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newSize = sizenum.getText().toString();
                sizeCount = Integer.parseInt(newSize);
                if(sizeCount>sizemin && sizeCount<= sizemax){
                    sizeCount--;
                    newSize = String.valueOf(sizeCount);
                    sizenum.setText(newSize);
                }

            }
        });




        top1up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num.getText().toString();
                String st2 = top2num.getText().toString();
                String st3 = top3num.getText().toString();
                String st4 = top4num.getText().toString();
                String st5 = top5num.getText().toString();
                String st6 = top6num.getText().toString();
                int tp1 ,tp2,tp3,tp4 ,tp5,tp6;
                tp1=Integer.parseInt(st1);
                tp2=Integer.parseInt(st2);
                tp3=Integer.parseInt(st3);
                tp4=Integer.parseInt(st4);
                tp5=Integer.parseInt(st5);
                tp6=Integer.parseInt(st6);
                topCount = tp1+tp2+ tp3+tp4+tp5+tp6;
                if(topCount< max && tp1 <max ){
                    String  newTop = String.valueOf(tp1+1);
                    top1num.setText(newTop);
                }

            }
        });

        top1down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num.getText().toString();
                String st2 = top2num.getText().toString();
                String st3 = top3num.getText().toString();
                String st4 = top4num.getText().toString();
                String st5 = top5num.getText().toString();
                String st6 = top6num.getText().toString();
                int tp1 ,tp2,tp3,tp4 ,tp5,tp6;
                tp1=Integer.parseInt(st1);
                tp2=Integer.parseInt(st2);
                tp3=Integer.parseInt(st3);
                tp4=Integer.parseInt(st4);
                tp5=Integer.parseInt(st5);
                tp6=Integer.parseInt(st6);
                topCount = tp1+tp2+ tp3+tp4+tp5+tp6;
                if(topCount> min  && tp1 >min){
                    String  newTop = String.valueOf(tp1-1);
                    top1num.setText(newTop);
                }

            }
        });

        top2up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num.getText().toString();
                String st2 = top2num.getText().toString();
                String st3 = top3num.getText().toString();
                String st4 = top4num.getText().toString();
                String st5 = top5num.getText().toString();
                String st6 = top6num.getText().toString();
                int tp1 ,tp2,tp3,tp4 ,tp5,tp6;
                tp1=Integer.parseInt(st1);
                tp2=Integer.parseInt(st2);
                tp3=Integer.parseInt(st3);
                tp4=Integer.parseInt(st4);
                tp5=Integer.parseInt(st5);
                tp6=Integer.parseInt(st6);
                topCount = tp1+tp2+ tp3+tp4+tp5+tp6;
                if(topCount< max  && tp2 <max){
                    String  newTop = String.valueOf(tp2+1);
                    top2num.setText(newTop);
                }


            }
        });

        top2down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num.getText().toString();
                String st2 = top2num.getText().toString();
                String st3 = top3num.getText().toString();
                String st4 = top4num.getText().toString();
                String st5 = top5num.getText().toString();
                String st6 = top6num.getText().toString();
                int tp1 ,tp2,tp3,tp4 ,tp5,tp6;
                tp1=Integer.parseInt(st1);
                tp2=Integer.parseInt(st2);
                tp3=Integer.parseInt(st3);
                tp4=Integer.parseInt(st4);
                tp5=Integer.parseInt(st5);
                tp6=Integer.parseInt(st6);
                topCount = tp1+tp2+ tp3+tp4+tp5+tp6;
                if(topCount> min  && tp2 >min){
                    String  newTop = String.valueOf(tp2-1);
                    top2num.setText(newTop);
                }

            }
        });

        top3up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num.getText().toString();
                String st2 = top2num.getText().toString();
                String st3 = top3num.getText().toString();
                String st4 = top4num.getText().toString();
                String st5 = top5num.getText().toString();
                String st6 = top6num.getText().toString();
                int tp1 ,tp2,tp3,tp4 ,tp5,tp6;
                tp1=Integer.parseInt(st1);
                tp2=Integer.parseInt(st2);
                tp3=Integer.parseInt(st3);
                tp4=Integer.parseInt(st4);
                tp5=Integer.parseInt(st5);
                tp6=Integer.parseInt(st6);
                topCount = tp1+tp2+ tp3+tp4+tp5+tp6;
                if(topCount< max && tp3 <max ){
                    String  newTop = String.valueOf(tp3+1);
                    top3num.setText(newTop);
                }

            }
        });

        top3down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num.getText().toString();
                String st2 = top2num.getText().toString();
                String st3 = top3num.getText().toString();
                String st4 = top4num.getText().toString();
                String st5 = top5num.getText().toString();
                String st6 = top6num.getText().toString();
                int tp1 ,tp2,tp3,tp4 ,tp5,tp6;
                tp1=Integer.parseInt(st1);
                tp2=Integer.parseInt(st2);
                tp3=Integer.parseInt(st3);
                tp4=Integer.parseInt(st4);
                tp5=Integer.parseInt(st5);
                tp6=Integer.parseInt(st6);
                topCount = tp1+tp2+ tp3+tp4+tp5+tp6;
                if(topCount> min  && tp3 >min ){
                    String  newTop = String.valueOf(tp3-1);
                    top3num.setText(newTop);
                }

            }
        });

















        top4up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num.getText().toString();
                String st2 = top2num.getText().toString();
                String st3 = top3num.getText().toString();
                String st4 = top4num.getText().toString();
                String st5 = top5num.getText().toString();
                String st6 = top6num.getText().toString();
                int tp1 ,tp2,tp3,tp4 ,tp5,tp6;
                tp1=Integer.parseInt(st1);
                tp2=Integer.parseInt(st2);
                tp3=Integer.parseInt(st3);
                tp4=Integer.parseInt(st4);
                tp5=Integer.parseInt(st5);
                tp6=Integer.parseInt(st6);
                topCount = tp1+tp2+ tp3+tp4+tp5+tp6;
                if(topCount< max && tp4 <max ){
                    String  newTop = String.valueOf(tp4+1);
                    top4num.setText(newTop);
                }

            }
        });

        top4down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num.getText().toString();
                String st2 = top2num.getText().toString();
                String st3 = top3num.getText().toString();
                String st4 = top4num.getText().toString();
                String st5 = top5num.getText().toString();
                String st6 = top6num.getText().toString();
                int tp1 ,tp2,tp3,tp4 ,tp5,tp6;
                tp1=Integer.parseInt(st1);
                tp2=Integer.parseInt(st2);
                tp3=Integer.parseInt(st3);
                tp4=Integer.parseInt(st4);
                tp5=Integer.parseInt(st5);
                tp6=Integer.parseInt(st6);
                topCount = tp1+tp2+ tp3+tp4+tp5+tp6;
                if(topCount> min  && tp4 >min){
                    String  newTop = String.valueOf(tp4-1);
                    top4num.setText(newTop);
                }

            }
        });

        top5up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num.getText().toString();
                String st2 = top2num.getText().toString();
                String st3 = top3num.getText().toString();
                String st4 = top4num.getText().toString();
                String st5 = top5num.getText().toString();
                String st6 = top6num.getText().toString();
                int tp1 ,tp2,tp3,tp4 ,tp5,tp6;
                tp1=Integer.parseInt(st1);
                tp2=Integer.parseInt(st2);
                tp3=Integer.parseInt(st3);
                tp4=Integer.parseInt(st4);
                tp5=Integer.parseInt(st5);
                tp6=Integer.parseInt(st6);
                topCount = tp1+tp2+ tp3+tp4+tp5+tp6;
                if(topCount< max  && tp5 <max){
                    String  newTop = String.valueOf(tp5+1);
                    top5num.setText(newTop);
                }

            }
        });

        top5down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num.getText().toString();
                String st2 = top2num.getText().toString();
                String st3 = top3num.getText().toString();
                String st4 = top4num.getText().toString();
                String st5 = top5num.getText().toString();
                String st6 = top6num.getText().toString();
                int tp1 ,tp2,tp3,tp4 ,tp5,tp6;
                tp1=Integer.parseInt(st1);
                tp2=Integer.parseInt(st2);
                tp3=Integer.parseInt(st3);
                tp4=Integer.parseInt(st4);
                tp5=Integer.parseInt(st5);
                tp6=Integer.parseInt(st6);
                topCount = tp1+tp2+ tp3+tp4+tp5+tp6;
                if(topCount> min  && tp5 >min){
                    String  newTop = String.valueOf(tp5-1);
                    top5num.setText(newTop);
                }

            }
        });

        top6up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num.getText().toString();
                String st2 = top2num.getText().toString();
                String st3 = top3num.getText().toString();
                String st4 = top4num.getText().toString();
                String st5 = top5num.getText().toString();
                String st6 = top6num.getText().toString();
                int tp1 ,tp2,tp3,tp4 ,tp5,tp6;
                tp1=Integer.parseInt(st1);
                tp2=Integer.parseInt(st2);
                tp3=Integer.parseInt(st3);
                tp4=Integer.parseInt(st4);
                tp5=Integer.parseInt(st5);
                tp6=Integer.parseInt(st6);
                topCount = tp1+tp2+ tp3+tp4+tp5+tp6;
                if(topCount< max && tp6 <max ){
                    String  newTop = String.valueOf(tp6+1);
                    top6num.setText(newTop);
                }

            }
        });

        top6down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num.getText().toString();
                String st2 = top2num.getText().toString();
                String st3 = top3num.getText().toString();
                String st4 = top4num.getText().toString();
                String st5 = top5num.getText().toString();
                String st6 = top6num.getText().toString();
                int tp1 ,tp2,tp3,tp4 ,tp5,tp6;
                tp1=Integer.parseInt(st1);
                tp2=Integer.parseInt(st2);
                tp3=Integer.parseInt(st3);
                tp4=Integer.parseInt(st4);
                tp5=Integer.parseInt(st5);
                tp6=Integer.parseInt(st6);
                topCount = tp1+tp2+ tp3+tp4+tp5+tp6;
                if(topCount> min  && tp6 >min ){
                    String  newTop = String.valueOf(tp6-1);
                    top6num.setText(newTop);
                }

            }
        });














        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String valcname, valphone,valaddress,valpname;
                boolean trcname,trphone,traddress,trpname;
                valcname=   cname.getText().toString().trim();
                valphone=    phone.getText().toString().trim();
                valaddress=     address.getText().toString().trim();
                valpname=     pname.getText().toString().trim();
                Pattern ptrn1 = Pattern.compile("^\\([0-9]{3}\\)[0-9]{3}\\-[0-9]{4}");
                Matcher match1 = ptrn1.matcher(valphone);
                cname.setError(null);
                phone.setError(null);
                pname.setError(null);
                address.setError(null);
                if(match1.find() && match1.group().equals(valphone)){
                    trphone=true;
                }else{trphone=false;phone.setError("Format: (000)000-0000"); }


                if(valcname.isEmpty() ){
                    trcname=false;cname.setError("Enter Customer Name");
                }else if(valpname.length() >20){trcname=false;cname.setError("Max 20 Char");  }
                else { trcname=true;}

                if(valpname.isEmpty() ){
                    trpname=false;pname.setError("Enter Pizza Name");
                }else if(valpname.length() >20){trpname=false;pname.setError("Max 20 Char");  }
                else { trpname=true;}

                if(valaddress.length() >20){traddress=false;address.setError("Max 50 Char");  }
                else { traddress=true;}



                if(trphone && trcname && trpname && traddress){        MyDataBaseHelper myDB = new MyDataBaseHelper(AddPizza.this);
                    myDB.addPizzaOrder(cname.getText().toString().trim(),
                            phone.getText().toString().trim(),
                            address.getText().toString().trim(),
                            pname.getText().toString().trim(),
                            sizenum.getText().toString().trim(),
                            top1num.getText().toString().trim(),
                            top2num.getText().toString().trim(),
                            top3num.getText().toString().trim(),
                            top4num.getText().toString().trim(),
                            top5num.getText().toString().trim(),
                            top6num.getText().toString().trim()

                    );
                    Intent intent = new Intent(AddPizza.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }//if



            }







        });

    }
}