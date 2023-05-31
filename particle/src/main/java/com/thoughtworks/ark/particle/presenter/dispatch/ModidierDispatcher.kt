package com.thoughtworks.ark.particle.presenter.dispatch

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.thoughtworks.ark.particle.presenter.model.Event
import com.yunlong.particle.proto.Interaction
import com.yunlong.particle.proto.Action as ParticleAction
import com.yunlong.particle.proto.Event as ParticleEvent
import com.yunlong.particle.proto.Modifier as ParticleModifier


@Composable
fun ParticleModifier.Dispatcher(onEvent: (Event) -> Unit): Modifier {
    return Modifier
}

@Composable
fun ParticleModifier.Dispatcher(
    interactions: List<Interaction>? = null,
    onEvent: (Event) -> Unit
): Modifier {
    return interactions?.let {
        Modifier.applyTapEvent(it) { action ->
            onEvent(Event.OnParticleEvent(action))
        }
    } ?: Modifier
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Modifier.applyTapEvent(
    interactions: List<Interaction>,
    onTapped: (List<ParticleAction>) -> Unit
): Modifier {
    var onClickAction: (() -> Unit)? = null
    var onLongPressAction: (() -> Unit)? = null
    interactions.forEach { interaction ->
        interaction.event.find { it == ParticleEvent.TAP_EVENT }?.let {
            onClickAction = { onTapped(interaction.action) }
        }

    }
    interactions.forEach { interaction ->
        interaction.event.find { it == ParticleEvent.LONG_PRESS_EVENT }?.let {
            onLongPressAction = { onTapped(interaction.action) }
        }
    }

    return onClickAction?.let {
        this.combinedClickable(
            onClick = it,
            onLongClick = onLongPressAction
        )
    } ?: this
}
