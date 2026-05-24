package me.nellowtcs.progressivesmithing

import me.nellowtcs.progressivesmithing.registry.ModItems

object ProgressiveSmithing {
    const val MOD_ID = "progressive_smithing"

    @JvmStatic
    fun init() {
        ModItems.init()
    }
}
