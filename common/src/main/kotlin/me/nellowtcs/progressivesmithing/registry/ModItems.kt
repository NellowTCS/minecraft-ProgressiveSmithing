package me.nellowtcs.progressivesmithing.registry

import dev.architectury.registry.registries.DeferredRegister
import dev.architectury.registry.registries.RegistrySupplier
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraft.world.item.Rarity
import net.minecraft.world.item.SmithingTemplateItem
import net.minecraft.ChatFormatting

object ModItems {
    private const val MOD_ID = "progressive_smithing"
    private val BASE_SLOT_ICONS = listOf(
        ResourceLocation.withDefaultNamespace("container/slot/helmet"),
        ResourceLocation.withDefaultNamespace("container/slot/chestplate"),
        ResourceLocation.withDefaultNamespace("container/slot/leggings"),
        ResourceLocation.withDefaultNamespace("container/slot/boots"),
        ResourceLocation.withDefaultNamespace("container/slot/sword"),
        ResourceLocation.withDefaultNamespace("container/slot/pickaxe"),
        ResourceLocation.withDefaultNamespace("container/slot/axe"),
        ResourceLocation.withDefaultNamespace("container/slot/shovel"),
        ResourceLocation.withDefaultNamespace("container/slot/hoe"),
    )
    private val INGREDIENT_SLOT_ICON = listOf(ResourceLocation.withDefaultNamespace("container/slot/ingot"))

    val ITEMS: DeferredRegister<Item> = DeferredRegister.create("progressive_smithing", Registries.ITEM)

    // Template items for each tier transition
    val COPPER_UPGRADE: RegistrySupplier<Item> = ITEMS.register("copper_upgrade_smithing_template") { createTemplate("copper_upgrade_smithing_template", "copper") }
    val GOLD_UPGRADE: RegistrySupplier<Item> = ITEMS.register("gold_upgrade_smithing_template") { createTemplate("gold_upgrade_smithing_template", "gold") }
    val CHAIN_UPGRADE: RegistrySupplier<Item> = ITEMS.register("chainmail_upgrade_smithing_template") { createTemplate("chainmail_upgrade_smithing_template", "chainmail") }
    val IRON_UPGRADE: RegistrySupplier<Item> = ITEMS.register("iron_upgrade_smithing_template") { createTemplate("iron_upgrade_smithing_template", "iron") }
    val DIAMOND_UPGRADE: RegistrySupplier<Item> = ITEMS.register("diamond_upgrade_smithing_template") { createTemplate("diamond_upgrade_smithing_template", "diamond") }

    fun init() = ITEMS.register()

    private fun createTemplate(registryName: String, tierName: String): Item =
        SmithingTemplateItem(
            Component.translatable("item.progressive_smithing.smithing_template.${tierName}_upgrade.applies_to")
                .withStyle(ChatFormatting.BLUE),
            Component.translatable("item.progressive_smithing.smithing_template.${tierName}_upgrade.ingredients")
                .withStyle(ChatFormatting.BLUE),
            Component.translatable("item.progressive_smithing.smithing_template.${tierName}_upgrade.base_slot_description"),
            Component.translatable("item.progressive_smithing.smithing_template.${tierName}_upgrade.additions_slot_description"),
            BASE_SLOT_ICONS,
            INGREDIENT_SLOT_ICON,
            Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, registryName)))
                .rarity(Rarity.UNCOMMON)
        )
}
