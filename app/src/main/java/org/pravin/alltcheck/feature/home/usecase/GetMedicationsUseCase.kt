package org.pravin.alltcheck.feature.home.usecase

import org.pravin.alltcheck.repository.MedicalTestRepository
import kotlinx.coroutines.flow.Flow
import org.pravin.alltcheck.model.MedicalTest
import javax.inject.Inject

class GetMedicalTestUseCase @Inject constructor(
    private val repository: MedicalTestRepository
) {

    suspend fun getMedicalTests(): Flow<List<MedicalTest>> {
        return repository.getAllMedicalTests()
    }
}
