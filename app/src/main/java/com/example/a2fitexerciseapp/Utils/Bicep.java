package com.example.a2fitexerciseapp.Utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class Bicep {


    private static final DecelerateInterpolator DECCELERATE_INTERPOLATOR = new DecelerateInterpolator();
    private static final AccelerateInterpolator ACCELERATE_INTERPOLATOR = new AccelerateInterpolator();

    public ImageView likeWhite, likeYellow;

    public Bicep(ImageView likeWhite, ImageView likeYellow) {
        this.likeWhite = likeWhite;
        this.likeYellow = likeYellow;
    }

    public void toggleLike(){


        AnimatorSet animationSet =  new AnimatorSet();


        if(likeYellow.getVisibility() == View.VISIBLE){

            likeYellow.setScaleX(0.1f);
            likeYellow.setScaleY(0.1f);

            ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(likeYellow, "scaleY", 1f, 0f);
            scaleDownY.setDuration(300);
            scaleDownY.setInterpolator(ACCELERATE_INTERPOLATOR);

            ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(likeYellow, "scaleX", 1f, 0f);
            scaleDownX.setDuration(300);
            scaleDownX.setInterpolator(ACCELERATE_INTERPOLATOR);

            likeYellow.setVisibility(View.GONE);
            likeWhite.setVisibility(View.VISIBLE);

            animationSet.playTogether(scaleDownY, scaleDownX);
        }

        else if(likeYellow.getVisibility() == View.GONE){

            likeYellow.setScaleX(0.1f);
            likeYellow.setScaleY(0.1f);

            ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(likeYellow, "scaleY", 0.1f, 1f);
            scaleDownY.setDuration(300);
            scaleDownY.setInterpolator(DECCELERATE_INTERPOLATOR);

            ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(likeYellow, "scaleX", 0.1f, 1f);
            scaleDownX.setDuration(300);
            scaleDownX.setInterpolator(DECCELERATE_INTERPOLATOR);

            likeYellow.setVisibility(View.VISIBLE);
            likeWhite.setVisibility(View.GONE);

            animationSet.playTogether(scaleDownY, scaleDownX);
        }

        animationSet.start();

    }
}
