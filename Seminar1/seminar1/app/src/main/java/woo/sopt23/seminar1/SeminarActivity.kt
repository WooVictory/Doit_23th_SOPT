package woo.sopt23.seminar1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_seminar.*
import org.jetbrains.anko.toast

class SeminarActivity : AppCompatActivity(), View.OnClickListener {
    /*FIXME
    * Activity 전역에서 View.OnClickListener을 상속 받도록 하여
    * onClick 함수에서 Click과 관련된 이벤트를 모두 처리하도록 할 수 있다.
    * */

    override fun onClick(v: View?) {
        when(v!!){
            inputButton_main->{
                var color : String = edit_main.text.toString()
                toast(color)
            }
        }
    }

    fun init(){
        inputButton_main.setOnClickListener(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seminar)
        init()


    }
}
