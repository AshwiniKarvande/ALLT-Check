package org.pravin.alltcheck.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.pravin.alltcheck.data.entity.MedicalTestEntity
import java.util.Date

@Parcelize
data class MedicalTest(
    val id: Long?,
    val name: String,
    val patientId: String,
    val testType: String,
    val sampleDate: Date,
    val sampleTime: Date
) : Parcelable {
    fun toMedicalTestEntity(): MedicalTestEntity {
        return MedicalTestEntity(
            id = id ?: 0L,
            name = name,
            patientId = patientId,
            testType = testType,
            sampleDate = sampleDate,
            sampleTime = sampleTime,
        )
    }
}
