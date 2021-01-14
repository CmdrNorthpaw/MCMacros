package uk.cmdrnorthpaw.mcmacros.actions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.minecraft.client.network.ClientPlayerEntity
import net.minecraft.util.ActionResult
import uk.cmdrnorthpaw.mcmacros.model.Action

@Serializable
@SerialName("chat")
class ChatAction(private val message: String) : Action() {
    override suspend fun act(player: ClientPlayerEntity): ActionResult {
        player.sendChatMessage(message)
        return ActionResult.CONSUME
    }
}