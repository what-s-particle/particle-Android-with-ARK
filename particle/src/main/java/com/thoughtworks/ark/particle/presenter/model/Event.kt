package com.thoughtworks.ark.particle.presenter.model

sealed class Event {
    data class NavigateTo(val route: String) : Event()
    object OpenDrawer : Event()
    object NavigateUp : Event()
}
