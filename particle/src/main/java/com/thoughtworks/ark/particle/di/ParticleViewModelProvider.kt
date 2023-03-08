package com.thoughtworks.ark.particle.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.thoughtworks.ark.particle.data.ParticleRepository
import com.thoughtworks.ark.particle.ui.ParticleViewModel

class ParticleViewModelProvider(
    private val repository: ParticleRepository,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ParticleViewModel::class.java)) {
            return ParticleViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
