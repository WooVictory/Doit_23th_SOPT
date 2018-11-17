package app.woovictory.seminar5_23th

import android.animation.Animator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*FIXME
        * 타입을 명시하기 위해서 밑에 처럼 findViewById를 명시해서 찾아준다.
        *
        * */

      /*  val confetti_animation : LottieAnimationView = findViewById(R.id.lottie_main_activity)

        lottie_main_activity.setOnClickListener {
            confetti_animation.playAnimation()
        }*/

        lottie_main_activity.setOnClickListener {
            lottie_main_activity.playAnimation()
        }

        lottie_main_activity.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(p0: Animator?) {
            }

            override fun onAnimationEnd(p0: Animator?) {
                startActivity<SubActivity>()
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationStart(p0: Animator?) {
            }


        })

    }
}
