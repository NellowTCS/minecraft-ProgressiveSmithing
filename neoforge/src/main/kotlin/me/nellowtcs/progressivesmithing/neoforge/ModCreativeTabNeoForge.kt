package me.nellowtcs.progressivesmithing.neoforge

import kotlin.jvm.JvmStatic
import me.nellowtcs.progressivesmithing.ProgressiveSmithing
import me.nellowtcs.progressivesmithing.registry.ModItems
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTabs
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent

@EventBusSubscriber(modid = ProgressiveSmithing.MOD_ID)
object ModCreativeTabNeoForge {

    @SubscribeEvent
    @JvmStatic
    fun onBuildCreativeTab(event: BuildCreativeModeTabContentsEvent) {
        if (event.tabKey == CreativeModeTabs.INGREDIENTS) {
            event.insertAfter(
                ItemStack(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                ItemStack(ModItems.COPPER_UPGRADE.get()),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            )
            event.insertAfter(
                ItemStack(ModItems.COPPER_UPGRADE.get()),
                ItemStack(ModItems.GOLD_UPGRADE.get()),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            )
            event.insertAfter(
                ItemStack(ModItems.GOLD_UPGRADE.get()),
                ItemStack(ModItems.CHAIN_UPGRADE.get()),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            )
            event.insertAfter(
                ItemStack(ModItems.CHAIN_UPGRADE.get()),
                ItemStack(ModItems.IRON_UPGRADE.get()),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            )
            event.insertAfter(
                ItemStack(ModItems.IRON_UPGRADE.get()),
                ItemStack(ModItems.DIAMOND_UPGRADE.get()),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            )
        }
    }
}
