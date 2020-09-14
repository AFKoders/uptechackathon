package com.afkoders.uptechackathon.presentation.main

import com.afkoders.uptechackathon.data.mainRepository.MainRepository
import com.afkoders.uptechackathon.presentation.base.BasePresenterImpl
import javax.inject.Inject


class MainFragmentPresenter @Inject constructor(private val mainRepository: MainRepository) :
    BasePresenterImpl<FragmentCacheModel, MainFragmentAgreement.View>(),
    MainFragmentAgreement.Presenter {

    override fun loadMainData() {
        mainRepository.getTestDataFromDataStorage()
            .bindLoading()
            .subscribe({
                model = FragmentCacheModel(
                    isProgress = false,
                    failed = false,
                    data = it.toMutableList()
                )
                view?.mainDataLoaded(it)
            }, {
                view?.showError(it.message ?: "no")
            }).disposeByBagProvider()
    }
}