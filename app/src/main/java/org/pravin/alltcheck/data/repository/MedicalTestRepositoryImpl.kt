package org.pravin.alltcheck.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.pravin.alltcheck.data.MedicalTestDao
import org.pravin.alltcheck.model.MedicalTest
import org.pravin.alltcheck.repository.MedicalTestRepository
import java.util.Date

class MedicalTestRepositoryImpl(
    private val dao: MedicalTestDao
) : MedicalTestRepository {

    override suspend fun insertMedicalTests(medications: List<MedicalTest>) {
        medications.map { it.toMedicalTestEntity() }.forEach {
            dao.insertMedicalTest(it)
        }
    }

    override suspend fun deleteMedicalTest(medication: MedicalTest) {
        dao.deleteMedicalTest(medication.toMedicalTestEntity())
    }

    override suspend fun updateMedicalTest(medication: MedicalTest) {
        dao.updateMedicalTest(medication.toMedicalTestEntity())
    }

    override fun getAllMedicalTests(): Flow<List<MedicalTest>> {
        return dao.getAllMedicalTests().map { entities ->
            entities.map { it.toMedicalTest() }
        }
    }

    override fun getMedicalTestsForDate(date: Date): Flow<List<MedicalTest>> {
        return dao.getMedicalTestsForDate(
            date = date
        ).map { entities ->
            entities.map { it.toMedicalTest() }
        }
    }
}
