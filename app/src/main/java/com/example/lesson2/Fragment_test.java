package com.example.lesson2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Fragment_test extends FragmentActivity {

    private ImageView showImg,itemImage;
    int imgId[] = {R.id.tinyImage01,R.id.tinyImage02,R.id.tinyImage03,R.id.tinyImage04,R.id.tinyImage05,R.id.tinyImage06};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        showImg = findViewById(R.id.show_imageView);
    }

    void setShowImg(){
        for (int i = 0; i < imgId.length; i++) {
            itemImage = findViewById(imgId[i]);
            itemImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageView img = (ImageView)v;
                    showImg.setImageDrawable(img.getDrawable());
                }
            });
        }
    }
}