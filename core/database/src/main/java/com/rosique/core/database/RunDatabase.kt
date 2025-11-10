package com.rosique.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rosique.core.database.dao.RunDao
import com.rosique.core.database.dao.RunPendingSyncDao
import com.rosique.core.database.entity.DeletedRunSyncEntity
import com.rosique.core.database.entity.RunEntity
import com.rosique.core.database.entity.RunPendingSyncEntity

@Database(
    entities = [
        RunEntity::class,
        RunPendingSyncEntity::class,
        DeletedRunSyncEntity::class
    ],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {

    abstract val runDao: RunDao
    abstract val runPendingSyncDao: RunPendingSyncDao
}