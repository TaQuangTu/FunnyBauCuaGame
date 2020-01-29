package com.taquangtu.gamebaucua;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.taquangtu.gamebaucua.CustomViews.ShakingResults;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    private ImageView mImvDisk;
    private ShakingResults mViewResults;
    private Button mBtnShake;
    private Button mBtnOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        mViewResults = findViewById(R.id.viewResults);
        mImvDisk = findViewById(R.id.imvDisk);
        mBtnShake = findViewById(R.id.btnShake);
        mBtnOpen = findViewById(R.id.btnOpen);

        mImvDisk.setOnClickListener(this);
        mBtnShake.setOnClickListener(this);
        mBtnOpen.setOnTouchListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mBtnShake) {
            mImvDisk.setVisibility(View.VISIBLE);
            mViewResults.setVisibility(View.GONE);
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_shake);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    mBtnOpen.setClickable(false);
                    mBtnShake.setClickable(false);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    mBtnOpen.setClickable(true);
                    mBtnShake.setClickable(true);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            mImvDisk.setAnimation(animation);
            mImvDisk.startAnimation(animation);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if(mViewResults.getVisibility()==View.VISIBLE){
                //do nothing
                return false;
            }

            int without = 0;
            int width = v.getWidth();
            int height = v.getHeight();
            Log.d("sss", "onTouch: "+width+" "+height);
            int x = (int) event.getX();
            int y = (int) event.getY();


            if(x<width/3&&y<height/2)without = 0;

            else if(x>=width/3&&x<=width/3*2&&y<height/2) without = 1;
            else if(x>width/3*2&&y<height/2) without = 2;

            else if(x<width/3&&y>=height/2) without = 3;
            else if(x>=width/3&&x<=width/3*2&&y>=height/2) without = 4;
            else if(x>width/3*2&&y>=height/2) without = 5;

            Shaker shaker = new Shaker();
            int[] results = shaker.shake(without);
            mViewResults.presentData(results[0], results[1], results[2]);
            mImvDisk.setVisibility(View.GONE);
            mViewResults.setVisibility(View.VISIBLE);
        }
        return false;
    }
}
