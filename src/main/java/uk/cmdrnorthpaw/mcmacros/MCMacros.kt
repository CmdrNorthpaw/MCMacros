package uk.cmdrnorthpaw.mcmacros

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.api.ModInitializer
import net.fabricmc.loader.api.FabricLoader
import java.io.File

object MCMacros : ModInitializer {
    override fun onInitialize() {
        TODO("Not yet implemented")
    }

    val macrosDir = File(FabricLoader.getInstance().gameDir.toFile(), "macros").mkdir()
}

@Environment(EnvType.CLIENT)
object MCMacrosClient : ClientModInitializer {
    override fun onInitializeClient() {
        TODO("Not yet implemented")
    }
}
