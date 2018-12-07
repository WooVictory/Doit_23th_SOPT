package app.woovictory.seminar6_23th.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import app.woovictory.seminar6_23th.R
import app.woovictory.seminar6_23th.SharedPreferenceController
import app.woovictory.seminar6_23th.model.post.PostLoginResponse
import app.woovictory.seminar6_23th.network.ApplicationController
import app.woovictory.seminar6_23th.network.NetworkService
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v!!) {
            btn_main_act_sign_up -> {
                startActivity<SignUpActivity>()
            }
            btn_main_act_log_in -> {
                postLogin()
            }
        }
    }

    fun init() {
        btn_main_act_sign_up.setOnClickListener(this)
        btn_main_act_log_in.setOnClickListener(this)
        networkService = ApplicationController.instance.networkService
    }

    lateinit var networkService: NetworkService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
    }

    fun postLogin() {
        var jsonObject = JSONObject()
        jsonObject.put("email",et_main_act_email.text.toString())
        jsonObject.put("password",et_main_act_pw.text.toString())

        var gsonObject = JsonParser().parse(jsonObject.toString()).asJsonObject
        var loginResponse = networkService.postLogin("application/json",gsonObject)
        loginResponse.enqueue(object : Callback<PostLoginResponse>{
            override fun onFailure(call: Call<PostLoginResponse>, t: Throwable) {
                Log.v("454 woo f",t.message)
            }

            override fun onResponse(call: Call<PostLoginResponse>, response: Response<PostLoginResponse>) {
                if(response.isSuccessful){
                    toast(response.body()!!.message)
                    SharedPreferenceController.setAuthorization(this@LoginActivity, response.body()!!.data.token)
                    startActivity<BoardActivity>()
                    finish()
                    Log.v("454 woo s",response.body()!!.message)
                }
            }
        })

    }
}
