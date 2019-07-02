package com.jk.mytaxi.test1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jk.mytaxi.TaxiApplication
import com.jk.mytaxi.test1.adapter.MapAdapter
import com.jk.mytaxi.test1.data.Item
import com.jk.mytaxi.test1.data.PoiList
import com.jk.mytaxi.test1.network.IApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DataViewModel : ViewModel() {

    @Inject
    lateinit var iApi: IApi


    init {
        TaxiApplication.appComponent.inject(this)
    }

    val liveData: MutableLiveData<Item> =
        MutableLiveData()
    var data: ArrayList<PoiList> = ArrayList()

    var adapter = MapAdapter(data)


    fun getPoiList() {

        // do async operation to fetch users and use postValue() method
        iApi.getTimeZoneFromLatLong("53.694865", "9.757589", "53.394655", "10.099891")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ abc ->

                liveData.postValue( abc)

            }

            )
            { e ->
                run {

                    e.printStackTrace()

                }
            }


    }


}