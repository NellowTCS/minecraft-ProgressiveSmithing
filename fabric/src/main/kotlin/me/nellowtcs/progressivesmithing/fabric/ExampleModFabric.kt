package me.nellowtcs.progressivesmithing.fabric

import me.nellowtcs.progressivesmithing.ExampleMod
import net.fabricmc.api.ModInitializer

class ExampleModFabric : ModInitializer {
    override fun onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        ExampleMod.init()
    }
}