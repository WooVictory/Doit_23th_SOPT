package app.woovictory.seminar4_23th.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import app.woovictory.seminar4_23th.R
import app.woovictory.seminar4_23th.data.MemoData
import java.lang.IndexOutOfBoundsException

/**
 * Created by VictoryWoo
 */
class MemoAdapter(var items: ArrayList<MemoData>, var context: Context) :
    RecyclerView.Adapter<MemoAdapter.MemoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_memo_list, parent, false)
        return MemoViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.content.text = items[position].content
        holder.whole.setOnClickListener {
            try {
                items.removeAt(position)
                notifyItemRemoved(position)
                // 범위가 바뀌었음을 알려줌
                // 해당 포지션이 없어졌고, 현재 아이탬의 size는 이것이다. 라고 하는 것임!
                notifyItemRangeChanged(position, items.size)
            } catch (e: IndexOutOfBoundsException) {
                e.printStackTrace()
            }

        }
    }


    // 아이템 추가하는 함수
    fun addNewItem(memoData: MemoData) {
        val position: Int = items.size
        items.add(memoData)
        notifyItemInserted(position)
    }

    inner class MemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.title_memo_item)
        var content: TextView = itemView.findViewById(R.id.content_memo_item)
        var whole: RelativeLayout = itemView.findViewById(R.id.btn_rv_item_memo_whole_box)
    }
}