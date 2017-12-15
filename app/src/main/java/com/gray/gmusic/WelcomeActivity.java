package com.gray.gmusic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class WelcomeActivity extends Activity {

    ImageView ivWelcome01;
    Animation animationWelcomeAlpha;
    Intent intentStartMainActivity;

    public void setupView() {
        ivWelcome01 = (ImageView) findViewById(R.id.img_welcome01);
        animationWelcomeAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        intentStartMainActivity = new Intent(WelcomeActivity.this, MainActivity.class);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        setupView();

        ivWelcome01.startAnimation(animationWelcomeAlpha);

        animationWelcomeAlpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(intentStartMainActivity);

                WelcomeActivity.this.finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


}
