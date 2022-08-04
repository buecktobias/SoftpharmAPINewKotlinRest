package de.softpharm.api.repositories

import de.softpharm.api.data.Drug
import org.springframework.stereotype.Repository

@Repository
interface DrugRepository {
    fun getAllDrugs(): List<Drug>
    fun getAllDrugNames(): List<String>
    fun getDrugByName(name: String): Drug?
    fun initialize() {
       return;
    }

}