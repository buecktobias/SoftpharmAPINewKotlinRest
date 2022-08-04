package de.softpharm.api.controllers

import de.softpharm.api.data.Drug
import de.softpharm.api.repositories.DrugRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/drug")
class DrugDetailInformationController(
    @Autowired
    private var drugRepository: DrugRepository
) {
    @GetMapping("/names")
    fun getAllDrugNames(): Collection<String>{
        return this.drugRepository.getAllDrugNames()
    }
    @GetMapping("/detail/{name}")
     fun getDrugByName(@PathVariable("name") name:String): Drug?{
        return this.drugRepository.getDrugByName(name)
    }
    @GetMapping("/all")
    fun getAllDrugs(): List<Drug>{
        return this.drugRepository.getAllDrugs()
    }
}