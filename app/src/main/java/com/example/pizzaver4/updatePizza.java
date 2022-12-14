package com.example.pizzaver4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class updatePizza extends AppCompatActivity {


    SharedPreferences sharedPreferences;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_LANG = "key_lang";

    EditText cname_input;
    EditText phone_input;
    EditText address_input;
    EditText pname_input;
    TextView size2;
    TextView sizenum_input;
    Button sizeup2;
    TextView sizedown2;
    TextView top12;
    TextView top1num_input;
    Button top1up2;
    Button top1down2;
    TextView top22;
    TextView top2num_input;
    Button top2up2;
    Button top2down2;
    TextView top32;
    TextView top3num_input;
    Button top3up2;
    Button top3down2;


    TextView top42;
    TextView top4num_input;
    Button top4up2;
    Button top4down2;
    TextView top52;
    TextView top5num_input;
    Button top5up2;
    Button top5down2;
    TextView top62;
    TextView top6num_input;
    Button top6up2;
    Button top6down2;

    Button updatebutton;
    Button deletebutton;
    String id,date,cname,phone,address,pname,size,top1,top2,top3,top4,top5,top6;
    TextView topMax;
    int max=3,min=0,  sizemin=1,sizemax=4;
    int topCount = 0,sizeCount=2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pizza);

        cname_input = findViewById(R.id.cname2);
        phone_input = findViewById(R.id.phone2);
        address_input = findViewById(R.id.address2);
        pname_input = findViewById(R.id.pname2);

        size2 = findViewById(R.id.size2);
        sizenum_input = findViewById(R.id.sizenum2);
        sizeup2 = findViewById(R.id.sizeup2);
        sizedown2 = findViewById(R.id.sizedown2);

        top12 = findViewById(R.id.top12);
        top1num_input = findViewById(R.id.top1num2);
        top1up2 = findViewById(R.id.top1up2);
        top1down2 = findViewById(R.id.top1down2);
        top22 = findViewById(R.id.top22);
        top2num_input = findViewById(R.id.top2num2);
        top2up2 = findViewById(R.id.top2up2);
        top2down2 = findViewById(R.id.top2down2);
        top32 = findViewById(R.id.top32);
        top3num_input = findViewById(R.id.top3num2);
        top3up2 = findViewById(R.id.top3up2);
        top3down2 = findViewById(R.id.top3down2);


        top42 = findViewById(R.id.top42);
        top4num_input = findViewById(R.id.top4num2);
        top4up2 = findViewById(R.id.top4up2);
        top4down2 = findViewById(R.id.top4down2);
        top52 = findViewById(R.id.top52);
        top5num_input = findViewById(R.id.top5num2);
        top5up2 = findViewById(R.id.top5up2);
        top5down2 = findViewById(R.id.top5down2);
        top62 = findViewById(R.id.top62);
        top6num_input = findViewById(R.id.top6num2);
        top6up2 = findViewById(R.id.top6up2);
        top6down2 = findViewById(R.id.top6down2);


        updatebutton = findViewById(R.id.updatebutton);
        deletebutton = findViewById(R.id.deletebutton);

        topMax = findViewById(R.id.topMax2);



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
         cname_input.setHint(cnametxt);
         phone_input.setHint(phonetxt);
         address_input.setHint(addresstxt);
         pname_input.setHint(pnametxt);
         size2.setText(sizetxt);
         top12.setText(top1txt);
         top22.setText(top2txt);
         top32.setText(top3txt);

        top42.setText(top4txt);
        top52.setText(top5txt);
        top62.setText(top6txt);

         updatebutton.setText(updatetxt);
         deletebutton.setText(deletetxt);

        topMax.setText(topMaxtxt);




        sizeup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newSize = sizenum_input.getText().toString();
                sizeCount = Integer.parseInt(newSize);
                if(sizeCount>=sizemin && sizeCount< sizemax){
                    sizeCount++;
                    newSize = String.valueOf(sizeCount);
                    sizenum_input.setText(newSize);
                }

            }
        });

        sizedown2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newSize = sizenum_input.getText().toString();
                sizeCount = Integer.parseInt(newSize);
                if(sizeCount>sizemin && sizeCount<= sizemax){
                    sizeCount--;
                    newSize = String.valueOf(sizeCount);
                    sizenum_input.setText(newSize);
                }
            }
        });






        top1up2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num_input.getText().toString();
                String st2 = top2num_input.getText().toString();
                String st3 = top3num_input.getText().toString();
                String st4 = top4num_input.getText().toString();
                String st5 = top5num_input.getText().toString();
                String st6 = top6num_input.getText().toString();
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
                    top1num_input.setText(newTop);
                }

            }
        });

        top1down2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num_input.getText().toString();
                String st2 = top2num_input.getText().toString();
                String st3 = top3num_input.getText().toString();
                String st4 = top4num_input.getText().toString();
                String st5 = top5num_input.getText().toString();
                String st6 = top6num_input.getText().toString();
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
                    top1num_input.setText(newTop);
                }
            }
        });

        top2up2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num_input.getText().toString();
                String st2 = top2num_input.getText().toString();
                String st3 = top3num_input.getText().toString();
                String st4 = top4num_input.getText().toString();
                String st5 = top5num_input.getText().toString();
                String st6 = top6num_input.getText().toString();
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
                    top2num_input.setText(newTop);
                }

            }
        });

        top2down2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num_input.getText().toString();
                String st2 = top2num_input.getText().toString();
                String st3 = top3num_input.getText().toString();
                String st4 = top4num_input.getText().toString();
                String st5 = top5num_input.getText().toString();
                String st6 = top6num_input.getText().toString();
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
                    top2num_input.setText(newTop);
                }
            }
        });

        top3up2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num_input.getText().toString();
                String st2 = top2num_input.getText().toString();
                String st3 = top3num_input.getText().toString();
                String st4 = top4num_input.getText().toString();
                String st5 = top5num_input.getText().toString();
                String st6 = top6num_input.getText().toString();
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
                    top3num_input.setText(newTop);
                }

            }
        });

        top3down2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num_input.getText().toString();
                String st2 = top2num_input.getText().toString();
                String st3 = top3num_input.getText().toString();
                String st4 = top4num_input.getText().toString();
                String st5 = top5num_input.getText().toString();
                String st6 = top6num_input.getText().toString();
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
                    top3num_input.setText(newTop);
                }
            }
        });

















        top4up2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num_input.getText().toString();
                String st2 = top2num_input.getText().toString();
                String st3 = top3num_input.getText().toString();
                String st4 = top4num_input.getText().toString();
                String st5 = top5num_input.getText().toString();
                String st6 = top6num_input.getText().toString();
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
                    top4num_input.setText(newTop);
                }

            }
        });

        top4down2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num_input.getText().toString();
                String st2 = top2num_input.getText().toString();
                String st3 = top3num_input.getText().toString();
                String st4 = top4num_input.getText().toString();
                String st5 = top5num_input.getText().toString();
                String st6 = top6num_input.getText().toString();
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
                    top4num_input.setText(newTop);
                }
            }
        });

        top5up2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num_input.getText().toString();
                String st2 = top2num_input.getText().toString();
                String st3 = top3num_input.getText().toString();
                String st4 = top4num_input.getText().toString();
                String st5 = top5num_input.getText().toString();
                String st6 = top6num_input.getText().toString();
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
                    top5num_input.setText(newTop);
                }

            }
        });

        top5down2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num_input.getText().toString();
                String st2 = top2num_input.getText().toString();
                String st3 = top3num_input.getText().toString();
                String st4 = top4num_input.getText().toString();
                String st5 = top5num_input.getText().toString();
                String st6 = top6num_input.getText().toString();
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
                    top5num_input.setText(newTop);
                }
            }
        });

        top6up2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num_input.getText().toString();
                String st2 = top2num_input.getText().toString();
                String st3 = top3num_input.getText().toString();
                String st4 = top4num_input.getText().toString();
                String st5 = top5num_input.getText().toString();
                String st6 = top6num_input.getText().toString();
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
                    top6num_input.setText(newTop);
                }

            }
        });

        top6down2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st1 = top1num_input.getText().toString();
                String st2 = top2num_input.getText().toString();
                String st3 = top3num_input.getText().toString();
                String st4 = top4num_input.getText().toString();
                String st5 = top5num_input.getText().toString();
                String st6 = top6num_input.getText().toString();
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
                    top6num_input.setText(newTop);
                }
            }
        });











        //First need to call getters
        getAndSetData();
        ActionBar actionbar = getSupportActionBar();
        //sets the page title
        actionbar.setTitle(pname);

        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //then we can call our db setter for update,  pass data from our intent data
                String valcname, valphone,valaddress,valpname;
                boolean trcname,trphone,traddress,trpname;
                valcname=   cname_input.getText().toString().trim();
                valphone=    phone_input.getText().toString().trim();
                valaddress=     address_input.getText().toString().trim();
                valpname=     pname_input.getText().toString().trim();
                Pattern ptrn1 = Pattern.compile("^\\([0-9]{3}\\)[0-9]{3}\\-[0-9]{4}");
                Matcher match1 = ptrn1.matcher(valphone);
                cname_input.setError(null);
                phone_input.setError(null);
                pname_input.setError(null);
                address_input.setError(null);
                if(match1.find() && match1.group().equals(valphone)){
                    trphone=true;
                }else{trphone=false;phone_input.setError("Format: (000)000-0000"); }
                if(valcname.isEmpty() ){
                    trcname=false;cname_input.setError("Enter Customer Name");
                }else if(valcname.length() >20){trcname=false;cname_input.setError("Max 20 Char");  }
                else { trcname=true;}
                if(valpname.isEmpty() ){
                    trpname=false;pname_input.setError("Enter Customer Name");
                }else if(valpname.length() >20){trpname=false;pname_input.setError("Max 20 Char");  }
                else { trpname=true;}
                if(valaddress.length() >20){traddress=false;address_input.setError("Max 50 Char");  }
                else { traddress=true;}
                if(trphone && trcname && trpname && traddress){
                    MyDataBaseHelper myDB=new MyDataBaseHelper(updatePizza.this) ;
                    cname= cname_input.getText().toString().trim();
                    phone= phone_input.getText().toString().trim();
                    address= address_input.getText().toString().trim();
                    pname= pname_input.getText().toString().trim();
                    size = sizenum_input.getText().toString().trim();
                    top1 = top1num_input.getText().toString().trim();
                    top2 = top2num_input.getText().toString().trim();
                    top3 = top3num_input.getText().toString().trim();
                    top4 = top4num_input.getText().toString().trim();
                    top5 = top5num_input.getText().toString().trim();
                    top6 = top6num_input.getText().toString().trim();
                    myDB.updateData(id,cname,phone,address,pname,size,top1,top2,top3,top4,top5,top6);
                    Intent intent = new Intent(updatePizza.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }//if
            }
        });
        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                MyDataBaseHelper myDB=new MyDataBaseHelper(updatePizza.this) ;
