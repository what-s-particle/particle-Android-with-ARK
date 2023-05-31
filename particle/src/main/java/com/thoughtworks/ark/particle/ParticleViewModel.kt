package com.thoughtworks.ark.particle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thoughtworks.ark.core.network.entity.Result
import com.thoughtworks.ark.particle.data.ParticleRepository
import com.thoughtworks.ark.particle.presenter.dispatch.dispatch
import com.thoughtworks.ark.particle.presenter.model.Action
import com.thoughtworks.ark.particle.presenter.model.Event
import com.thoughtworks.ark.particle.presenter.model.ParticleContract
import com.yunlong.particle.proto.Particle
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.yunlong.particle.proto.Action as ParticleAction

class ParticleViewModel(private val repository: ParticleRepository) : ViewModel() {

    private val _content: MutableStateFlow<Particle?> = MutableStateFlow(null)
    val content: StateFlow<Particle?> = _content

    private val _action: MutableStateFlow<Action?> = MutableStateFlow(null)
    val action: StateFlow<Action?> = _action

    private val _contentChannel = Channel<Particle?>(5)
    private val _actionChannel = Channel<Action?>(5)

    init {
        scheduleContentUpdate()
        scheduleActionUpdate()
    }

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
                        onViewUpdate(it.data)
                    }
                    else -> {
                        "Error"
                    }
                }
            }
        }
    }

    private fun onAction(action: Action) = viewModelScope.launch {
        _actionChannel.trySend(action)
    }

    private fun onViewUpdate(state: Particle?) = viewModelScope.launch {
        _contentChannel.trySend(state)
    }

    private fun onEvent(event: Event) {
        when (event) {
            is Event.OnParticleEvent -> handleParticleEvent(event.actions)
        }

    }

    private fun handleParticleEvent(actions: List<ParticleAction>) {
        getContent()?.let { content ->
            updateContent {
                actions.dispatch(content, contract)
            }
        }
    }

    private fun scheduleContentUpdate() = viewModelScope.launch {
        var actionLastUpdateTime = 0L
        _actionChannel.consumeEach { value ->
            val currentTime = System.currentTimeMillis()
            val timeSinceLastUpdate = currentTime - actionLastUpdateTime
            actionLastUpdateTime = if (timeSinceLastUpdate >= 16L) {
                _action.emit(value)
                currentTime
            } else {
                delay(16L - timeSinceLastUpdate)
                _action.emit(value)
                System.currentTimeMillis()
            }
        }
    }

    private fun scheduleActionUpdate() = viewModelScope.launch {
        var viewLastUpdateTime = 0L
        _contentChannel.consumeEach { value ->
            val currentTime = System.currentTimeMillis()
            val timeSinceLastUpdate = currentTime - viewLastUpdateTime
            viewLastUpdateTime = if (timeSinceLastUpdate >= 16L) {
                _content.emit(value)
                currentTime
            } else {
                delay(16L - timeSinceLastUpdate)
                _content.emit(value)
                System.currentTimeMillis()
            }
        }
    }

    private fun getContent(): Particle? = _content.value

    private fun updateContent(updateBlock: (Particle?) -> Particle) {
        val currentContent = getContent()

        if (currentContent != null) {
            updateViewState {
                val newContent = updateBlock(currentContent)
                newContent
            }
        }
    }

    private fun updateViewState(updateBlock: (Particle?) -> Particle) {
        viewModelScope.launch {
            val currentViewState = getContent()
            val newViewState = updateBlock(currentViewState)

            if (newViewState != currentViewState) {
                _contentChannel.trySend(newViewState)
            }
        }
    }
}
