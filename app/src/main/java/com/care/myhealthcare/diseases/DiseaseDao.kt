package com.care.myhealthcare.diseases

import android.content.Entity
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DiseaseDao {
    @Insert
    suspend fun insertDisease(diseaseEntity: DiseaseEntity)

    @Query("Select * from Diseases")
    suspend fun getDiseases() : List<DiseaseInfo>


    @Delete
    suspend fun  deleteDisease(diseaseEntity: DiseaseEntity)
}