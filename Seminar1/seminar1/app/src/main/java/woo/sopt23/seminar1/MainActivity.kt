package woo.sopt23.seminar1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!){
            main_seminar_btn->{
                startActivity(Intent(this, SeminarActivity::class.java))
            }
            main_homework_btn->{
                startActivity(Intent(this, HomeWorkActivity::class.java))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_seminar_btn.setOnClickListener(this)
        main_homework_btn.setOnClickListener(this)
    }
}
