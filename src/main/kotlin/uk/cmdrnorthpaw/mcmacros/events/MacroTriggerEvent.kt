package uk.cmdrnorthpaw.mcmacros.events

import net.fabricmc.fabric.api.event.EventFactory
import net.minecraft.util.ActionResult
import uk.cmdrnorthpaw.mcmacros.model.Macro

fun interface MacroTriggerEvent {
    fun trigger(trigger: Macro): ActionResult

    companion object {
        val EVENT = EventFactory.createArrayBacked(MacroTriggerEvent::class.java) { listeners -> MacroTriggerEvent { macro ->
            listeners.forEach {
                val result = it.trigger(macro)
                if (result != ActionResult.PASS) return@MacroTriggerEvent result
            }
            return@MacroTriggerEvent ActionResult.PASS
        }}
    }
}