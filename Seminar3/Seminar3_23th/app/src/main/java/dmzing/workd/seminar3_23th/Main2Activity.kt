package dmzing.workd.seminar3_23th

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import dmzing.workd.seminar3_23th.adapter.ItemAdapter
import dmzing.workd.seminar3_23th.data.ItemData
import kotlinx.android.synthetic.main.activity_main2.*
import org.jetbrains.anko.toast

class Main2Activity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!){
            v!!->{
                var index = main2_rv.getChildAdapterPosition(v!!)
                toast("${itemList[index].count}")

            }
        }
    }


    lateinit var itemList : ArrayList<ItemData>
    lateinit var dataAdapter : ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        itemList = ArrayList()
        for(i in 0..10)
            itemList.add(ItemData((i+1),false))

        for(i in 10..20)
            itemList.add(ItemData((i+1),true))


        dataAdapter = ItemAdapter(itemList, this)
        dataAdapter.onItemClickListener(this)
        main2_rv.layoutManager = GridLayoutManager(this, 3)
        main2_rv.adapter = dataAdapter



    }
}
