package org.pravin.alltcheck.feature.history.viewmodel

import org.pravin.alltcheck.model.MedicalTest

data class HistoryState(
    val medicalTests: List<MedicalTest> = emptyList()
)
