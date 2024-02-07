package org.pravin.alltcheck.data

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.pravin.alltcheck.data.repository.MedicalTestRepositoryImpl
import org.pravin.alltcheck.repository.MedicalTestRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MedicalTestDataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideMedicationDatabase(app: Application): MedicalTestDatabase {
        return Room.databaseBuilder(
            app,
            MedicalTestDatabase::class.java,
            "medical_test_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideMedicationRepository(
        db: MedicalTestDatabase
    ): MedicalTestRepository {
        return MedicalTestRepositoryImpl(
            dao = db.dao
        )
    }
}
