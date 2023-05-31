package com.thoughtworks.ark.particle.presenter.model

import com.yunlong.particle.proto.AlertComponent

sealed class Action {
    data class ShowAlert(val dialog: AlertComponent) : Action()
    data class NavigateTo(val route: String) : Action()
    object OpenDrawer : Action()
    object HideDrawer : Action()
    object NavigateUp : Action()
}
