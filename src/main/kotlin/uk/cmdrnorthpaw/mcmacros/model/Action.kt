package uk.cmdrnorthpaw.mcmacros.model

import kotlinx.serialization.Serializable
import net.minecraft.client.network.ClientPlayerEntity

@Serializable
abstract class Action {
    abstract suspend fun act(player: ClientPlayerEntity)
}