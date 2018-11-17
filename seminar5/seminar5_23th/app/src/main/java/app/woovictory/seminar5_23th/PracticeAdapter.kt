package app.woovictory.seminar5_23th

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by VictoryWoo
 */
class PracticeAdapter(var items : ArrayList<PracticeData>, var context : Context)
    : RecyclerView.Adapter<PracticeAdapter.PracticeViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PracticeViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_practice_mypage, parent,false)
        return PracticeViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: PracticeViewHolder, position: Int) {

        Glide.with(context).load(items[position]).into(holder.image)

    }

    inner class PracticeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var image : ImageView = itemView.findViewById(R.id.image_item)
    }
}