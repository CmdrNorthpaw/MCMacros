package uk.cmdrnorthpaw.mcmacros.model

import kotlinx.serialization.Serializable
import net.minecraft.client.network.ClientPlayerEntity
import net.minecraft.util.ActionResult

@Serializable
abstract class Action {
    abstract suspend fun act(player: ClientPlayerEntity): ActionResult
}