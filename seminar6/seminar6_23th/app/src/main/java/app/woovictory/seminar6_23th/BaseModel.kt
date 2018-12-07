package app.woovictory.seminar6_23th

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by VictoryWoo
 */
open class BaseModel (
    @SerializedName("status")
    @Expose
    open var status : String?=null,
    @SerializedName("message")
    @Expose
    open var message : String?=null
)
