package com.afkoders.uptechackathon.presentation.main.groupieAdapter

import com.afkoders.uptechackathon.R
import com.afkoders.uptechackathon.data.models.EmployeeModel
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.employee_list_item.*

/**
 * Created by Kalevych Oleksandr on 9/14/20.
 */

class GroupieAdapterModel (private val employeeModel: EmployeeModel) : Item() {

    override fun getLayout() = R.layout.employee_list_item

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.tvName.text  = employeeModel.employeeName
        viewHolder.tvAge.text = employeeModel.employeeAge
    }
}