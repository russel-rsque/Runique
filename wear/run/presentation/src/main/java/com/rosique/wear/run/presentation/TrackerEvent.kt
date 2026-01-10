package com.rosique.wear.run.presentation

sealed interface TrackerEvent {
    data object RunFinished: TrackerEvent
}