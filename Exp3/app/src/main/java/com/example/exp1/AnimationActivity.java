package com.example.exp1;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author yangjie
 * @date 2019-07-03
 */
public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button alpha_scale_btn;
    private ImageView mImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        alpha_scale_btn = findViewById(R.id.alpah_scale_btn);
        mImage = findViewById(R.id.testImage);
        alpha_scale_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Animation loadAnimation;
        switch (v.getId()) {
            case R.id.alpah_scale_btn:
                loadAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_scale_set);
                mImage.startAnimation(loadAnimation);
                break;
            default:
                break;
        }
    }
}
