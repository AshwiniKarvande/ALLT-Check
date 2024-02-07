package org.pravin.alltcheck.repository

import kotlinx.coroutines.flow.Flow
import org.pravin.alltcheck.model.MedicalTest
import java.util.Date

interface MedicalTestRepository {

    suspend fun insertMedicalTests(medicalTests: List<MedicalTest>)

    suspend fun deleteMedicalTest(medicalTest: MedicalTest)

    suspend fun updateMedicalTest(medicalTest: MedicalTest)

    fun getAllMedicalTests(): Flow<List<MedicalTest>>

    fun getMedicalTestsForDate(date: Date): Flow<List<MedicalTest>>
}
