package com.example.lesson2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Fragment_dynamic extends FragmentActivity implements Fragment_item.ImageClickedListener{
    private ImageView showImg,itemImg;
    private TextView txt;
    private Fragment tiny;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dynamic);

        showImg = findViewById(R.id.show_imageView);
        txt = findViewById(R.id.showImage_text);

        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            tiny = new Fragment_item();
            tiny.setArguments(getIntent().getExtras());

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.content_item,tiny,"itemFragment");

            transaction.commit();
        } else {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            tiny = manager.findFragmentByTag("itemFragment");
            if (tiny!=null)
                transaction.remove(tiny);
            transaction.commit();
        }
    }

    @Override
    public void updateImage(ImageView img) {
        showImg.setImageDrawable(img.getDrawable());
        txt.setText(showImg.getContentDescription());
    }
}