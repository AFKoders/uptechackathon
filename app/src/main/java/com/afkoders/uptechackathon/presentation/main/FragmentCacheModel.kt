package com.afkoders.uptechackathon.presentation.main

import com.afkoders.uptechackathon.data.models.EmployeeModel

data class FragmentCacheModel(
    var isProgress: Boolean,
    var failed: Boolean,
    var data: MutableList<EmployeeModel>
)
