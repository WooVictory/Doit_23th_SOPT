package app.woovictory.seminar5_23th

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_practice.*

class PracticeActivity : AppCompatActivity() {

    lateinit var practiceAdapter: PracticeAdapter
    val item_list : ArrayList<PracticeData> by lazy {
        ArrayList<PracticeData>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice)

        for (i in 0..16){
            item_list.add(PracticeData(R.drawable.posts_image_01))
            item_list.add(PracticeData(R.drawable.posts_image_02))
            item_list.add(PracticeData(R.drawable.posts_image_03))
        }

        practiceAdapter = PracticeAdapter(item_list,this)
        practice_rv.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        practice_rv.adapter = practiceAdapter




    }


}
