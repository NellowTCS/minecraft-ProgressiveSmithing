package me.nellowtcs.progressivesmithing.registry

import dev.architectury.registry.registries.DeferredRegister
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTab.TabVisibility
import net.minecraft.world.item.ItemStack

object ModCreativeTab {
    val TABS: DeferredRegister<CreativeModeTab> = DeferredRegister.create("progressive_smithing", Registries.CREATIVE_MODE_TAB)

    val MAIN = TABS.register("main") {
        CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .title(Component.translatable("itemGroup.progressive_smithing"))
            .icon { ItemStack(ModItems.COPPER_UPGRADE.get()) }
            .displayItems { _, output ->
                output.accept(ItemStack(ModItems.COPPER_UPGRADE.get()), TabVisibility.PARENT_AND_SEARCH_TABS)
                output.accept(ItemStack(ModItems.GOLD_UPGRADE.get()), TabVisibility.PARENT_AND_SEARCH_TABS)
                output.accept(ItemStack(ModItems.CHAIN_UPGRADE.get()), TabVisibility.PARENT_AND_SEARCH_TABS)
                output.accept(ItemStack(ModItems.IRON_UPGRADE.get()), TabVisibility.PARENT_AND_SEARCH_TABS)
                output.accept(ItemStack(ModItems.DIAMOND_UPGRADE.get()), TabVisibility.PARENT_AND_SEARCH_TABS)
            }
            .build()
    }

    fun init() = TABS.register()
}