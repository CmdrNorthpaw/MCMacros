package uk.cmdrnorthpaw.mcmacros.events

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.fabricmc.fabric.api.event.EventFactory
import net.minecraft.client.network.ClientPlayerEntity
import net.minecraft.util.ActionResult
import uk.cmdrnorthpaw.mcmacros.model.Macro

fun interface MacroTriggerCallback {
    fun trigger(trigger: Macro, caller: ClientPlayerEntity): ActionResult

    companion object {
        val EVENT = EventFactory.createArrayBacked(MacroTriggerCallback::class.java) { listeners -> MacroTriggerCallback { macro, caller ->
            listeners.forEach {
                val result = it.trigger(macro, caller)
                if (result != ActionResult.PASS) return@MacroTriggerCallback result
            }
            return@MacroTriggerCallback ActionResult.PASS
        }}
    }
}