package uk.cmdrnorthpaw.mcmacros.actions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.minecraft.client.network.ClientPlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import uk.cmdrnorthpaw.mcmacros.model.Action

@Serializable
@SerialName("print")
class PrintAction(private val message: String) : Action() {
    override suspend fun act(player: ClientPlayerEntity): ActionResult {
        player.sendMessage(Text.of(message), false)
        return ActionResult.CONSUME
    }
}