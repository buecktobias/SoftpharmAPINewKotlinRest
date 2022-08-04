package de.softpharm.api.repositories

import de.softpharm.api.data.Drug

class SimpleDrugRepository(private val drugs :List<Drug>): DrugRepository{
    override fun getAllDrugs(): List<Drug> {
        return this.drugs
    }

    override fun getAllDrugNames(): List<String> {
        return this.drugs.map { drug: Drug -> drug.name }
    }

    override fun getDrugByName(name: String): Drug? {
        val allDrugsWithName = this.drugs.filter { drug:Drug -> drug.name == name }
        if(allDrugsWithName.isEmpty()){
            return null
        }else{
            return allDrugsWithName.first()
        }
    }
}