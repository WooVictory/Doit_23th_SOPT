package app.woovictory.seminar6_23th.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import app.woovictory.seminar6_23th.R
import app.woovictory.seminar6_23th.model.get.BoardData
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * Created by VictoryWoo
 */
class BoardRecyclerViewAdapter(val ctx: Context, val dataList: ArrayList<BoardData>) :
    RecyclerView.Adapter<BoardRecyclerViewAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.item_borad_list, parent, false)
        return Holder(view)
    }
    override fun getItemCount(): Int = dataList.size
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = dataList[position].b_title
        holder.like_cnt.text = dataList[position].b_like.toString()
        holder.date.text = dataList[position].b_date

        val requestOptions = RequestOptions()
        Glide.with(ctx)
            .setDefaultRequestOptions(requestOptions)
            .load(dataList[position].b_photo)
            .thumbnail(0.5f)
            .into(holder.image)
    }
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_rv_item_board_title) as TextView
        val like_cnt: TextView = itemView.findViewById(R.id.tv_rv_item_board_like_cnt) as TextView
        val date: TextView = itemView.findViewById(R.id.tv_rv_item_board_date) as TextView
        val image: ImageView = itemView.findViewById(R.id.iv_rv_item_board_image) as ImageView
    }
}
