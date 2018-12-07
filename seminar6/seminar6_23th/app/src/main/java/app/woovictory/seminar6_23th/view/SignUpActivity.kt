package app.woovictory.seminar6_23th.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import app.woovictory.seminar6_23th.BaseModel
import app.woovictory.seminar6_23th.R
import app.woovictory.seminar6_23th.model.post.PostSignUp
import app.woovictory.seminar6_23th.model.post.PostSignUpResponse
import app.woovictory.seminar6_23th.network.ApplicationController
import app.woovictory.seminar6_23th.network.NetworkService
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!){
            btn_sign_up_act_complete->{
                postSignUp()
            }
        }
    }

    fun init(){
        btn_sign_up_act_complete.setOnClickListener(this)
        networkService = ApplicationController.instance.networkService

    }

    lateinit var networkService: NetworkService
    private val CONTENT_TYPE : String = "application/json"
    lateinit var user : PostSignUp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        init()
    }

    fun postSignUp(){
        var jsonObject = JSONObject()
        jsonObject.put("name",et_sign_up_act_name.text.toString())
        jsonObject.put("email",et_sign_up_act_email.text.toString())
        jsonObject.put("password",et_sign_up_act_pw.text.toString())
        jsonObject.put("part",et_sign_up_act_part.text.toString())

        var gsonObject = JsonParser().parse(jsonObject.toString()).asJsonObject
        Log.v("332 woo json:",jsonObject.toString())
        Log.v("332 woo json:",gsonObject.toString())
        user = PostSignUp(et_sign_up_act_name.text.toString(), et_sign_up_act_email.text.toString()
            ,et_sign_up_act_pw.text.toString(),et_sign_up_act_part.text.toString())

        var signUpResponse = networkService.postSignUp("application/json", gsonObject)
        Log.v("332 woo c:","click")
        signUpResponse.enqueue(object : Callback<PostSignUpResponse>{
            override fun onFailure(call: Call<PostSignUpResponse>, t: Throwable) {
                Log.v("332 woo f:",t!!.localizedMessage)
            }

            override fun onResponse(call: Call<PostSignUpResponse>, response: Response<PostSignUpResponse>) {
                if(response!!.isSuccessful){
                    Log.v("332 woo s:",response!!.body()!!.message)
                    finish()
                }else{
                    Log.v("332 woo el:",response!!.body()!!.message)
                }
            }

        })
    }
}
