package com.rizki.crud_data_mysql_mi2b.service

import com.rizki.crud_data_mysql_mi2b.respon.ResponseBerita
import retrofit2.Call
import retrofit2.http.GET

interface CrudService {
    @GET("getBerita.php")
    fun getAllBerita():Call<ResponseBerita>
}