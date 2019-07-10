package com.example.exp1;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.exp1.fragment.ViewPagerWithTabActivity;

public class Main3Activity extends AppCompatActivity {
    private Button malpha_scale_btn;
    private Button malpha_scale_btn2;
    private SeekBar msb;
    private Animation loadAnimation;
    private ImageView mImage;
    private LottieAnimationView mlav;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mImage = findViewById(R.id.testImage);
        malpha_scale_btn = findViewById(R.id.alpah_scale_btn);
        malpha_scale_btn2= findViewById(R.id.alpha_scale_btn2);
        msb =findViewById(R.id.sb);
        mlav = findViewById(R.id.animation_view);
        malpha_scale_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadAnimation = AnimationUtils.loadAnimation(Main3Activity.this, R.anim.alpha_scale_set);
                mImage.startAnimation(loadAnimation);
            }
        });
        msb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mlav.pauseAnimation();
                mlav.setProgress(i/100f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        malpha_scale_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(findViewById(R.id.alpha_scale_btn2),"scaleX",1,0);
                animator.setDuration(1500);
                animator.setRepeatCount(ValueAnimator.INFINITE);
                animator.setRepeatMode(ValueAnimator.REVERSE);
                animator.setInterpolator(new LinearInterpolator());
                animator.start();

                ObjectAnimator animator1 = ObjectAnimator.ofFloat(findViewById(R.id.alpha_scale_btn2),"scaleY",1,0);
                animator1.setDuration(1500);
                animator1.setRepeatCount(ValueAnimator.INFINITE);
                animator1.setRepeatMode(ValueAnimator.REVERSE);
                animator1.setInterpolator(new LinearInterpolator());
                animator1.start();

                ObjectAnimator animator2 = ObjectAnimator.ofFloat(findViewById(R.id.alpha_scale_btn2),"alpha",0.1f,1.0f);
                animator2.setDuration(1000);
                animator2.setRepeatCount(ValueAnimator.INFINITE);
                animator2.setRepeatMode(ValueAnimator.REVERSE);
                animator2.setInterpolator(new LinearInterpolator());
                animator2.start();

                /*AnimatorSet setAnimation = new AnimatorSet();
                setAnimation.play(animator).before(animator1);*/
            }
        });
        bindActivity(R.id.btn_viewPagerTab, ViewPagerWithTabActivity.class);
    }

    private void bindActivity(final int btnId, final Class<?> activityClass) {
        findViewById(btnId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main3Activity.this, activityClass));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }
}