//                myDB.deleteOnePizza(id);
                confirmDialog();
                //   "Yes"   "no"    delete buttons pop up
            }
        });
    }
    void getAndSetData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("date")&& getIntent().hasExtra("cname")
                && getIntent().hasExtra("phone")&& getIntent().hasExtra("address")
                && getIntent().hasExtra("size")&& getIntent().hasExtra("top1")
                && getIntent().hasExtra("top2")&& getIntent().hasExtra("top3")
                && getIntent().hasExtra("top4") && getIntent().hasExtra("top5")
                && getIntent().hasExtra("top6")){
          //GET Data from our intent
            id=getIntent().getStringExtra("id");
            date=getIntent().getStringExtra("date");
            cname=getIntent().getStringExtra("cname");
            phone=getIntent().getStringExtra("phone");
            address=getIntent().getStringExtra("address");
            pname=getIntent().getStringExtra("pname");
            size=getIntent().getStringExtra("size");
            top1=getIntent().getStringExtra("top1");
            top2=getIntent().getStringExtra("top2");
            top3=getIntent().getStringExtra("top3");
            top4=getIntent().getStringExtra("top4");
            top5=getIntent().getStringExtra("top5");
            top6=getIntent().getStringExtra("top6");
            //Set intent data
            cname_input.setText(cname);
            phone_input.setText(phone);
            address_input.setText(address);
            pname_input.setText(pname);
            sizenum_input.setText(size);
            top1num_input.setText(top1);
            top2num_input.setText(top2);
            top3num_input.setText(top3);
            top4num_input.setText(top4);
            top5num_input.setText(top5);
            top6num_input.setText(top6);
        }else{
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }


    }
    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete" + pname + " ?");
        builder.setMessage("Are you sure you want to delete " + pname + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //deletes row on pop up button instead of direct delete button
                MyDataBaseHelper myDB=new MyDataBaseHelper(updatePizza.this) ;
                myDB.deleteOnePizza(id);
                finish();//close current activity and return to parent activity
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //
                Toast.makeText(updatePizza.this, "Nothing was deleted", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();

    }

}