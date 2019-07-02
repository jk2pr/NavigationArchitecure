package com.jk.mytaxi.test1.network

import com.jk.mytaxi.test1.data.Item
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface IApi {

    // @GET("maps/api/timezone/json")
    @GET(" ")
    //fun getIp(@Query("mime") number: String): Observable<User>;
    fun getTimeZoneFromLatLong(
        @Query("p1Lat") p1Lat: String,
        @Query("p1Lon") p1Lon: String,
        @Query("p2Lat") p2Lat: String,
        @Query("p2Lon") p2Lon: String
        //  @Query("timestamp") timestamp: String,
    ): Observable<Item>

}
