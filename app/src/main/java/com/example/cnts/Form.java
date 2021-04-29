package com.example.cnts;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Form extends AppCompatActivity implements View.OnClickListener {
    private Button[] btn = new Button[4];
    private Button[] btn_type = new Button[2];

    private Button btn_unfocus;
    private Button btn_type_unfocus;

    private int[] btn_id = {R.id.typeA, R.id.typeB, R.id.typeAB, R.id.typeO};
    private int[] btn_id_type = {R.id.positive, R.id.negative};

    String name;
    String phone;
    String date;
    String type;
    String value;
    double height;
    double weight;
    TextInputLayout nameInput;
    TextInputLayout dateInput;
    TextInputLayout phoneInput;
    TextInputLayout heightInput;
    TextInputLayout weightInput;
    Button submitButton,cancelButton;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        mDatabase = FirebaseDatabase.getInstance("https://cnts-da2eb-default-rtdb.firebaseio.com").getReference();

        nameInput = (TextInputLayout)findViewById(R.id.Name);
        phoneInput = (TextInputLayout)findViewById(R.id.Phone);
        dateInput = (TextInputLayout)findViewById(R.id.BirthDate);
        heightInput = (TextInputLayout)findViewById(R.id.Height);
        weightInput = (TextInputLayout)findViewById(R.id.Weight);

        submitButton = (Button)findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/mm/yyyy");
                LocalDateTime now = LocalDateTime.now();
                name = nameInput.getEditText().getText().toString();
                phone = phoneInput.getEditText().getText().toString();
                date = dateInput.getEditText().getText().toString();
                height = Double.parseDouble(heightInput.getEditText().getText().toString());
                weight = Double.parseDouble(weightInput.getEditText().getText().toString());
                String uid = String.valueOf(UUID.randomUUID());
                Donner donnerTest = new Donner(uid,name,phone,type,weight,height,date, dtf.format(now), 0);
                mDatabase.child("Donners").child(uid).setValue(donnerTest);
                final Intent intent = new Intent(Form.this, MainActivity.class);
                startActivity(intent);
            }
        });
        cancelButton = (Button)findViewById(R.id.cancel);
        cancelButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V) {
                final Intent intent = new Intent(Form.this, MainActivity.class);
                startActivity(intent);
            }
        });
        for(int i = 0; i < btn.length; i++){
            btn[i] = (Button) findViewById(btn_id[i]);
            btn[i].setTextColor(Color.parseColor("#434343"));
            btn[i].setBackgroundColor(Color.parseColor("#FFFCFC"));
            btn[i].setOnClickListener(this::onClick);
        }

        for(int i = 0; i < btn_type.length; i++){
            btn_type[i] = (Button) findViewById(btn_id_type[i]);
            btn_type[i].setTextColor(Color.parseColor("#434343"));
            btn_type[i].setBackgroundColor(Color.parseColor("#FFFCFC"));
            btn_type[i].setOnClickListener(this::onClickType);
        }

        btn_unfocus = btn[0];
        btn_type_unfocus = btn_type[0];
        setFocus(btn_unfocus, btn[0]);
        setTypeFocus(btn_type_unfocus, btn_type[0]);
    }


    @Override
    public void onClick(View v) {
        //setForcus(btn_unfocus, (Button) findViewById(v.getId()));
        //Or use switch
        switch (v.getId()){
            case R.id.typeA :
                setFocus(btn_unfocus, btn[0]);
                break;

            case R.id.typeB :
                setFocus(btn_unfocus, btn[1]);
                break;

            case R.id.typeAB :
                setFocus(btn_unfocus, btn[2]);
                break;

            case R.id.typeO :
                setFocus(btn_unfocus, btn[3]);
                break;
        }
    }

    public void onClickType(View v) {
        switch (v.getId()){
            case R.id.positive :
                setTypeFocus(btn_type_unfocus, btn_type[0]);
                break;

            case R.id.negative :
                setTypeFocus(btn_type_unfocus, btn_type[1]);
                break;
        }
    }



    private void setFocus(Button btn_unfocus, Button btn_focus){
        btn_unfocus.setTextColor(Color.parseColor("#434343"));
        btn_unfocus.setBackgroundColor(Color.parseColor("#FFFCFC"));
        btn_focus.setTextColor(Color.parseColor("#FFFFFF"));
        btn_focus.setBackgroundColor(Color.parseColor("#D80032"));
        this.btn_unfocus = btn_focus;
        this.type = btn_focus.getText().toString();
    }
    private void setTypeFocus(Button btn_type_unfocus, Button btn_type_focus){
        btn_type_unfocus.setTextColor(Color.parseColor("#434343"));
        btn_type_unfocus.setBackgroundColor(Color.parseColor("#FFFCFC"));
        btn_type_focus.setTextColor(Color.parseColor("#FFFFFF"));
        btn_type_focus.setBackgroundColor(Color.parseColor("#D80032"));
        this.btn_type_unfocus = btn_type_focus;
        this.value = btn_type_focus.getText().toString();
    }

    private void showToast(String text) {
        Toast.makeText(Form.this,text,Toast.LENGTH_LONG).show();
    }
}