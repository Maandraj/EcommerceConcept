package com.maandraj.ecommerceconcept.presentation.activity.splash

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.maandraj.ecommerceconcept.R
import com.maandraj.ecommerceconcept.presentation.activity.MainActivity
import com.maandraj.ecommerceconcept.databinding.ActivitySplashBinding


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity(R.layout.activity_splash) {

    private val binding: ActivitySplashBinding by viewBinding(ActivitySplashBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        animateLogo()
    }

    private fun animateLogo() {
        val animationHeight = ObjectAnimator.ofFloat(binding.viewLogo, "scaleX", LOGO_SIZE_HEIGHT)
        val animationWidth = ObjectAnimator.ofFloat(binding.viewLogo, "scaleY", LOGO_SIZE_WIDTH)
        val set = AnimatorSet()
        set.play(animationHeight).with(animationWidth)
        set.duration = LOGO_SIZE_DURATION
        set.start()
        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                animateText()
            }
        })
    }

    private fun animateText() {
        val animationAlpha = ObjectAnimator.ofFloat(binding.tvAppName, "alpha", 1F)
        val set = AnimatorSet()
        set.play(animationAlpha)
        set.duration = TEXT_ALPHA_DURATION
        set.start()
        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                showMainActivity()
            }
        })
    }

    private fun showMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    companion object {
        private const val LOGO_SIZE_WIDTH = 132F
        private const val LOGO_SIZE_HEIGHT = 132F
        private const val LOGO_SIZE_DURATION = 0L // 900L
        private const val TEXT_ALPHA_DURATION = 0L // 1000L
    }
}