package com.rosique.core.database.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RunPendingSyncEntity(
    @Embedded val run: RunEntity,
    @PrimaryKey(autoGenerate = false)
    val runId: String = run.id,
    val mapPictureBytes: ByteArray,
    val userId: String
)