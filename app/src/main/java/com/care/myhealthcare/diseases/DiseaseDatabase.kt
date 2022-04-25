package com.care.myhealthcare.diseases

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities =  [DiseaseEntity::class] , version = 1)
 abstract class DiseaseDatabase   : RoomDatabase()  {
     abstract fun dao() : DiseaseDao
}