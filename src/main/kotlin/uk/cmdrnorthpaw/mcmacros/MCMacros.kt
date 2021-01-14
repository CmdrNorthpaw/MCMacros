package uk.cmdrnorthpaw.mcmacros

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.decodeFromString
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.api.ModInitializer
import net.fabricmc.loader.api.FabricLoader
import uk.cmdrnorthpaw.mcmacros.model.Macro
import java.io.File

object MCMacros : ModInitializer {
    override fun onInitialize() {
        TODO("Not yet implemented")
    }
}

@Environment(EnvType.CLIENT)
object MCMacrosClient : ClientModInitializer {
    override fun onInitializeClient() {
        Macros = getMacroList()
    }

    private fun getMacroList(): Array<Macro> {
        val macroList = mutableListOf<Macro>()
        macrosDir.list()?.forEach {
            val file = File(macrosDir, it)
            if (file.name.endsWith(".yml")) macroList.add(Yaml.default.decodeFromString(Macro.serializer(), file.readText()))
        }
        return macroList.toTypedArray()
    }
    val macrosDir = File(FabricLoader.getInstance().gameDir.toFile(), "macros")
}

lateinit var Macros: Array<Macro>