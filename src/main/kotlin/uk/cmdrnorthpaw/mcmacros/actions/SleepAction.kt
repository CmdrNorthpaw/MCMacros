package uk.cmdrnorthpaw.mcmacros.actions

import kotlinx.coroutines.delay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.minecraft.client.network.ClientPlayerEntity
import net.minecraft.util.ActionResult
import uk.cmdrnorthpaw.mcmacros.model.Action

@Serializable
@SerialName("sleep")
class SleepAction(val time: Int) : Action() {
    override suspend fun act(player: ClientPlayerEntity): ActionResult { delay(time * 50L); return ActionResult.CONSUME }
}