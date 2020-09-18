package com.afkoders.uptechackathon.presentation.login

import com.afkoders.uptechackathon.presentation.base.BasePresenter
import com.afkoders.uptechackathon.presentation.base.BaseView
import com.afkoders.uptechackathon.presentation.login.model.User

interface LoginAgreement {
    interface View: BaseView {

    }

    interface Presenter: BasePresenter<View> {
        fun saveUserToPrefs(user: User): Boolean
    }
}