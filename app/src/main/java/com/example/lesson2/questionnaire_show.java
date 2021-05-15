package com.example.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class questionnaire_show extends AppCompatActivity {
    private TextView tv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_show);

        tv_show = findViewById(R.id.tv_show_questionnaire);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String sex = extras.getString("sex");
        String money = extras.getString("money");
        ArrayList<String> eat = extras.getStringArrayList("eat");
        String grade = extras.getString("grade");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("用户年级：").append(grade).append("\n");
        stringBuilder.append("用户性别：").append(sex).append("\n");
        stringBuilder.append("用户用餐地点：");
        for (String s :
                eat) {
            stringBuilder.append(s).append("、");
        }
        stringBuilder.delete(stringBuilder.length() - 1,stringBuilder.length());
        stringBuilder.append("\n");
        stringBuilder.append("用户月平均消费：").append(money).append("\n");

        tv_show.setText(stringBuilder.toString());
    }
}