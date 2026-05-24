package me.nellowtcs.progressivesmithing.registry

import dev.architectury.registry.registries.DeferredRegister
import dev.architectury.registry.registries.RegistrySupplier
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraft.world.item.SmithingTemplateItem

object ModItems {
    val ITEMS: DeferredRegister<Item> = DeferredRegister.create("progressive_smithing", Registries.ITEM)

    // Template items for each tier transition
    val COPPER_UPGRADE: RegistrySupplier<Item> = ITEMS.register("copper_upgrade_smithing_template") { createTemplate("copper") }
    val GOLD_UPGRADE: RegistrySupplier<Item> = ITEMS.register("gold_upgrade_smithing_template") { createTemplate("gold") }
    val CHAIN_UPGRADE: RegistrySupplier<Item> = ITEMS.register("chain_upgrade_smithing_template") { createTemplate("chainmail") }
    val IRON_UPGRADE: RegistrySupplier<Item> = ITEMS.register("iron_upgrade_smithing_template") { createTemplate("iron") }
    val DIAMOND_UPGRADE: RegistrySupplier<Item> = ITEMS.register("diamond_upgrade_smithing_template") { createTemplate("diamond") }

    fun init() = ITEMS.register()

    private fun createTemplate(tierName: String): Item =
        SmithingTemplateItem(
            Component.translatable("item.progressive_smithing.upgrade_description.$tierName"),
            Component.translatable("item.progressive_smithing.upgrade_base_slot.$tierName"),
            Component.translatable("item.progressive_smithing.upgrade_additions_slot.$tierName"),
            Component.translatable("item.progressive_smithing.upgrade_icon_description.$tierName"),
            Component.translatable("item.progressive_smithing.upgrade_biomes_description.$tierName"),
            listOf(ResourceLocation.withDefaultNamespace("item/empty_slot_helmet")),
            listOf(ResourceLocation.withDefaultNamespace("item/empty_slot_ingot"))
        )
}
