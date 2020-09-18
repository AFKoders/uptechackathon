package com.afkoders.uptechackathon.presentation.login

import android.util.Log
import com.afkoders.uptechackathon.data.prefs.AppPrefs
import com.afkoders.uptechackathon.presentation.base.BasePresenterImpl
import com.afkoders.uptechackathon.presentation.login.model.User
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val appPrefs: AppPrefs
) :
    BasePresenterImpl<String, LoginAgreement.View>(),
    LoginAgreement.Presenter {


    override fun saveUserToPrefs(user: User): Boolean {
        appPrefs.putUser(user)

        return true
    }
}