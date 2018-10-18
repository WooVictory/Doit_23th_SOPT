package woo.sopt23.seminar2_23th

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import woo.sopt23.seminar2_23th.HomeWork.LoginActivity

class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!){
            seminar_btn->{

            }
            homework_btn->{
                startActivity<LoginActivity>("message" to "Success")
                finish()
            }
        }
    }


    fun init(){
        seminar_btn.setOnClickListener(this)
        homework_btn.setOnClickListener(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
}
