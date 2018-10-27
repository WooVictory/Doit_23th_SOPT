package dmzing.workd.seminar3_23th

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import dmzing.workd.seminar3_23th.adapter.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // lateinit var fragmentStatePagerAdapter: FragmentStatePagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        settingBottomView()
    }

    fun settingBottomView() {
        main_viewpager.adapter = FragmentStatePagerAdapter(supportFragmentManager, 3)
        main_viewpager.offscreenPageLimit = 3

        main_tab.setupWithViewPager(main_viewpager)

        val bottom_layout: View = this.layoutInflater.inflate(R.layout.main_bottom_tab, main_viewpager, false)

        main_tab.getTabAt(0)!!.customView = bottom_layout.findViewById(R.id.btn_bottom_navi_main_tab) as RelativeLayout
        main_tab.getTabAt(1)!!.customView = bottom_layout.findViewById(R.id.btn_bottom_navi_map_tab) as RelativeLayout
        main_tab.getTabAt(2)!!.customView = bottom_layout.findViewById(R.id.btn_bottom_navi_my_page_tab) as RelativeLayout

    }
}
