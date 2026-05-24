package me.nellowtcs.progressivesmithing

import me.nellowtcs.progressivesmithing.loot.ModLoot
import me.nellowtcs.progressivesmithing.registry.ModCreativeTab
import me.nellowtcs.progressivesmithing.registry.ModItems

object ProgressiveSmithing {
    const val MOD_ID = "progressive_smithing"
    const val RECIPE_PATH = "progressive_smithing"

    @JvmStatic
    fun init() {
        ModItems.init()
        ModCreativeTab.init()
        ModLoot.init()
    }
}
