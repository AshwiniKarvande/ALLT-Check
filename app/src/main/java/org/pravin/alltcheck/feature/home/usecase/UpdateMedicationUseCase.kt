package org.pravin.alltcheck.feature.home.usecase

import org.pravin.alltcheck.repository.MedicalTestRepository
import org.pravin.alltcheck.model.MedicalTest
import javax.inject.Inject

class UpdateMedicalTestUseCase @Inject constructor(
    private val repository: MedicalTestRepository
) {

    suspend fun updateMedicalTest(medication: MedicalTest) {
        return repository.updateMedicalTest(medication)
    }
}
