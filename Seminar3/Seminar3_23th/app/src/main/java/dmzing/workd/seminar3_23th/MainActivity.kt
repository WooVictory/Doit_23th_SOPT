package dmzing.workd.seminar3_23th

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import dmzing.workd.seminar3_23th.adapter.FragmentStatePagerAdapter
import dmzing.workd.seminar3_23th.adapter.KakaoTalkRoomAdapter
import dmzing.workd.seminar3_23th.data.KakaoTalkRommData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // lateinit var fragmentStatePagerAdapter: FragmentStatePagerAdapter
    lateinit var kakaoTalkRoomAdapter: KakaoTalkRoomAdapter
    lateinit var itemsList : ArrayList<KakaoTalkRommData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        settingBottomView()
        itemsList =  ArrayList()
        itemsList.add(KakaoTalkRommData("[DoIT 안드로이드 파트]","인터뷰 하자~!!", 53,"오후 6:33"))
        itemsList.add(KakaoTalkRommData("[DoIT 서버 파트]","서버 공부하세요~!!", 57,"오후 4:33"))
        itemsList.add(KakaoTalkRommData("[DoIT 디자인 파트]","제플린 씁시다.!", 30,"오후 9:10"))
        itemsList.add(KakaoTalkRommData("[DoIT 안드로이드 파트]","인터뷰 하자~!!", 53,"오후 6:33"))
        itemsList.add(KakaoTalkRommData("[DoIT 안드로이드 파트]","인터뷰 하자~!!", 53,"오후 6:33"))
        itemsList.add(KakaoTalkRommData("[DoIT 안드로이드 파트]","인터뷰 하자~!!", 53,"오후 6:33"))

        kakaoTalkRoomAdapter = KakaoTalkRoomAdapter(this, itemsList)



    }

    /*FIXME
    * tab layout 커스텀으로 할 수 있는 방법!
    * 이쁘게 잘 들어감
    * */
    fun settingBottomView() {
        main_viewpager.adapter = FragmentStatePagerAdapter(supportFragmentManager, 3)
        main_viewpager.offscreenPageLimit = 5

        main_tab.setupWithViewPager(main_viewpager)

        val bottom_layout: View = this.layoutInflater.inflate(R.layout.main_bottom_tab, main_viewpager, false)

        main_tab.getTabAt(0)!!.customView = bottom_layout.findViewById(R.id.btn_bottom_navi_main_tab) as RelativeLayout
        main_tab.getTabAt(1)!!.customView = bottom_layout.findViewById(R.id.btn_bottom_navi_map_tab) as RelativeLayout
        main_tab.getTabAt(2)!!.customView = bottom_layout.findViewById(R.id.btn_bottom_navi_my_page_tab) as RelativeLayout

    }
}
