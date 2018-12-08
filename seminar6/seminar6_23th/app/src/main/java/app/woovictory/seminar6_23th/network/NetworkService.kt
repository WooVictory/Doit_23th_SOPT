package app.woovictory.seminar6_23th.network

import app.woovictory.seminar6_23th.BaseModel
import app.woovictory.seminar6_23th.model.get.GetBoardList
import app.woovictory.seminar6_23th.model.post.PostBoardWriteResponse
import app.woovictory.seminar6_23th.model.post.PostLoginResponse
import app.woovictory.seminar6_23th.model.post.PostSignUp
import app.woovictory.seminar6_23th.model.post.PostSignUpResponse
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by VictoryWoo
 */
interface NetworkService {


    /*FIXME
    * 서버 통신에서 모든 서버 통신의 응답이 null인 값이 오면
    * 그냥 우리는 응답에 대한 데이터 클래스를 작성할 때 변수를 정의하지 않고,
    * 받지 않으면 된다.
    * */
    //@Headers("Content-type: application/json")
    @POST("/users")
    fun postSignUp(
        @Header("Content-Type") content_type: String,
        @Body() body: JsonObject
    ): Call<PostSignUpResponse>

    @POST("/login")
    fun postLogin(
        @Header("Content-Type") content_type: String,
        @Body body: JsonObject
    ): Call<PostLoginResponse>

    /*FIXME
    * Multipart에서는 String을 보낼 때 RequestBody로 보내야 한다
    * 그냥 String으로 보내면 String에 "" 이 붙어서 보내지기 때문에
    * RequestBody에 담아서 보내도록 한다.
    * */

    @Multipart
    @POST("/contents")
    fun postBoard(
        @Header("Authorization") token: String,
        @Part("title") title: RequestBody,
        @Part("contents") contents: RequestBody,
        @Part photo: MultipartBody.Part?
    ): Call<PostBoardWriteResponse>

    @GET("/contents")
    fun getBoard(
        @Header("Content-Type") content_type: String,
        @Query("offset") offset : Int,
        @Query("limit") limit : Int
    ) : Call<GetBoardList>
}