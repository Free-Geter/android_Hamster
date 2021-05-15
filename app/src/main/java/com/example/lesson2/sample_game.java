package com.example.lesson2;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.Random;
public class sample_game extends AppCompatActivity {

    private int i=0;
    private ImageView mouse;
    private TextView info1;
    private Handler handler;
    public int[][] position=new int[][]{
            {277, 200}, {535, 200}, {832, 200},
            {1067,200}, {1328, 200}, {285, 360},
            {645, 360}, {1014,360}, {1348, 360},{319, 600},{764, 600},{1229,600}
    };

    @Override
    @SuppressLint({"ClickableViewAccessibility", "HandlerLeak"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);


        mouse = (ImageView) findViewById(R.id.imageView1);
        info1 = (TextView) findViewById(R.id.info);


        info1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        float x = event.getRawX();
                        float y = event.getRawY();
                        Log.i("x:" + x, "y:" + y);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });


        handler = new Handler() {
            @SuppressLint("HandlerLeak")
            @Override
            public void handleMessage(@NonNull Message msg) {

                int index;
                if (msg.what == 0x101) {
                    index = msg.arg1;
                    mouse.setX(position[index][0]);
                    mouse.setY(position[index][1]);
                    mouse.setVisibility(View.VISIBLE);
                }
                super.handleMessage(msg);
            }
        };

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int index = 0;
                while (!Thread.currentThread().isInterrupted()) {
                    index = new Random().nextInt(position.length);
                    Message m = handler.obtainMessage();
                    m.what = 0x101;
                    m.arg1 = index;
                    handler.sendMessage(m);
                    try {
                        Thread.sleep(new Random().nextInt(500) + 500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();

        mouse.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setVisibility(View.INVISIBLE);
                i++;
                Toast.makeText(sample_game.this, "打到[ " + i + " ]只地鼠！",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }}
