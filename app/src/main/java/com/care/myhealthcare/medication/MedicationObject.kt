package com.care.myhealthcare.medication

import com.care.myhealthcare.diseases.DiseaseInfo

object MedicationObject {
    var listData = mutableListOf<MedicationInfo>()
    fun setData(medicineName : String , medicineDescription : String, medicineDate : String , medicineTime : String) {
        listData.add(MedicationInfo(medicineName,medicineDescription,medicineDate,medicineTime))
    }
    fun getAllData() : List<MedicationInfo>{
        return  listData
    }
    fun deleteAll() {
        listData.clear()
    }
    fun getData(pos : Int) : MedicationInfo {
        return  listData[pos]
    }
    fun deleteData(pos : Int) { listData.removeAt(pos) }

    fun updateData (pos :Int , medicineName : String ,medicineDescription : String ,  medicineDate: String, medicineTime : String){
        listData[pos].medicineName=  medicineName
        listData[pos].medicineDescription=  medicineDescription
        listData[pos].medicineDate =  medicineDate
        listData[pos].medicineTime =  medicineTime

    }
}