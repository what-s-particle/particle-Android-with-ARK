package com.thoughtworks.ark.particle

import com.thoughtworks.ark.particle.presenter.model.ParticleAction

/**
 * the Contract plays a crucial role in defining the agreement (Contract) between the View and Presenter, thus promoting separation of concerns, loose coupling, testability, and other design principles.

In a Contract, you typically define the following:

View interface: Defines the behavior and state of the View, such as displaying data, showing loading state, showing errors, etc.
Presenter interface: Defines the behavior and state of the Presenter, such as loading data, refreshing data, handling user interactions, etc.
Actions: Defines the events that are triggered by user or system interactions, such as button clicks, network requests, response processing, etc.
State: Defines the state of the View, such as data loading, data loaded, data loading error, etc.

 */
class ParticleContract {
    fun createContract(onAction: (ParticleAction) -> Unit): ParticleContract = apply {
        this.onAction = onAction
    }

    lateinit var onAction: (ParticleAction) -> Unit
}
