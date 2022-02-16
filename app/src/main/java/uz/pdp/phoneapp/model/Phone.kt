package uz.pdp.phoneapp.model

import java.io.Serializable

class Phone:Serializable {
    var id: Int? =null
    var phone: String? = null
    var phone_type: String? = null
    var features: String? = null

    constructor(id: Int,phone: String, phone_type: String,features: String){
        this.id = id
        this.phone = phone
        this.phone_type = phone_type
        this.features = features
    }
    constructor(phone: String, phone_type: String,features: String){
        this.phone = phone
        this.phone_type = phone_type
        this.features = features
    }
}