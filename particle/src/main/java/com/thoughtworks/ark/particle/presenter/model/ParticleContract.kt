package com.thoughtworks.ark.particle.presenter.model

/**
 * the Contract plays a crucial role in defining the agreement (Contract) between the View and Presenter, thus promoting separation of concerns, loose coupling, testability, and other design principles.
 * In a Contract, you typically define the following:
 * interactions generally refer to various `operations` and `feedback` that users perform on the page. `Operations` include clicking, sliding, inputting, zooming, rotating, etc., and `feedback` includes invisible form submissions, state changes on the page, permission request prompts, and animations, etc.
 */
class ParticleContract {
    lateinit var onAction: (Action) -> Unit
    lateinit var onEvent: (Event) -> Unit

    fun createContract(
        onAction: (Action) -> Unit,
        onEvent: (Event) -> Unit
    ): ParticleContract = apply {
        this.onAction = onAction
        this.onEvent = onEvent
    }
}
