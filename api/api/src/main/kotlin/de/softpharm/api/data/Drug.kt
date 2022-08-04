package de.softpharm.api.data
data class Drug(val name:String, val pharmacologyClass:String, val indicationsList:Collection<String>)