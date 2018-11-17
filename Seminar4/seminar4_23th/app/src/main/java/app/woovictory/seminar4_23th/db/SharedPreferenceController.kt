package app.woovictory.seminar4_23th.db

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by VictoryWoo
 */
/*TODO
*
*  생성자를 만들 수 없음
 companion object는 생성자를 만들 수 있고
 같은 클래스 내에서 공유할 수 있는 데이터를 싱글톤으로 만들 수 있음
* */
object SharedPreferenceController {

    private val USER_NAME: String = "user_name"
    private val USER_ID: String = "user_id"
    private val USER_PW: String = "user_pw"


    /*FIXME
    * setUserId : SharedPreference를 통한 데이터의 저장
    * getUserId : SharedPreference를 통한 데이터 꺼내오기
    * */
    fun setUserId(context: Context, input_id: String) {
        val preference: SharedPreferences = context.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preference.edit()
        editor.putString(USER_ID, input_id)
        editor.commit()
    }

    fun setUserPw(context: Context, input_pw: String) {
        val preference: SharedPreferences = context.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preference.edit()
        editor.putString(USER_PW, input_pw)
        editor.commit()
    }


    fun getUserId(context: Context): String {
        val preference: SharedPreferences = context.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        return preference.getString(USER_ID, "")
    }

    fun getUserPw(context: Context): String {
        val preference : SharedPreferences = context.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        return preference.getString(USER_PW,"")
    }


    fun clearUserSharedPreference(context: Context) {
        val preference: SharedPreferences = context.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preference.edit()
        editor.clear()
        editor.commit()

    }

}
