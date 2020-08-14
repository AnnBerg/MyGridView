package com.example.mygridview.model

import android.media.Image
import java.io.Serializable

class MenuModel : Serializable {


    var name: String? = nullчвс         ссссс
    var img : Int? = null


    constructor(name: String?,img : Int?){
        this.name = name
        this.img = img


    }
}