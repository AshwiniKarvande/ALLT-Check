package org.pravin.alltcheck.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.pravin.alltcheck.model.MedicalTest
import java.util.Date

@Entity
data class MedicalTestEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val patientId: String,
    val testType: String,
    val sampleDate: Date = Date(),
    val sampleTime: Date = Date(),
) {
    fun toMedicalTest(): MedicalTest {
        return MedicalTest(
            id = id,
            name = name,
            patientId = patientId,
            testType = testType,
            sampleDate = sampleDate,
            sampleTime = sampleTime,
        )
    }
}
