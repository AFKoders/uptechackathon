package com.afkoders.uptechackathon.presentation.main

data class FragmentCacheModel(
    var isProgress: Boolean,
    var failed: Boolean,
    var data: MutableList<String>
)
