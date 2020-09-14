package com.afkoders.uptechackathon.presentation.main

import com.afkoders.uptechackathon.data.models.EmployeeModel
import com.afkoders.uptechackathon.presentation.base.BasePresenter
import com.afkoders.uptechackathon.presentation.base.BaseView

interface MainFragmentAgreement {
    interface View : BaseView {
        fun mainDataLoaded(data: List<EmployeeModel>)
        fun showError(errorText: String)
    }

    interface Presenter : BasePresenter<View> {
        fun loadMainData()
    }
}