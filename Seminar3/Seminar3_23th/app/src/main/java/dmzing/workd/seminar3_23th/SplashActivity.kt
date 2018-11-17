package dmzing.workd.seminar3_23th

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v!!) {
            seminarBtn -> startActivity<MainActivity>()
            homeworkBtn -> startActivity<Main2Activity>()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        seminarBtn.setOnClickListener(this)
        homeworkBtn.setOnClickListener(this)
    }
}
