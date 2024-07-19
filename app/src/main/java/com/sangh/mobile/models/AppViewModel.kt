package com.sangh.mobile.models

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State

class AppViewModel : ViewModel() {
    private val _viewMode = mutableStateOf(ViewMode.Regular)
    val viewMode: State<ViewMode> = _viewMode

    fun setViewMode(newViewMode: ViewMode) {
        _viewMode.value = newViewMode
    }
}

enum class ViewMode {
    Regular,
    SiteAdmin,
    Admin
}