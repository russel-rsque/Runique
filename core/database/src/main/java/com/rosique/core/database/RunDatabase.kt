package com.rosique.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rosique.core.database.dao.RunDao
import com.rosique.core.database.entity.RunEntity

@Database(
    entities = [RunEntity::class],
    version = 1
)
abstract class RunDatabase: RoomDatabase() {

    abstract val runDao: RunDao
}