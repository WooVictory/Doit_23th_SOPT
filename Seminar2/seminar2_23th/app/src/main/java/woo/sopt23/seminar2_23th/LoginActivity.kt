package woo.sopt23.seminar2_23th

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v) {
            login_signIn_btn -> {
                toast("Login Button")
            }
            login_signUp_btn -> {
                var userId: String = login_id.text.toString()
                login_id.setText(" ") // 빈 문자열로 만들고 회원 가입 화면으로 이동
                startActivityForResult<SignUpActivity>(REQ_CODE, "user_id" to userId)
            }
            login_linear -> {
                /*FIXME
                *  키보드 올라왔을 때 바깥 쪽 터치 했을 때 내려가게 하는 코드
                * */

                inputManager.hideSoftInputFromWindow(login_id.getWindowToken(), 0)
                login_id.clearFocus()
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                if (data!! != null) {
                    login_id.setText(data!!.getStringExtra("id"))
                }
            }
        }

    }

    val REQ_CODE: Int = 100
    lateinit var inputManager : InputMethodManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_signIn_btn.setOnClickListener(this)
        login_signUp_btn.setOnClickListener(this)
        login_linear.setOnClickListener(this)
        inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager


    }
}
