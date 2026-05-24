package me.nellowtcs.progressivesmithing.fabric

import me.nellowtcs.progressivesmithing.ProgressiveSmithing
import net.fabricmc.api.ModInitializer

class ProgressiveSmithingFabric : ModInitializer {
    override fun onInitialize() {
        ProgressiveSmithing.init()
        ModCreativeTabFabric.init()
    }
}
