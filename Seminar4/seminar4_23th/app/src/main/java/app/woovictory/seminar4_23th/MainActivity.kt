package app.woovictory.seminar4_23th

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import app.woovictory.seminar4_23th.db.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v : View?) {
        when(v!!){
            btn_login_act_sign_in->{
                val loginId = et_login_act_id.text.toString()
                val loginPw = et_login_act_pw.text.toString()
                if(loginId.isNotEmpty() && loginPw.isNotEmpty()){
                    SharedPreferenceController.setUserId(this, loginId)
                    SharedPreferenceController.setUserPw(this, loginPw)

                    startActivity<MemoActivity>()
                    finish()

                }
            }
            btn_login_act_sign_up->{

            }
        }
    }

    // FIXME 로그인 화면!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_login_act_sign_in.setOnClickListener(this)
        btn_login_act_sign_up.setOnClickListener(this)

        if(SharedPreferenceController.getUserId(this).isNotEmpty()){
            startActivity(Intent(this, MemoActivity::class.java))

        }
    }
}
