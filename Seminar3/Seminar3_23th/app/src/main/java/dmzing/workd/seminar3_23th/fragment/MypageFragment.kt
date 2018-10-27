package dmzing.workd.seminar3_23th.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dmzing.workd.seminar3_23th.R

/**
 * Created by VictoryWoo
 */
class MypageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.mypage_fragment, container, false)
        return view
    }
}