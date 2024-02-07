package org.pravin.alltcheck.data

import androidx.room.Database
import androidx.room.DeleteColumn
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.AutoMigrationSpec
import org.pravin.alltcheck.data.entity.MedicalTestEntity

@Database(
    entities = [MedicalTestEntity::class],
    version = 1,
    autoMigrations = []
)
@TypeConverters(Converters::class)
abstract class MedicalTestDatabase : RoomDatabase() {

    abstract val dao: MedicalTestDao
}
