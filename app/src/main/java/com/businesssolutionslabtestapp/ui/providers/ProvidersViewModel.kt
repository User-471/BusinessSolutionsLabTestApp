package com.businesssolutionslabtestapp.ui.providers

import androidx.lifecycle.MutableLiveData
import com.businesssolutionslabtestapp.api.service.BSLabTestService
import com.businesssolutionslabtestapp.model.Provider
import com.businesssolutionslabtestapp.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.kodein.di.generic.instance

class ProvidersViewModel: BaseViewModel<ProvidersViewModel>() {

    private val bsLabTestService: BSLabTestService by instance()

    val errorMessageData = MutableLiveData<String>()
    val loadingLiveData = MutableLiveData<Boolean>()

    fun getProviders(): MutableLiveData<ArrayList<Provider>> {

        val data = MutableLiveData<ArrayList<Provider>>()

        bsLabTestService.getProviders()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {  loadingLiveData.value = true }
            .doAfterTerminate { loadingLiveData.value = false }
            .subscribeBy(onSuccess = {
                data.value = it.providers
            }, onError = {
                errorMessageData.value = it.message
            })

        return data
    }
}