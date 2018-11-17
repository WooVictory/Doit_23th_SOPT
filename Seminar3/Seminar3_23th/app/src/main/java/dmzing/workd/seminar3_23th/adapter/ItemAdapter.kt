package dmzing.workd.seminar3_23th.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import dmzing.workd.seminar3_23th.R
import dmzing.workd.seminar3_23th.data.ItemData

/**
 * Created by VictoryWoo
 */
class ItemAdapter(var items : ArrayList<ItemData>, var context : Context)
    : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    lateinit var onItemClick : View.OnClickListener

    fun onItemClickListener(l : View.OnClickListener){
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        view.setOnClickListener(onItemClick)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.cnt.text = items[position].count.toString()

        holder.heart.setOnClickListener {
            if(!items[position].isLike)
                holder.heart.visibility = View.INVISIBLE
            else
                holder.heart.visibility = View.VISIBLE
        }
    }

    inner class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var cnt : TextView = itemView.findViewById(R.id.countItem)
        var heart : ImageView = itemView.findViewById(R.id.heartItem)
    }
}