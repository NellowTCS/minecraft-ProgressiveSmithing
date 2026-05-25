package me.nellowtcs.progressivesmithing.fabric

import me.nellowtcs.progressivesmithing.registry.ModItems
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.world.item.CreativeModeTab.TabVisibility

object ModCreativeTabFabric {
    private val INGREDIENTS_TAB: ResourceKey<net.minecraft.world.item.CreativeModeTab> =
        ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.withDefaultNamespace("ingredients"))

    fun init() {
        ItemGroupEvents.modifyEntriesEvent(INGREDIENTS_TAB).register { entries ->
            entries.addAfter(
                Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE,
                listOf(
                    ItemStack(ModItems.COPPER_UPGRADE.get()),
                    ItemStack(ModItems.GOLD_UPGRADE.get()),
                    ItemStack(ModItems.CHAIN_UPGRADE.get()),
                    ItemStack(ModItems.IRON_UPGRADE.get()),
                    ItemStack(ModItems.DIAMOND_UPGRADE.get()),
                ),
                TabVisibility.PARENT_AND_SEARCH_TABS,
            )
        }
    }
}