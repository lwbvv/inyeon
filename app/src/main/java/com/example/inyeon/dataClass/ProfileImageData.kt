package com.example.inyeon.dataClass

import com.google.gson.annotations.SerializedName

data class ProfileImageData {

    @SerializedName("member_id")
    var memberId: String? = null

    @SerializedName("imagePath0")
    var imagePath0: String? = null

    @SerializedName("imagePath1")
    var imagePath1: String? = null

    @SerializedName("imagePath2")
    var imagePath2: String? = null

    @SerializedName("imagePath3")
    var imagePath3: String? = null

    @SerializedName("imagePath4")
    var imagePath4: String? = null


    constructor()
    
    constructor(
        memberId: String?,
        imagePath0: String?,
        imagePath1: String?,
        imagePath2: String?,
        imagePath3: String?,
        imagePath4: String?
    ) {
        this.memberId = memberId
        this.imagePath0 = imagePath0
        this.imagePath1 = imagePath1
        this.imagePath2 = imagePath2
        this.imagePath3 = imagePath3
        this.imagePath4 = imagePath4
    }
    


}