package org.pravin.alltcheck.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.pravin.alltcheck.data.entity.MedicalTestEntity
import java.util.Date

@Dao
interface MedicalTestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedicalTest(medicationEntity: MedicalTestEntity): Long

    @Delete
    suspend fun deleteMedicalTest(medicationEntity: MedicalTestEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateMedicalTest(medicationEntity: MedicalTestEntity)

    @Query(
        """
            SELECT *
            FROM medicalTestEntity
        """
    )
    fun getAllMedicalTests(): Flow<List<MedicalTestEntity>>

    @Query(
        """
            SELECT *
            FROM medicalTestEntity
            WHERE sampleDate > :date
        """
    )
    fun getMedicalTestsForDate(date: Date): Flow<List<MedicalTestEntity>>
}
