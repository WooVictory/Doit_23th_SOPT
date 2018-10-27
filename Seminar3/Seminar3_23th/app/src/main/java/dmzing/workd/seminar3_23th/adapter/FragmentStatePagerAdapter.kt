package dmzing.workd.seminar3_23th.adapter


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import dmzing.workd.seminar3_23th.fragment.MainFragment
import dmzing.workd.seminar3_23th.fragment.MapFragment
import dmzing.workd.seminar3_23th.fragment.MypageFragment

/**
 * Created by VictoryWoo
 */
class FragmentStatePagerAdapter(fm: FragmentManager, var fragmentCount: Int) : FragmentStatePagerAdapter(fm) {


    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return MainFragment()
            1 -> {
                val mapFragment = MapFragment()
                return mapFragment
            }
            2 -> return MypageFragment()
            else -> return null

        }
    }


    override fun getCount(): Int = fragmentCount

}