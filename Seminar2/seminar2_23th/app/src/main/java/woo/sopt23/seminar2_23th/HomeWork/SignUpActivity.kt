package woo.sopt23.seminar2_23th.HomeWork

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_sign_up.*
import woo.sopt23.seminar2_23th.R

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v!!) {
            signUp_complete_btn -> {
                val intent: Intent = Intent()
                intent.putExtra("id",signUp_id.text.toString())
                setResult(Activity.RESULT_OK,intent)
                finish()


            }
            signUp_close_btn -> {

            }
        }
    }

    fun init() {
        signUp_complete_btn.setOnClickListener(this)
        signUp_close_btn.setOnClickListener(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        init() // 초기화 함수


        var id: String = intent.getStringExtra("user_id")
        signUp_id.setText(id)

    }
}
