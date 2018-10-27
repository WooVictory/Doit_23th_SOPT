package dmzing.workd.seminar3_23th.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dmzing.workd.seminar3_23th.Main2Activity
import dmzing.workd.seminar3_23th.MainActivity
import dmzing.workd.seminar3_23th.R
import dmzing.workd.seminar3_23th.adapter.KakaoTalkRoomAdapter
import dmzing.workd.seminar3_23th.data.KakaoTalkRommData
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.main_fragment.view.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

/**
 * Created by VictoryWoo
 */
class MainFragment : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v!!) {
            v!!->{
                val index = main_rv.getChildAdapterPosition(v!!)
                toast("${itemsList[index].title} 방입니다.")
            }
        }
    }

    lateinit var kakaoTalkRoomAdapter: KakaoTalkRoomAdapter
    lateinit var itemsList: ArrayList<KakaoTalkRommData>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.main_fragment, container, false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setting()
    }

    fun setting() {
        // 변경되는 작업이 적은 곳에서 ArrayList를 사용한다
        itemsList = ArrayList()
        itemsList.add(KakaoTalkRommData("[DoIT 안드로이드 파트]", "인터뷰 하자~!!", 53, "오후 6:33"))
        itemsList.add(KakaoTalkRommData("[DoIT 서버 파트]", "서버 공부하세요~!!", 57, "오후 4:33"))
        itemsList.add(KakaoTalkRommData("[DoIT 디자인 파트]", "제플린 씁시다.!", 30, "오후 9:10"))
        itemsList.add(KakaoTalkRommData("[DoIT 안드로이드 파트]", "인터뷰 하자~!!", 53, "오후 6:33"))
        itemsList.add(KakaoTalkRommData("[DoIT 안드로이드 파트]", "인터뷰 하자~!!", 53, "오후 6:33"))
        itemsList.add(KakaoTalkRommData("23기버디버디 조", "술 마시자~!!", 10, "오후 6:33"))
        itemsList.add(KakaoTalkRommData("[DoIT 안드로이드 파트]", "인터뷰 하자~!!", 53, "오후 6:33"))
        itemsList.add(KakaoTalkRommData("[DoIT 안드로이드 파트]", "인터뷰 하자~!!", 53, "오후 6:33"))
        itemsList.add(KakaoTalkRommData("23기버디버디 조", "술 마시자~!!", 10, "오후 6:33"))
        itemsList.add(KakaoTalkRommData("[DoIT 안드로이드 파트]", "인터뷰 하자~!!", 53, "오후 6:33"))
        itemsList.add(KakaoTalkRommData("[DoIT 안드로이드 파트]", "인터뷰 하자~!!", 53, "오후 6:33"))
        itemsList.add(KakaoTalkRommData("23기버디버디 조", "술 마시자~!!", 10, "오후 6:33"))

        kakaoTalkRoomAdapter = KakaoTalkRoomAdapter(context!!, itemsList)
        main_rv.adapter = kakaoTalkRoomAdapter
        main_rv.layoutManager = LinearLayoutManager(context!!)
    }
}