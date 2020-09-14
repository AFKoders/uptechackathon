package com.afkoders.uptechackathon.presentation.main

import android.os.Bundle
import com.afkoders.uptechackathon.R
import com.afkoders.uptechackathon.data.models.EmployeeModel
import com.afkoders.uptechackathon.presentation.base.BaseFragmentImpl
import com.afkoders.uptechackathon.presentation.main.groupieAdapter.GroupieAdapterModel
import com.afkoders.uptechackathon.utils.extensions.show
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment :
    BaseFragmentImpl<MainFragmentAgreement.Presenter, MainFragmentAgreement.View>(R.layout.fragment_main),
    MainFragmentAgreement.View {

    private var adapter: GroupAdapter<GroupieViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = GroupAdapter()

    }

    override fun onDestroy() {
        super.onDestroy()
        adapter = null
    }


    override fun setupInputs() {
        rvResult.adapter = adapter
        btnMain.bindClick { presenter.loadMainData() }
    }

    override fun mainDataLoaded(data: List<EmployeeModel>) {
        btnMain.text = data[0].employeeName
        adapter?.addAll(data.map { GroupieAdapterModel(it) })
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
