package app.woovictory.seminar6_23th.view

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import app.woovictory.seminar6_23th.R
import app.woovictory.seminar6_23th.model.post.PostBoardWriteResponse
import app.woovictory.seminar6_23th.network.ApplicationController
import app.woovictory.seminar6_23th.network.NetworkService
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_write.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.InputStream

class WriteActivity : AppCompatActivity() {
    val REQUEST_CODE_SELECT_IMAGE: Int = 1004
    private var mImage: MultipartBody.Part? = null

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)
        setOnBtnClickListener()
    }

    private fun setOnBtnClickListener() {
        btn_write_act_show_album.setOnClickListener {
            //앨범 여는 로직
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = android.provider.MediaStore.Images.Media.CONTENT_TYPE
            intent.data = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            startActivityForResult(intent, REQUEST_CODE_SELECT_IMAGE)
        }
        btn_write_act_complete.setOnClickListener {
            getWriteBoardResponse()
        }
    }
    //앨범에서 사진을 선택했을때 실행되는 메소드
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                data?.let {
                    var seletedPictureUri = it.data
                    val options = BitmapFactory.Options()
                    val inputStream: InputStream = contentResolver.openInputStream(seletedPictureUri)
                    val bitmap = BitmapFactory.decodeStream(inputStream, null, options)
                    val byteArrayOutputStream = ByteArrayOutputStream()
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 20, byteArrayOutputStream)
                    val photoBody = RequestBody.create(MediaType.parse("image/jpg"), byteArrayOutputStream.toByteArray())
                    //첫번째 매개변수 String을 꼭! 꼭! 서버 API에 명시된 이름으로 넣어주세요!!!
                    mImage = MultipartBody.Part.createFormData("photo", File(seletedPictureUri.toString()).name, photoBody)
                    //Glide을 사진 URI를 ImageView에 넣은 방식. 외부 URI가 아니라 굳이 Glide을 안써도 되지만 ㅎㅎ!
                    Glide.with(this@WriteActivity).load(seletedPictureUri).thumbnail(0.1f).into(iv_write_act_choice_image)
                }
            }
        }
    }
    private fun getWriteBoardResponse() {
        val input_title = et_write_act_title.text.toString()
        val input_contents = et_write_act_content.text.toString()
        if (input_title.isNotEmpty() && input_contents.isNotEmpty()) {
            //Multipart 형식은 String을 RequestBody 타입으로 바꿔줘야 합니다!
            val token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJEb0lUU09QVCIsInVzZXJfaWR4Ijo2N30.WLzMdA7k0bWIGUI_OGIu3FVmS_e8aNxLqPbmqzzayeY"
                /*SharedPreferenceController.getAuthorization(this)*/
            var title = RequestBody.create(MediaType.parse("text/plain"), input_title)
            var contents = RequestBody.create(MediaType.parse("text/plain"), input_contents)

            val postWriteBoardResponse = networkService.postBoard(token, title, contents, mImage)

            postWriteBoardResponse.enqueue(object : Callback<PostBoardWriteResponse> {
                override fun onFailure(call: Call<PostBoardWriteResponse>, t: Throwable) {
                    Log.e("write fail", t.toString())
                }

                override fun onResponse(call: Call<PostBoardWriteResponse>, response: Response<PostBoardWriteResponse>) {
                    if (response.isSuccessful) {
                        toast(response.message())
                        finish()
                    }
                }
            })
        }
    }
}