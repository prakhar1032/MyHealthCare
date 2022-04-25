package com.care.myhealthcare.diseases

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Diseases")
class DiseaseEntity (
        @PrimaryKey(autoGenerate = true)
          var id : Int ,
          var title : String,
         var description : String
        )