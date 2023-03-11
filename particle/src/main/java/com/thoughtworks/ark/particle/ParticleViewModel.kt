package com.thoughtworks.ark.particle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thoughtworks.ark.core.network.entity.Result
import com.thoughtworks.ark.particle.data.ParticleRepository
import com.thoughtworks.ark.particle.presenter.model.Action
import com.thoughtworks.ark.particle.presenter.model.Event
import com.thoughtworks.ark.particle.presenter.model.ParticleContract
import com.yunlong.particle.proto.Particle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ParticleViewModel(private val repository: ParticleRepository) : ViewModel() {

    private val _content: MutableStateFlow<Particle?> = MutableStateFlow(null)
    val content: StateFlow<Particle?> = _content

    private val _event: MutableStateFlow<Event?> = MutableStateFlow(null)
    val event: StateFlow<Event?> = _event

    val contract: ParticleContract by lazy {
        ParticleContract().createContract(
            ::onAction,
            ::onEvent,
        )
    }

    fun loadData() {
        // TODO load from server and local?
        viewModelScope.launch {
            repository.getParticle().collect {
                when (it) {
                    is Result.Success -> {
                        _content.emit(it.data)
                    }
                    else -> {
                        "Error"
                    }
                }
            }
        }
    }

    private fun onAction(particleAction: Action) {

    }

    private fun onEvent(event: Event) = viewModelScope.launch {
        _event.emit(event)
    }

}
