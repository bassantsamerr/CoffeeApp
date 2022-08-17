package com.example.example

import com.google.gson.annotations.SerializedName


data class LoginResponse (

  @SerializedName("token"    ) var token    : String? = null,
  @SerializedName("userName" ) var userName : String? = null,
  @SerializedName("email"    ) var email    : String? = null

)