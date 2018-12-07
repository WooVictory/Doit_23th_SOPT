package app.woovictory.seminar6_23th.model.post

/**
 * Created by VictoryWoo
 */
data class PostLoginResponse (
    var status : Int,
    var message : String,
    var data : LoginResponse
)

data class LoginResponse(
    var token : String
)