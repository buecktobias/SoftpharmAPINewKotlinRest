package de.softpharm.api.controllers

import de.softpharm.api.data.Drug
import de.softpharm.api.repositories.DrugRepository
import de.softpharm.api.repositories.SimpleDrugRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DrugDetailInformationControllerTest() {
    private lateinit var drugDetailInformationController: DrugDetailInformationController
    private lateinit var drugs: List<Drug>
    @BeforeEach
    fun setUp() {
        this.drugs = listOf(
            Drug("Lorazepam", "Benzodiazepine", listOf("Angsstörung", "Panikattacke")),
            Drug("Morphium", "Opioid", listOf("Schmerzen", "Narkose"))
            )
        val repository = SimpleDrugRepository(drugs)
        this.drugDetailInformationController = DrugDetailInformationController(repository)
    }

    @Test
    fun getAllDrugNames() {
        val controllerResult = this.drugDetailInformationController.getAllDrugNames()
        assertEquals(controllerResult, listOf("Lorazepam", "Morphium"))
    }

    @Test
    fun getDrugByName() {
        val drugMorphium = this.drugDetailInformationController.getDrugByName("Morphium")
        val drugNotExistent = this.drugDetailInformationController.getDrugByName("Dieses Medikament gibt es nicht")
        assertNotNull(drugMorphium)
        assertNull(drugNotExistent)
        if (drugMorphium != null) {
            assertEquals(drugMorphium.pharmacologyClass, "Opioid")
        }
    }

    @Test
    fun getAllDrugs() {
        val controllerResult = this.drugDetailInformationController.getAllDrugs()
        assertEquals(controllerResult, drugs)
    }
}