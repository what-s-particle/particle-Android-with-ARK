package com.thoughtworks.ark.particle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thoughtworks.ark.core.network.entity.Result
import com.thoughtworks.ark.particle.ParticleContract
import com.thoughtworks.ark.particle.data.ParticleRepository
import com.thoughtworks.ark.particle.presenter.model.ParticleAction
import com.yunlong.particle.proto.Particle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ParticleViewModel(private val repository: ParticleRepository) : ViewModel() {

    private val _treeState: MutableStateFlow<Particle?> = MutableStateFlow(null)
    val treeState: StateFlow<Particle?> = _treeState

    val contract: ParticleContract by lazy {
        ParticleContract().createContract(
            ::onAction,
        )
    }

    fun loadData() {
        // TODO load from server and local?
        viewModelScope.launch {
            repository.getInitialView().collect {
                when (it) {
                    is Result.Success -> {
                        _treeState.emit(it.data)
                    }
                    else -> {
                        "Error"
                    }
                }
            }
        }
    }

    private fun onAction(particleAction: ParticleAction) {

    }
}
