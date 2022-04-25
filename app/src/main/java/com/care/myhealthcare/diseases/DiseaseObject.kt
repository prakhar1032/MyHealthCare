package com.care.myhealthcare.diseases

object DiseaseObject {
    var listData = mutableListOf<DiseaseInfo>()
    fun setData(title : String , description : String) {
        listData.add(DiseaseInfo(title, description))
    }
    fun getAllData() : List<DiseaseInfo>{
        return  listData
    }
    fun deleteAll() {
        listData.clear()
    }
    fun getData(pos : Int) : DiseaseInfo{
        return  listData[pos]
    }
    fun deleteData(pos : Int) { listData.removeAt(pos) }

    fun updateData (pos :Int , title : String ,description : String){
        listData[pos].title= title
        listData[pos].description = description
    }
}