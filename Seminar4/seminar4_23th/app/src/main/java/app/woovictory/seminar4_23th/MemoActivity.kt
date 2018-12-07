package app.woovictory.seminar4_23th

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import app.woovictory.seminar4_23th.adapter.MemoAdapter
import app.woovictory.seminar4_23th.data.MemoData
import app.woovictory.seminar4_23th.db.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_memo.*
import org.jetbrains.anko.startActivity

class MemoActivity : AppCompatActivity(),View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!){
            btn_memo_act_logout->{
                SharedPreferenceController.clearUserSharedPreference(this)
                startActivity<MainActivity>()
                finish()
            }
            btn_memo_act_add_memo->{
                if(et_memo_act_title.text.toString().isNotEmpty() && et_memo_act_content.text.toString().isNotEmpty()){

                    val position = memoAdapter.items.size
                    val title : String = et_memo_act_title.text.toString()
                    val content : String = et_memo_act_content.text.toString()

                    memoAdapter.addNewItem(MemoData(title,content))
                    //memoAdapter.items.add(MemoData(title, content))
                    //memoAdapter.notifyItemInserted(position)
                }
            }
        }
    }

    fun init(){
        btn_memo_act_logout.setOnClickListener(this)
        btn_memo_act_add_memo.setOnClickListener(this)

    }

    lateinit var memoAdapter: MemoAdapter


    // 변수를 쓰기 전까지 메모리 할당이 안되고 변수를 쓰는 순간 메모리 할당이 된다.
    val item_list : ArrayList<MemoData> by lazy{
        ArrayList<MemoData>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo)
        init()

        // 이렇게 item_list를 사용하는 순간에 메모리 할당이 된다.
        memoAdapter = MemoAdapter(item_list, this)
        rv_memo_act_memo_list.adapter = memoAdapter
        rv_memo_act_memo_list.layoutManager = LinearLayoutManager(this)
        swipeRefresh.setOnRefreshListener {
            /*FIXME
            * 서버 재통신 로직을 넣으면 된다.
            * */

            swipeRefresh.isRefreshing = false
        }

    }
}
