package de.softpharm.api.repositories

import de.softpharm.api.data.Drug

interface DrugRepository {
    public fun getAllDrugs(): List<Drug>
    public fun getAllDrugNames(): List<String>
    public fun getDrugByName(name:String): Drug?
}