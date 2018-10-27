package dmzing.workd.seminar3_23th.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import dmzing.workd.seminar3_23th.R
import dmzing.workd.seminar3_23th.data.KakaoTalkRommData
import java.util.zip.Inflater

/**
 * Created by VictoryWoo
 */
class KakaoTalkRoomAdapter(val context : Context, var items : ArrayList<KakaoTalkRommData>) : RecyclerView.Adapter<KakaoTalkRoomAdapter.KakaoTalkViewHolder>(){

    // ArrayList는 중간에 있는 data를 삭제할 때 cost가 크다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KakaoTalkViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.kakao_room_data_item, parent, false)
        return KakaoTalkViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: KakaoTalkViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.content.text = items[position].content
        holder.count.text = items[position].person_cont.toString()
        holder.time.text = items[position].time


    }

    /*FIXME
    * Adapter 내부에 inner class 혹은 중첩 클래스를 만들 수 있다.
    * 중첩 클래스 : 정적(static).
    * inner 클래스 : 정적이 아님
    * */

    inner class KakaoTalkViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val title : TextView = itemView.findViewById(R.id.tv_rv_item_kakao_talk_room_title)
        var content : TextView = itemView.findViewById(R.id.tv_rv_item_kakao_talk_room_content)
        var count : TextView = itemView.findViewById(R.id.tv_rv_item_kakao_talk_room_person_cnt)
        var time : TextView = itemView.findViewById(R.id.tv_rv_item_kakao_talk_room_time)


    }

}