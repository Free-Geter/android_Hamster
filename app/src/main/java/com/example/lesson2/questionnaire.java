package com.example.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class questionnaire extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private EditText et_money;
    private final int[] checkboxId =  {R.id.cb_eat_hall,R.id.cb_eat_restaurant,R.id.cb_eat_foodCar,R.id.cb_eat_order,R.id.cb_eat_else};
    private RadioGroup rg_sex,rg_grade;
    private RadioButton rb_sex,rb_grade;
    private Button bt_submit;

    String sex,grade;
    ArrayList<String> eat = new ArrayList<>();
    String money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        rg_sex = findViewById(R.id.rg_sex);
        rg_grade = findViewById(R.id.rg_grade);

        et_money = findViewById(R.id.et_money);

        bt_submit = findViewById(R.id.bt_submit);


        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rg_sex.getCheckedRadioButtonId() == -1)
                    sex = "";
                else{
                    rb_sex = findViewById(rg_sex.getCheckedRadioButtonId());
                    sex = rb_sex.getText().toString();
                }

                if (rg_grade.getCheckedRadioButtonId() == -1)
                    grade = "";
                else{
                    rb_grade = findViewById(rg_grade.getCheckedRadioButtonId());
                    grade = rb_grade.getText().toString();
                }

                for (int id :
                        checkboxId) {
                    CheckBox checkbox = findViewById(id);
                    if (checkbox.isChecked()){
                        eat.add(checkbox.getText().toString());
                    }
                }

                money = et_money.getText().toString();


                Intent intent = new Intent(questionnaire.this,questionnaire_show.class);
                Bundle bundle = new Bundle();
                bundle.putString("sex",sex);
                bundle.putString("grade",grade);
                bundle.putString("money",money);
                bundle.putStringArrayList("eat",eat);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}