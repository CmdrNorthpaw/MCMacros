package uk.cmdrnorthpaw.mcmacros.model

import kotlinx.serialization.Serializable

@Serializable
data class Macro(val name: String, val trigger: Trigger, val actions: List<Action>)