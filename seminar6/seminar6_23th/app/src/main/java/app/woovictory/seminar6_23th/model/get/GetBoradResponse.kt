package app.woovictory.seminar6_23th.model.get

/**
 * Created by VictoryWoo
 */
data class GetBoradList(
    var status: String,
    var message: String,
    var data: ArrayList<BoardData>
)


data class BoardData(
    val b_id: Int,
    val b_title: String,
    val b_contents: String, val b_date: String,
    val u_id: Int,
    val b_like: Int,
    val b_photo: String,
    val auth: Boolean,
    var like: Boolean
)