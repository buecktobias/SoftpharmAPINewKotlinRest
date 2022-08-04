package de.softpharm.api.repositories

import de.softpharm.api.data.Drug
import org.springframework.stereotype.Repository

@Repository
class SimpleDrugRepository(private var drugs: List<Drug>) : DrugRepository {
    override fun initialize() {
        this.drugs = listOf(
            Drug("Sertraline", "SSRI", listOf("Depression", "Angststörung")),
            Drug("Alprazolam", "Benzodiazepine", listOf("Angststörung", "Panikattacke")),
            Drug("Ibuprofen", "NSAID", listOf("Schmerzen", "Fieber"))
        )
    }

    override fun getAllDrugs(): List<Drug> {
        return this.drugs
    }

    override fun getAllDrugNames(): List<String> {
        return this.drugs.map { drug: Drug -> drug.name }
    }

    override fun getDrugByName(name: String): Drug? {
        val allDrugsWithName = this.drugs.filter { drug: Drug -> drug.name == name }
        if (allDrugsWithName.isEmpty()) {
            return null
        } else {
            return allDrugsWithName.first()
        }
    }
}