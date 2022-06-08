package com.codeclinic.codeassignment.data.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class DataListModel(
    @SerializedName("urls")
    @Expose
    var urls: Urls? = null
)
