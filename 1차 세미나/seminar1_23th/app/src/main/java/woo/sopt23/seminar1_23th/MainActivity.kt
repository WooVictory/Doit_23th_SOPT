package woo.sopt23.seminar1_23th

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!){
            inputButton_main->{
                var str = edit_main.text.toString()
                edit_main.setText(" ")


                //dialog.setTitle("Loading ...")
                dialog.setMessage("Please wait ...")
                dialog.setCanceledOnTouchOutside(false)
                dialog.show()
                val handler = Handler()

                handler.postDelayed({
                    dialog.dismiss()

                }, 1000)

                toast(str)
            }
        }
    }

    lateinit var dialog : ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputButton_main.setOnClickListener(this)
        dialog = ProgressDialog(this,R.style.AppCompatAlertDialogStyle)

    }
}
