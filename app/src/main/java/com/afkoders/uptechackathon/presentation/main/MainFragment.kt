package com.afkoders.uptechackathon.presentation.main

import com.afkoders.uptechackathon.R
import com.afkoders.uptechackathon.presentation.base.BaseFragmentImpl
import com.afkoders.uptechackathon.utils.extensions.show
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment :
    BaseFragmentImpl<MainFragmentAgreement.Presenter, MainFragmentAgreement.View>(R.layout.fragment_main),
    MainFragmentAgreement.View {
    override fun setupInputs() {
        btnMain.bindClick { presenter.loadMainData() }
    }

    override fun mainDataLoaded(data: List<String>) {
        btnMain.text = data[0]
    }

    override fun showError(errorText: String) {
        btnMain.text = errorText
    }

    override fun showLoading() {
        progress.show(parentFragmentManager)
    }

    override fun hideLoading() {
        progress.dismiss()
    }

    override fun returnThisHerePlease(): MainFragmentAgreement.View = this
}
