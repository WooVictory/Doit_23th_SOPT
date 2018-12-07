package app.woovictory.seminar5_23th

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_sub.*
import org.jetbrains.anko.toast

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        /*FIXME
        * lazy : 상수일 경우에만 사용한다.
        * */
        val bottomBarAnimation : Animation by lazy {
            AnimationUtils.loadAnimation(this, R.anim.example_animation)
        }

        val bottomBarAnimation2 : Animation by lazy {
            AnimationUtils.loadAnimation(this, R.anim.example_anim2)
        }


        bottomBarAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
                toast("애니메이션 끝!")
            }

            override fun onAnimationStart(p0: Animation?) {
                toast("애니메이션 시작!")
            }
        })


        bottomBarAnimation2.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
            }

            override fun onAnimationStart(p0: Animation?) {
            }
        })

        btn_sub_act_show_bottom_bar.setOnClickListener {

            var layout : RelativeLayout = findViewById(R.id.rl_sub_act_bottom_bar)
            var layoutParams = layout.layoutParams
            layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
            //layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
            layout.layoutParams = layoutParams
            layout.startAnimation(bottomBarAnimation)
        }

        down_btn.setOnClickListener{
            var layout : RelativeLayout = findViewById(R.id.rl_sub_act_bottom_bar)
            var layoutParams = layout.layoutParams
            layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT-100
            //layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
            layout.layoutParams = layoutParams
            layout.startAnimation(bottomBarAnimation2)
        }

        rl_sub_act_bottom_bar.setOnClickListener{
            rl_sub_act_bottom_bar.visibility = View.GONE
            show_layout.visibility = View.VISIBLE
            show_layout.startAnimation(bottomBarAnimation)
        }






    }
}
