package de.softpharm.api.controllers

import de.softpharm.api.data.Drug
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/drug")
class DrugDetailInformationController {
    @GetMapping()
    public fun getDrug(): Drug {
        return Drug("Sertraline", "SSRI", listOf("Depression", "Angststörung"))
    }
}