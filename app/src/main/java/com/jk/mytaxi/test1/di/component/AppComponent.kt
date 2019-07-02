package com.jk.mytaxi.test1.di.component
import com.jk.mytaxi.test1.di.module.NetworkModule
import com.jk.mytaxi.test1.viewmodel.DataViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ (NetworkModule::class)])
interface AppComponent {
    fun inject(auth: DataViewModel)
    fun inject(net: NetworkModule)

}