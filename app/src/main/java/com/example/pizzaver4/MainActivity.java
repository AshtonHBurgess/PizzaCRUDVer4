package com.example.pizzaver4;

//App was made by Ashton burgess, Student number: W0465511
//Made referencing the 6 part tutorial "SQLite Database + Android", by Stevda-San
//Video tutorials can be found at on his youtube account: Stevda-San
// Link to his tutorials  "https://youtu.be/hJPk50p7xwA"
//
//  His tutorials, build a CRUD library android application
//   10/10 online instructor aswell, recommend checking out his channel







import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_LANG = "key_lang";

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    ImageView nopizza_img;
    TextView nopizza_text;


    PizzaOrderAdapter pizzaOrderAdapter;
    MyDataBaseHelper myDB ;

    ArrayList<String> order_id, order_date,order_cname,order_phone,order_address,
            order_pname,order_sizenum,order_top1num,order_top2num,order_top3num,
            order_top4num,order_top5num,order_top6num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recyclerView);
        add_button=findViewById(R.id.add_button);
        nopizza_img=findViewById(R.id.nopizza_img);
        nopizza_text=findViewById(R.id.nopizza_text);





        //change language  En Fr
        String[] english_list = getResources().getStringArray(R.array.english_list);
        String[] french_list = getResources().getStringArray(R.array.french_list);
        String pnametxt="Pizza Name", deletetxt="DELETE",addtxt="ADD", updatetxt="UPDATE",nopizzatxt="No Pizzas",sizetxt="Size: S(1) M(2)  L(3) XL(4)",top1txt="Cheese:",top2txt="Pepperoni:",top3txt="Bacon:",cnametxt="Customer Name...",phonetxt="Phone Number...",addresstxt="Adress...";
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
            }
        }
        nopizza_text.setText(nopizzatxt);





        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddPizza.class);
                startActivity(intent);
            }
        });

        myDB = new MyDataBaseHelper(MainActivity.this);
        order_id = new ArrayList<>();
        order_date = new ArrayList<>();
        order_cname = new ArrayList<>();
        order_phone = new ArrayList<>();
        order_address = new ArrayList<>();
        order_pname = new ArrayList<>();
        order_sizenum = new ArrayList<>();
        order_top1num = new ArrayList<>();
        order_top2num = new ArrayList<>();
        order_top3num = new ArrayList<>();
        order_top4num = new ArrayList<>();
        order_top5num = new ArrayList<>();
        order_top6num = new ArrayList<>();

        storeIntoArrays();

        pizzaOrderAdapter = new PizzaOrderAdapter(MainActivity.this,this,order_id,order_date,order_cname,
                order_phone,order_address, order_pname,order_sizenum,order_top1num, order_top2num, order_top3num ,order_top4num, order_top5num, order_top6num);
        recyclerView.setAdapter(pizzaOrderAdapter);//must set adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }
        //NOTE** CTR + O   opens override code menu
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();//method refreshes activity
        }
    }

    void storeIntoArrays(){
        Cursor cursor = myDB.readAlldata();
        //check if cursor came back null
        if(cursor.getCount() == 0){
//            Toast.makeText(this, "No Pizza Order Data", Toast.LENGTH_SHORT).show();
            nopizza_img.setVisibility(View.VISIBLE);
            nopizza_text.setVisibility(View.VISIBLE);
        }
        else {
            while(cursor.moveToNext()){
                //reading each row
                // order_id.add(cursor.getString(  int ));  "int"  represents the col position
                order_id.add(cursor.getString(0));
                order_date.add(cursor.getString(1));
                order_cname.add(cursor.getString(2));
                order_phone.add(cursor.getString(3));
                order_address.add(cursor.getString(4));
                order_pname.add(cursor.getString(5));
                order_sizenum.add(cursor.getString(6));
                order_top1num.add(cursor.getString(7));
                order_top2num.add(cursor.getString(8));
                order_top3num.add(cursor.getString(9));
                order_top4num.add(cursor.getString(10));
                order_top5num.add(cursor.getString(11));
                order_top6num.add(cursor.getString(12));
                nopizza_img.setVisibility(View.GONE);
                nopizza_text.setVisibility(View.GONE);

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //trigger onclick listener for menu options
        if(item.getItemId() == R.id.English){
            SharedPreferences.Editor editor=sharedPreferences.edit();
            String key_lang = sharedPreferences.getString(KEY_LANG,null);
            String langEF = "en";
            if(key_lang != null){
                //SET TEXT TO ENGLISH OR FRENCH
                if(key_lang.equals("en")){
                    //SET TO fr and change text
                    langEF="en";
                }

            }
            editor.putString(KEY_LANG,langEF);
            editor.apply();
    Intent intent = new Intent(this,MainActivity.class);
    startActivity(intent);
    finish();
        }
        if(item.getItemId() == R.id.French){
            SharedPreferences.Editor editor=sharedPreferences.edit();
            String key_lang = sharedPreferences.getString(KEY_LANG,null);
            String langEF = "fr";
            if(key_lang != null){
           if(key_lang.equals("fr")){
                    //SET TO en and change text
                    langEF = "fr";
                }
            }
            editor.putString(KEY_LANG,langEF);
            editor.apply();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }



if(item.getItemId() == R.id.delete_all){
    Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
    MyDataBaseHelper myDB = new MyDataBaseHelper(this);
//    myDB.deleteAllPizzas();
////    recreate();//reload from scratch
//
//    //Refresh after delete all
//    Intent intent = new Intent(this,MainActivity.class);
//    startActivity(intent);
//    finish();
    confirmDialog();
}
        return super.onOptionsItemSelected(item);
    }
    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete All ?");
        builder.setMessage("Are you sure you want to delete All Pizzas ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //deletes row on pop up button instead of direct delete button
                MyDataBaseHelper myDB=new MyDataBaseHelper(MainActivity.this) ;
                myDB.deleteAllPizzas();
//    recreate();//reload from scratch

                //Refresh after delete all
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //
                Toast.makeText(MainActivity.this, "Nothing was deleted", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();

    }
}