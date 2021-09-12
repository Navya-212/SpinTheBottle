package com.example.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView bottle;
    Random random=new Random();
    int lastDir;//generates random degress of spinning
    boolean isSpinning;//to check whether it is spinning or not

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottle=findViewById(R.id.bottle);
        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isSpinning){
                    int newdir=random.nextInt(1800);//360*5==1800 so bottle spins for 5 tyms and then stops
                    float pivotX=bottle.getWidth()/2;
                    float pivotY=bottle.getHeight()/2;//if square(4,4) is there then its center is(4/2,4/2)

                    Animation rotate=new RotateAnimation(lastDir,newdir,pivotX,pivotY);
                    rotate.setDuration(2500);
                    rotate.setFillAfter(true);//optional

                    lastDir=newdir;
                    bottle.startAnimation(rotate);

                    rotate.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            isSpinning=true;
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            isSpinning=false;
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                }
            }
        });
    }
}