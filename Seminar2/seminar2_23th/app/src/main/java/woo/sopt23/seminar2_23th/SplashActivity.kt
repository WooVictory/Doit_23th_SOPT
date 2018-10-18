package woo.sopt23.seminar2_23th

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)



        var gifImage : GlideDrawableImageViewTarget = GlideDrawableImageViewTarget(splash_image)

        Glide.with(this).load(R.drawable.gif2).into(gifImage)


        val handler = Handler()

        handler.postDelayed({
            // Anko 라이브러리 사용
            startActivity<MainActivity>("message" to "success")
        },4000)

    }
}
