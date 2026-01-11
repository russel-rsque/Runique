@file:OptIn(InternalSerializationApi::class)

package com.rosique.core.connectivity.data.messaging

import com.rosique.core.connectivity.domain.messaging.MessagingAction
import kotlinx.serialization.InternalSerializationApi

fun MessagingAction.toMessagingActionDto(): MessagingActionDto {
    return when(this) {
        MessagingAction.ConnectionRequest -> MessagingActionDto.ConnectionRequest
        is MessagingAction.DistanceUpdate -> MessagingActionDto.DistanceUpdate(distanceMeters)
        MessagingAction.Finish -> MessagingActionDto.Finish
        is MessagingAction.HeartRateUpdate -> MessagingActionDto.HeartRateUpdate(heartRate)
        MessagingAction.Pause -> MessagingActionDto.Pause
        MessagingAction.StartOrResume -> MessagingActionDto.StartOrResume
        is MessagingAction.TimeUpdate -> MessagingActionDto.TimeUpdate(elapsedDuration)
        MessagingAction.Trackable -> MessagingActionDto.Trackable
        MessagingAction.NotTrackable -> MessagingActionDto.NotTrackable
    }
}

fun MessagingActionDto.toMessagingAction(): MessagingAction {
    return when(this) {
        MessagingActionDto.ConnectionRequest -> MessagingAction.ConnectionRequest
        is MessagingActionDto.DistanceUpdate -> MessagingAction.DistanceUpdate(distanceMeters)
        MessagingActionDto.Finish -> MessagingAction.Finish
        is MessagingActionDto.HeartRateUpdate -> MessagingAction.HeartRateUpdate(heartRate)
        MessagingActionDto.Pause -> MessagingAction.Pause
        MessagingActionDto.StartOrResume -> MessagingAction.StartOrResume
        is MessagingActionDto.TimeUpdate -> MessagingAction.TimeUpdate(elapsedDuration)
        MessagingActionDto.Trackable -> MessagingAction.Trackable
        MessagingActionDto.NotTrackable -> MessagingAction.NotTrackable
    }
}